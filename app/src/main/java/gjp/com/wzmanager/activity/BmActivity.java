package gjp.com.wzmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.adapter.BmAdapter;
import gjp.com.wzmanager.adapter.RecycleViewDivider;
import gjp.com.wzmanager.bean.BmBean;
import gjp.com.wzmanager.contract.BmContract;
import gjp.com.wzmanager.presenter.BmPresenter;
import gjp.com.wzmanager.util.AllUrl;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.ProgressDialogUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;


public class BmActivity extends BaseActivity implements BmContract.View {

    @BindView(R.id.header_title)
    TextView headerTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.rv_bm)
    RecyclerView rvBm;

    private BmContract.Presenter presenter;
    private BmAdapter bmAdapter;
    private List<BmBean> bmBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bm);
        ButterKnife.bind(this);
        init();
        presenter = new BmPresenter(this);
        String url = SharedPreferencesUtil.getStringData(this, "setUrl", null) + AllUrl.BM_URL;
        String usercode = SharedPreferencesUtil.getStringData(this, "usercode", "0000");
        ProgressDialogUtils.showProgressDialog(this,"正在加载...");
        presenter.getBm(url, usercode);
    }

    private void init() {
        headerTitle.setText("请选择部门");
        ivBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void getBmSuccess(List<BmBean> list) {
        ProgressDialogUtils.dismissProgressDialog();
        bmBeanList = list;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.e("LOG", "run(BmActivity.java:59)===" + bmBeanList.size());
                setAdapter();
                setListener();
            }
        });
    }

    private void setAdapter() {
        if (bmAdapter==null){
            bmAdapter = new BmAdapter(R.layout.item_bm, bmBeanList);
            //设置布局管理者
            rvBm.setLayoutManager(new LinearLayoutManager(BmActivity.this));
            rvBm.addItemDecoration(new RecycleViewDivider(
                    BmActivity.this, LinearLayoutManager.HORIZONTAL, 2, R.color.colorPrimary));
            rvBm.setAdapter(bmAdapter);
        }else {
            bmAdapter.notifyDataSetChanged();
        }
    }

    private void setListener() {
        bmAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BmBean bmBean = bmBeanList.get(position);
                //数据是使用Intent返回
                Intent intent = new Intent();
                //把返回数据存入Intent
                intent.putExtra("result", bmBean);
                //设置返回数据
                BmActivity.this.setResult(RESULT_OK, intent);
                //关闭Activity
                BmActivity.this.finish();

            }
        });
    }

    @Override
    public void getBmFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                BaseUtil.myToast(errorMessage);
            }
        });

    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
