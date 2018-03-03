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
import gjp.com.wzmanager.MyApplication;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.adapter.SqbAdapter;
import gjp.com.wzmanager.bean.SqbBean;
import gjp.com.wzmanager.contract.SqbContract;
import gjp.com.wzmanager.presenter.SqbPresenter;
import gjp.com.wzmanager.util.AllUrl;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.ProgressDialogUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

public class SqbActivity extends BaseActivity implements SqbContract.View {

    @BindView(R.id.header_title)
    TextView headerTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.rv_sqb)
    LRecyclerView rvSqb;

    private SqbContract.Presenter presenter;
    private String url,url1;
    private String sqmsbm;
    private String sqbm_id;
    private String sqr;
    private String usercode;
    private String startDate;
    private String endDate;
    private int currentPage = 1;
    private int pageSize = 10;

    private int flag;
    private String search;

    private String title;

    private List<SqbBean> sqbBeanList = new ArrayList<>();
    private SqbAdapter adapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqb);
        ButterKnife.bind(this);
        url = SharedPreferencesUtil.getStringData(this, "setUrl", null) + AllUrl.SQB_URL;
        url1 = SharedPreferencesUtil.getStringData(this, "setUrl", null) + AllUrl.SEARCH_SQB_URL;
        usercode = SharedPreferencesUtil.getStringData(this, "usercode", "0000");
        Intent intent = getIntent();
        flag=intent.getIntExtra("flag",-1);
        Log.e("LOG","onCreate(SqbActivity.java:80)=flag=="+flag);
        if (flag==0) {
            sqbBeanList = (List<SqbBean>) intent.getSerializableExtra("sqbBeanList");
            sqmsbm = intent.getStringExtra("sqmsbm");
            sqbm_id = intent.getStringExtra("sqbm_id");
            sqr = intent.getStringExtra("sqr");
            startDate = intent.getStringExtra("startDate");
            endDate = intent.getStringExtra("endDate");

        }
        else {
            search = intent.getStringExtra("search");
        }
        presenter = new SqbPresenter(this);
        init();
        //presenter.getSqb(url, sqmsbm, sqbm_id, sqr, usercode, startDate, endDate, currentPage, pageSize);
        setListener();
    }

    private void setListener() {
        rvSqb.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                sqbBeanList.clear();
                adapter = null;
                mLRecyclerViewAdapter.notifyDataSetChanged();//必须调用此方法
                currentPage = 1;
                if (flag==0) {
                    presenter.getSqb(url, sqmsbm, sqbm_id, sqr, usercode, startDate, endDate, currentPage, pageSize);
                }else {
                    presenter.getSearchSqb(url1, search, usercode, currentPage, pageSize);
                }
            }
        });
        rvSqb.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                currentPage++;
                if (flag==0) {
                    presenter.getSqb(url, sqmsbm, sqbm_id, sqr, usercode, startDate, endDate, currentPage, pageSize);
                }else {
                    presenter.getSearchSqb(url1, search, usercode, currentPage, pageSize);
                }
            }
        });
    }

    private void init() {
        ivBack.setVisibility(View.VISIBLE);
        if ("001".equals(sqmsbm)) {
            title = "采购申请单";
        } else if ("002".equals(sqmsbm)) {
            title = "领用申请单";
        } else if ("003".equals(sqmsbm)) {
            title = "借用申请单";
        } else if ("004".equals(sqmsbm)) {
            title = "销售申请单";
        } else if ("005".equals(sqmsbm)) {
            title = "租用申请单";
        } else if ("006".equals(sqmsbm)) {
            title = "调入申请单";
        } else if ("007".equals(sqmsbm)) {
            title = "调出申请单";
        } else {
            title = "搜索结果";
        }
        headerTitle.setText(title);
        if (flag==0){
        setAdapter();
        }
        else {
            ProgressDialogUtils.showProgressDialog(this,"正在加载...");
            presenter.getSearchSqb(url1, search, usercode, currentPage, pageSize);
        }
    }

    @Override
    public void getSqbSuccess(List<SqbBean> list) {
        ProgressDialogUtils.dismissProgressDialog();
        sqbBeanList.addAll(list);
        Log.e("LOG", "getSqbSuccess(SqbActivity.java:72)===" + sqbBeanList.size());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setAdapter();
            }
        });

    }

    private void setAdapter() {
        rvSqb.refreshComplete(0);
        if (mLRecyclerViewAdapter == null) {
            Log.e("LOG", "setAdapter(EmployeeActivity.java:112)===" + 1);
            adapter = new SqbAdapter(sqbBeanList);
            mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
            rvSqb.setAdapter(mLRecyclerViewAdapter);
            LinearLayoutManager lm = new LinearLayoutManager(SqbActivity.this);
            rvSqb.setLayoutManager(lm);
         /*   rvEmployee.addItemDecoration(new RecycleViewDivider(
                    EmployeeActivity.this, LinearLayoutManager.HORIZONTAL, 2, R.color.colorPrimary));*/
            DividerDecoration divider = new DividerDecoration.Builder(MyApplication.getContext())
                    .setHeight(R.dimen.fgx)
                    .setPadding(R.dimen.fgx)
                    .setColorResource(R.color.red)
                    .build();
            //mRecyclerView.setHasFixedSize(true);
            rvSqb.addItemDecoration(divider);
            rvSqb.setRefreshProgressStyle(ProgressStyle.LineSpinFadeLoader);
            rvSqb.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
            rvSqb.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
            //设置头部加载颜色
            rvSqb.setHeaderViewColor(R.color.colorAccent, R.color.blue_size, android.R.color.white);
            //设置底部加载颜色
            rvSqb.setFooterViewColor(R.color.colorAccent, R.color.blue_size, android.R.color.white);
            //设置底部加载文字提示
            rvSqb.setFooterViewHint("拼命加载中", "已经全部为你呈现了", "网络不给力啊，点击再试一次吧");

        } else {
            mLRecyclerViewAdapter.notifyDataSetChanged();
        }
        mLRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                SqbBean sqbBean=sqbBeanList.get(position);
                sqmsbm=sqbBean.getSqmsbm();
                Class<?> cls = null;
                if ("001".equals(sqmsbm)) {
                    cls=SqbmxActivity.class;
                } else if ("002".equals(sqmsbm)) {
                    cls=SqbLyActivity.class;
                } else if ("003".equals(sqmsbm)) {
                    cls=SqbJyActivity.class;
                } else if ("004".equals(sqmsbm)) {
                    cls=SqbXsActivity.class;
                } else if ("005".equals(sqmsbm)) {
                    cls=SqbZyActivity.class;
                } else if ("006".equals(sqmsbm)) {
                    cls=SqbDrActivity.class;
                } else if ("007".equals(sqmsbm)) {
                    cls=SqbDrActivity.class;
                }
                Intent intent=new Intent(SqbActivity.this,cls);
              /*  intent.putExtra("keyvalue",sqbBean.getSqdh());
                intent.putExtra("module",sqbBean.getSqmsbm());*/
               Bundle bundle=new Bundle();
                bundle.putSerializable("sqbBean",sqbBean);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getSqbFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        Log.e("LOG", "getSqbFailed(SqbActivity.java:154)===" + 1);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (AllUrl.NETWORK_ERROR.equals(errorMessage)&&currentPage!=1) {
                    Log.e("LOG", "run(SqbActivity.java:159)===" + 1);
                    rvSqb.setOnNetWorkErrorListener(new OnNetWorkErrorListener() {
                        @Override
                        public void reload() {
                            presenter.getSqb(url, sqmsbm, sqbm_id, sqr, usercode, startDate, endDate, currentPage, pageSize);
                        }
                    });
                } else {
                    if (currentPage == 1) {
                        Log.e("LOG", "run(SqbActivity.java:168)===" + 4);
                        BaseUtil.myToast(errorMessage);
                    } else {
                        Log.e("LOG", "run(SqbActivity.java:170)===" + 3);
                        rvSqb.setNoMore(true);
                    }
                }
            }
        });
    }

    @Override
    public void getSearchSqbSuccess(List<SqbBean> list) {
        sqbBeanList.addAll(list);
        Log.e("LOG", "getSqbSuccess(SqbActivity.java:72)===" + sqbBeanList.size());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ProgressDialogUtils.dismissProgressDialog();
                setAdapter();
            }
        });
    }

    @Override
    public void geSearchSqbFailed(final String errorMessage) {
        Log.e("LOG", "getSqbFailed(SqbActivity.java:154)===" + 1);
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ProgressDialogUtils.dismissProgressDialog();
                if (AllUrl.NETWORK_ERROR.equals(errorMessage)&&currentPage!=1) {
                    Log.e("LOG", "run(SqbActivity.java:159)===" + 1);
                    rvSqb.setOnNetWorkErrorListener(new OnNetWorkErrorListener() {
                        @Override
                        public void reload() {
                            presenter.getSearchSqb(url1, search, usercode, currentPage, pageSize);
                        }
                    });
                } else {
                    if (currentPage == 1) {
                        Log.e("LOG", "run(SqbActivity.java:168)===" + 4);
                        BaseUtil.myToast(errorMessage);
                    } else {
                        Log.e("LOG", "run(SqbActivity.java:170)===" + 3);
                        rvSqb.setNoMore(true);
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
