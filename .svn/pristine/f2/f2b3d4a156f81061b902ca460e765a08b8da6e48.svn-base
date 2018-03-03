package gjp.com.wzmanager.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gjp.com.wzmanager.MyApplication;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.adapter.BxmxAdapter;
import gjp.com.wzmanager.adapter.RecycleViewDivider;
import gjp.com.wzmanager.bean.AudirecordBean;
import gjp.com.wzmanager.bean.BxMxBean;
import gjp.com.wzmanager.bean.FeeaskBean;
import gjp.com.wzmanager.bean.FeeaskMxBean;
import gjp.com.wzmanager.contract.ABxmxContract;
import gjp.com.wzmanager.param.AudirecordMxParam;
import gjp.com.wzmanager.presenter.ABxmxPresenter;
import gjp.com.wzmanager.util.AllUrl;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.ProgressDialogUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

public class ABxMxActivity extends BaseActivity implements ABxmxContract.View {

    @BindView(R.id.header_title)
    TextView headerTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_sqbmx_shzt_zd)
    TextView tvSqbmxShztZd;
    @BindView(R.id.tv_sqbmx_shzt_dsz)
    TextView tvSqbmxShztDsz;
    @BindView(R.id.tv_sqbmx_shzt_shz)
    TextView tvSqbmxShztShz;
    @BindView(R.id.tv_sqbmx_shzt_shwc)
    TextView tvSqbmxShztShwc;
    @BindView(R.id.ll_sqbmx_shzt)
    LinearLayout llSqbmxShzt;
    @BindView(R.id.tv_zc_mx_bx_sqdh)
    TextView tvZcMxBxSqdh;
    @BindView(R.id.tv_zc_mx_bx_bm)
    TextView tvZcMxBxBm;
    @BindView(R.id.tv_zc_mx_bx_lkr)
    TextView tvZcMxBxLkr;
    @BindView(R.id.tv_zc_mx_bx_zffs)
    TextView tvZcMxBxZffs;
    @BindView(R.id.tv_zc_mx_bx_sqrq)
    TextView tvZcMxBxSqrq;
    @BindView(R.id.rv_bx)
    RecyclerView rvBx;
    @BindView(R.id.tv_zc_mx_bx_foot_hjje)
    TextView tvZcMxBxFootHjje;
    @BindView(R.id.tv_zc_mx_bx_foot_khh)
    TextView tvZcMxBxFootKhh;
    @BindView(R.id.tv_zc_mx_bx_foot_skrmc)
    TextView tvZcMxBxFootSkrmc;
    @BindView(R.id.tv_zc_mx_bx_foot_yhzh)
    TextView tvZcMxBxFootYhzh;
    @BindView(R.id.tv_zc_mx_bx_foot_bz)
    TextView tvZcMxBxFootBz;
    @BindView(R.id.tv_zc_mx_bx_foot_zdrq)
    TextView tvZcMxBxFootZdrq;
    @BindView(R.id.tv_zc_mx_bx_foot_zdr)
    TextView tvZcMxBxFootZdr;
    @BindView(R.id.tv_zc_mx_bx_foot_zdbm)
    TextView tvZcMxBxFootZdbm;

    private ABxmxContract.Presenter presenter;
    private String url;
    private String usercode;
    private String sqdh;
    private String module;
    private String modulec;
    private String shzt;
    private AudirecordMxParam param = new AudirecordMxParam();
    private FeeaskBean feeaskBean = new FeeaskBean();
    private List<FeeaskMxBean> feeaskMxBeanList = new ArrayList<>();
    private AudirecordBean audirecordBean = new AudirecordBean();
    private BxmxAdapter adapter;
    private int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abx_mx);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        flag=intent.getIntExtra("flag",flag);
        audirecordBean = (AudirecordBean) intent.getSerializableExtra("audirecordBean");
        sqdh = audirecordBean.getKeyvalue();
        module = audirecordBean.getModule();
        url = SharedPreferencesUtil.getStringData(this, "setUrl", null) + AllUrl.AUDIRECORDMX_URL;
        usercode = SharedPreferencesUtil.getStringData(this, "usercode", "0000");
        init();
        ProgressDialogUtils.showProgressDialog(this, "正在加载...");
        param.setUsercode(usercode);
        param.setKeyvalue(sqdh);
        param.setModule(module);
        presenter = new ABxmxPresenter(this);
        presenter.getBxmx(url, param);
    }

    private void init() {
        ivBack.setVisibility(View.VISIBLE);
        headerTitle.setText("费用报销");
    }

    @Override
    public void getBxmxSuccess(BxMxBean list) {
        ProgressDialogUtils.dismissProgressDialog();
        feeaskBean = list.getTmatser();
        feeaskMxBeanList = list.getListdata();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setHead();
                setAdapter();
                setFoot();
            }
        });

    }

    /**
     * 明细上面
     */
    private void setHead() {
        shzt = feeaskBean.getAuditingflag();
        if ("0".equals(shzt)) {
            setShzt(tvSqbmxShztZd);
        } else if ("1".equals(shzt)) {
            setShzt(tvSqbmxShztDsz);
        } else if ("2".equals(shzt)) {
            setShzt(tvSqbmxShztShz);
        } else if ("y".equals(shzt)) {
            setShzt(tvSqbmxShztShwc);
        }
        tvZcMxBxSqdh.setText(feeaskBean.getId());
        tvZcMxBxBm.setText(feeaskBean.getBm());
        tvZcMxBxLkr.setText(feeaskBean.getLyr());
        tvZcMxBxZffs.setText(feeaskBean.getPaymode());
        tvZcMxBxSqrq.setText(feeaskBean.getDates().split("T")[0]);
    }

    private void setAdapter() {
        if (adapter == null) {
            adapter = new BxmxAdapter(feeaskMxBeanList);
            //设置布局管理者
            rvBx.setLayoutManager(new LinearLayoutManager(ABxMxActivity.this));
            rvBx.addItemDecoration(new RecycleViewDivider(
                    ABxMxActivity.this, LinearLayoutManager.HORIZONTAL, 1, R.color.color_b5));
            rvBx.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    /**
     * 明细下面
     */
    private void setFoot() {
        tvZcMxBxFootHjje.setText("¥"+feeaskBean.getFmone());
        tvZcMxBxFootKhh.setText(feeaskBean.getBank());
        tvZcMxBxFootSkrmc.setText(feeaskBean.getSkrname());
        tvZcMxBxFootYhzh.setText(feeaskBean.getAccounts());
        tvZcMxBxFootBz.setText(feeaskBean.getRemark());
        tvZcMxBxFootZdrq.setText(feeaskBean.getInputdate().split("T")[0]);
        tvZcMxBxFootZdr.setText(feeaskBean.getUsernamec());
        tvZcMxBxFootZdbm.setText(feeaskBean.getBm_name());
    }

    @Override
    public void getBxmxFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                BaseUtil.myToast(errorMessage);
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.ll_sqbmx_shzt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back://返回按钮
                finish();
                break;
            case R.id.ll_sqbmx_shzt://审核状态
                Intent intent=new Intent(this,AudireInfoActivity.class);
                intent.putExtra("sqdh",sqdh);
                intent.putExtra("flag",flag);
                startActivity(intent);
                break;
        }
    }

    private void setShzt(TextView tv) {
        tvSqbmxShztZd.setBackground(MyApplication.getContext().getResources().getDrawable(R.drawable.shape_round_textview));
        tvSqbmxShztDsz.setBackground(MyApplication.getContext().getResources().getDrawable(R.drawable.shape_round_textview));
        tvSqbmxShztShz.setBackground(MyApplication.getContext().getResources().getDrawable(R.drawable.shape_round_textview));
        tvSqbmxShztShwc.setBackground(MyApplication.getContext().getResources().getDrawable(R.drawable.shape_round_textview));
        tvSqbmxShztZd.setTextColor(Color.rgb(39, 134, 202));
        tvSqbmxShztDsz.setTextColor(Color.rgb(39, 134, 202));
        tvSqbmxShztShz.setTextColor(Color.rgb(39, 134, 202));
        tvSqbmxShztShwc.setTextColor(Color.rgb(39, 134, 202));
        tv.setBackground(MyApplication.getContext().getResources().getDrawable(R.drawable.shape_round_textview2));
        tv.setTextColor(Color.WHITE);
    }
}
