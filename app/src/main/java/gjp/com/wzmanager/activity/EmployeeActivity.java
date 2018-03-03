package gjp.com.wzmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.DividerDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.adapter.EmployeeAdapter;
import gjp.com.wzmanager.bean.EmployeeBean;
import gjp.com.wzmanager.contract.EmployeeContract;
import gjp.com.wzmanager.presenter.EmployeePresenter;
import gjp.com.wzmanager.util.AllUrl;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.ProgressDialogUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

public class EmployeeActivity extends BaseActivity implements EmployeeContract.View {

    @BindView(R.id.header_title)
    TextView headerTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.rv_employee)
    LRecyclerView rvEmployee;

    private EmployeeContract.Presenter presenter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;
    private EmployeeAdapter adapter;
   // private EAdapter adapter;
    private List<EmployeeBean> employeeBeanList=new ArrayList<>();
    private int currentPage=1;
    private int pageSize=20;
    private String bm_id;
    private String url;
    private String usercode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        ButterKnife.bind(this);
        init();
        ProgressDialogUtils.showProgressDialog(this,"正在加载...");
        bm_id=getIntent().getStringExtra("bm_id");
        url = SharedPreferencesUtil.getStringData(this, "setUrl", null) + AllUrl.EMPLOYEE_URL;
        usercode = SharedPreferencesUtil.getStringData(this, "usercode", "0000");
        presenter=new EmployeePresenter(this);
        presenter.getEmployee(url,usercode,bm_id,currentPage,pageSize);
        setListener();
    }

    private void setListener() {
        rvEmployee.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                employeeBeanList.clear();
                adapter=null;
                mLRecyclerViewAdapter.notifyDataSetChanged();//必须调用此方法
                currentPage=1;
                presenter.getEmployee(url,usercode,bm_id,currentPage,pageSize);

            }
        });
        rvEmployee.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                currentPage++;
                presenter.getEmployee(url,usercode,bm_id,currentPage,pageSize);
            }
        });
    }

    private void init() {
        headerTitle.setText("请选择申请人");
    }

    @Override
    public void getEmployeeSuccess(List<EmployeeBean> list) {
        ProgressDialogUtils.dismissProgressDialog();
        Log.e("LOG","getEmployeeSuccess(EmployeeActivity.java:99)==="+list.size());
        employeeBeanList.addAll(list);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setAdapter();
            }
        });
    }

    private void setAdapter() {
        rvEmployee.refreshComplete(0);
        if (mLRecyclerViewAdapter==null){
            Log.e("LOG","setAdapter(EmployeeActivity.java:112)==="+1);
            adapter=new EmployeeAdapter(employeeBeanList);
            mLRecyclerViewAdapter=new LRecyclerViewAdapter(adapter);
            rvEmployee.setAdapter(mLRecyclerViewAdapter);
            LinearLayoutManager lm = new LinearLayoutManager(EmployeeActivity.this);
            rvEmployee.setLayoutManager(lm);
         /*   rvEmployee.addItemDecoration(new RecycleViewDivider(
                    EmployeeActivity.this, LinearLayoutManager.HORIZONTAL, 2, R.color.colorPrimary));*/
            DividerDecoration divider = new DividerDecoration.Builder(EmployeeActivity.this)
                    .setHeight(R.dimen.fgx)
                    .setPadding(R.dimen.fgx)
                    .setColorResource(R.color.red)
                    .build();
            //mRecyclerView.setHasFixedSize(true);
            rvEmployee.addItemDecoration(divider);
            rvEmployee.setRefreshProgressStyle(ProgressStyle.LineSpinFadeLoader);
            rvEmployee.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
            rvEmployee.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
            //设置头部加载颜色
            rvEmployee.setHeaderViewColor(R.color.colorAccent, R.color.blue_size ,android.R.color.white);
            //设置底部加载颜色
            rvEmployee.setFooterViewColor(R.color.colorAccent, R.color.blue_size ,android.R.color.white);
            //设置底部加载文字提示
            rvEmployee.setFooterViewHint("拼命加载中","已经全部为你呈现了","网络不给力啊，点击再试一次吧");

        }else {
            Log.e("LOG","setAdapter(EmployeeActivity.java:112)==="+2);
            mLRecyclerViewAdapter.notifyDataSetChanged();
        }
        Log.e("LOG","setAdapter(EmployeeActivity.java:112)==="+3);
        mLRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                EmployeeBean employeeBean = employeeBeanList.get(position);
                //数据是使用Intent返回
                Intent intent = new Intent();
                //把返回数据存入Intent
                intent.putExtra("result", employeeBean);
                //设置返回数据
                EmployeeActivity.this.setResult(RESULT_OK, intent);
                //关闭Activity
                EmployeeActivity.this.finish();
            }
        });
    }

    @Override
    public void getEmployeeFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        Log.e("LOG","getEmployeeFailed(EmployeeActivity.java:166)==="+3);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (AllUrl.NETWORK_ERROR.equals(errorMessage)){
                    Log.e("LOG","getEmployeeFailed(EmployeeActivity.java:166)==="+2);
                    rvEmployee.setOnNetWorkErrorListener(new OnNetWorkErrorListener() {
                        @Override
                        public void reload() {
                            presenter.getEmployee(url,usercode,bm_id,currentPage,pageSize);
                        }
                    });
                }else {
                    if (currentPage==1){
                        BaseUtil.myToast(errorMessage);
                    }else {
                    Log.e("LOG","run(EmployeeActivity.java:177)==="+1);
                    rvEmployee.setNoMore(true);
                    }
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
