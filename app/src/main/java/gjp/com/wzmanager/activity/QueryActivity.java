package gjp.com.wzmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.bean.BmBean;
import gjp.com.wzmanager.bean.EmployeeBean;
import gjp.com.wzmanager.bean.SqbBean;
import gjp.com.wzmanager.contract.SqbContract;
import gjp.com.wzmanager.presenter.SqbPresenter;
import gjp.com.wzmanager.util.AllUrl;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.DateUtil;
import gjp.com.wzmanager.util.ProgressDialogUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;
import gjp.com.wzmanager.util.ShowDatePicker;

public class QueryActivity extends BaseActivity implements SqbContract.View {

    @BindView(R.id.header_title)
    TextView headerTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.tv_query_startDate)
    TextView tvQueryStartDate;
    @BindView(R.id.tv_query_endDate)
    TextView tvQueryEndDate;
    @BindView(R.id.tv_query_bm)
    TextView tvQueryBm;
    @BindView(R.id.tv_query_r)
    TextView tvQueryR;
    @BindView(R.id.btn_query_yes)
    TextView btnQueryYes;
    @BindView(R.id.iv_query_delete_bm)
    ImageView ivQueryDeleteBm;
    @BindView(R.id.iv_query_delete_r)
    ImageView ivQueryDeleteR;

    private BmBean bmBean = new BmBean();
    private EmployeeBean employeeBean = new EmployeeBean();

    private SqbContract.Presenter presenter;
    private List<SqbBean> sqbBeanList = new ArrayList<>();
    private String url;
    private String sqmsbm;
    private String sqbm_id;
    private String sqr;
    private String usercode;
    private String startDate;
    private String endDate;
    private int currentPage = 1;
    private int pageSize = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        ButterKnife.bind(this);
        init();
        presenter = new SqbPresenter(this);
    }

    private void init() {
        ivBack.setVisibility(View.VISIBLE);
        sqmsbm = getIntent().getStringExtra("sqmsbm");
        tvQueryStartDate.setText(DateUtil.dateNow1());
        tvQueryEndDate.setText(DateUtil.dateNow());
        url = SharedPreferencesUtil.getStringData(this, "setUrl", null) + AllUrl.SQB_URL;
        usercode = SharedPreferencesUtil.getStringData(this, "usercode", "0000");
        String title="";
        if ("001".equals(sqmsbm)) {
            title="采购申请查询";
        } else if ("002".equals(sqmsbm)) {
            title="领用申请查询";
        } else if ("003".equals(sqmsbm)) {
            title="借用申请查询";
        } else if ("004".equals(sqmsbm)) {
            title="销售申请查询";
        } else if ("005".equals(sqmsbm)) {
            title="租用申请查询";
        } else if ("006".equals(sqmsbm)) {
            title="调入申请查询";
        } else if ("007".equals(sqmsbm)) {
            title="调出申请查询";
        }
        headerTitle.setText(title);

    }

    @OnClick({R.id.iv_back, R.id.tv_query_startDate, R.id.tv_query_endDate, R.id.tv_query_bm, R.id.tv_query_r, R.id.btn_query_yes,R.id.iv_query_delete_bm,R.id.iv_query_delete_r})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_query_startDate:
                ShowDatePicker.showDatePicker(tvQueryStartDate, QueryActivity.this);
                break;
            case R.id.tv_query_endDate:
                ShowDatePicker.showDatePicker(tvQueryEndDate, QueryActivity.this);
                break;
            case R.id.tv_query_bm:
                Intent intent1 = new Intent(QueryActivity.this, BmActivity.class);
                startActivityForResult(intent1, 1);
                break;
            case R.id.tv_query_r:
                Intent intent2 = new Intent(QueryActivity.this, EmployeeActivity.class);
                intent2.putExtra("bm_id", bmBean.getBm_id());
                startActivityForResult(intent2, 2);
                break;
            case R.id.btn_query_yes:
                ProgressDialogUtils.showProgressDialog(this,"正在加载...");
                sqbm_id = bmBean.getBm_id();
                sqr = employeeBean.getEm_name();
                startDate = tvQueryStartDate.getText().toString().trim();
                endDate = tvQueryEndDate.getText().toString().trim();
                presenter.getSqb(url, sqmsbm, sqbm_id, sqr, usercode, startDate, endDate, currentPage, pageSize);
                break;
            case R.id.iv_query_delete_bm:
                bmBean.setBm_id("");
                bmBean.setBm_name("");
                tvQueryBm.setText("");
                ivQueryDeleteBm.setVisibility(View.GONE);
                break;
            case R.id.iv_query_delete_r:
                employeeBean.setEm_code("");
                employeeBean.setEm_name("");
                tvQueryR.setText("");
                ivQueryDeleteR.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("LOG", "onActivityResult(QueryActivity.java:97)===" + requestCode + "--" + resultCode);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                bmBean = (BmBean) data.getExtras().getSerializable("result");
                tvQueryBm.setText(bmBean.getBm_name());
                ivQueryDeleteBm.setVisibility(View.VISIBLE);
                employeeBean.setEm_code("");
                employeeBean.setEm_name("");
                tvQueryR.setText("");
                ivQueryDeleteR.setVisibility(View.GONE);

            } else if (requestCode == 2) {
                employeeBean = (EmployeeBean) data.getExtras().getSerializable("result");
                tvQueryR.setText(employeeBean.getEm_name());
                ivQueryDeleteR.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void getSqbSuccess(List<SqbBean> list) {
        ProgressDialogUtils.dismissProgressDialog();
        sqbBeanList = list;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent3 = new Intent(QueryActivity.this, SqbActivity.class);
                Bundle bundle = new Bundle();
                intent3.putExtra("flag",0);
                bundle.putSerializable("sqbBeanList", (Serializable) sqbBeanList);
                bundle.putString("sqmsbm", sqmsbm);
                bundle.putString("sqbm_id", bmBean.getBm_id());
                bundle.putString("sqr", employeeBean.getEm_name());
                bundle.putString("startDate", tvQueryStartDate.getText().toString().trim());
                bundle.putString("endDate", tvQueryEndDate.getText().toString().trim());
                intent3.putExtras(bundle);
                startActivity(intent3);
            }
        });


    }

    @Override
    public void getSqbFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                BaseUtil.myToast(errorMessage);
            }
        });

    }

    @Override
    public void getSearchSqbSuccess(List<SqbBean> list) {

    }

    @Override
    public void geSearchSqbFailed(String errorMessage) {

    }

}
