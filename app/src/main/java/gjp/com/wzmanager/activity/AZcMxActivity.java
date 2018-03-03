package gjp.com.wzmanager.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gjp.com.wzmanager.MyApplication;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.adapter.RecycleViewDivider;
import gjp.com.wzmanager.adapter.ZcmxAdapter;
import gjp.com.wzmanager.bean.AudirecordBean;
import gjp.com.wzmanager.bean.AudirecordMxZcBean;
import gjp.com.wzmanager.bean.CkzcBean;
import gjp.com.wzmanager.bean.CkzcmxBean;
import gjp.com.wzmanager.contract.AZcmxContract;
import gjp.com.wzmanager.param.AudirecordMxParam;
import gjp.com.wzmanager.presenter.AZcmxPresenter;
import gjp.com.wzmanager.ui.CHScrollView1;
import gjp.com.wzmanager.ui.CHScrollView2;
import gjp.com.wzmanager.util.AllUrl;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.NumUtil;
import gjp.com.wzmanager.util.ProgressDialogUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

public class AZcMxActivity extends BaseActivity implements AZcmxContract.View {

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
    @BindView(R.id.tv_zc_mx_pzh)
    TextView tvZcMxPzh;
    @BindView(R.id.tv_zc_mx_gys1)
    TextView tvZcMxGys1;
    @BindView(R.id.tv_zc_mx_gys)
    TextView tvZcMxGys;
    @BindView(R.id.tv_zc_mx_rq)
    TextView tvZcMxRq;
    @BindView(R.id.tv_zc_mx_crkfs)
    TextView tvZcMxCrkfs;
    @BindView(R.id.tv_zc_mx_djbs)
    TextView tvZcMxDjbs;
    @BindView(R.id.ll_zc_mx_djbs)
    LinearLayout llZcMxDjbs;
    @BindView(R.id.tv_zc_mx_zy)
    TextView tvZcMxZy;
    @BindView(R.id.tv_zc_mx_bz)
    TextView tvZcMxBz;
    @BindView(R.id.tv_zc_mx_jbr1)
    TextView tvZcMxJbr1;
    @BindView(R.id.tv_zc_mx_jbr)
    TextView tvZcMxJbr;
    @BindView(R.id.tv_zc_mx_jzy)
    TextView tvZcMxJzy;
    @BindView(R.id.tv_zc_mx_total_sl)
    TextView tvZcMxTotalSl;
    @BindView(R.id.tv_zc_mx_total_js)
    TextView tvZcMxTotalJs;
    @BindView(R.id.tv_zc_mx_total_money)
    TextView tvZcMxTotalMoney;
    @BindView(R.id.rv_zc)
    RecyclerView rvZc;

    //其初盘入需要隐藏的明细列
    @BindView(R.id.tv_zc_mx_detail_2)
    TextView tvZcMxDetail2;
    @BindView(R.id.tv_zc_mx_detail_3)
    TextView tvZcMxDetail3;
    @BindView(R.id.tv_zc_mx_detail_20)
    TextView tvZcMxDetail20;
    @BindView(R.id.tv_zc_mx_detail_21)
    TextView tvZcMxDetail21;
    @BindView(R.id.tv_zc_mx_detail_15)
    TextView tvZcMxDetail15;
    @BindView(R.id.tv_zc_mx_detail_16)
    TextView tvZcMxDetail16;
    @BindView(R.id.ll_zc_mx_total_money)
    LinearLayout llZcMxTotalMoney;

    // public HorizontalScrollView mTouchView;
    public ScrollView mTouchView;
    //装入所有的HScrollView
    protected List<CHScrollView2> mHScrollViews = new ArrayList<CHScrollView2>();
    public HorizontalScrollView mTouchView1;
    protected List<CHScrollView1> mHScrollViews1 = new ArrayList<CHScrollView1>();
    @BindView(R.id.tv_zc_mx_detail_22)
    TextView tvZcMxDetail22;
    private String islistPush;

    private AZcmxContract.Presenter presenter;
    private String url;
    private String usercode;
    private String sqdh;
    private String module;
    private String modulec;
    private String shzt;
    private AudirecordMxParam param = new AudirecordMxParam();
    private CkzcBean ckzcBean = new CkzcBean();
    private List<CkzcmxBean> ckzcmxBeanList = new ArrayList<>();
    private AudirecordBean audirecordBean = new AudirecordBean();

    private ZcmxAdapter adapter;
    private double totalNum = 0;
    private double totalJs = 0;
    private double totalMoney = 0;
    private int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        islistPush = SharedPreferencesUtil.getStringData(MyApplication.getContext(), "islistPush", null);
        if ("1".equals(islistPush)) {

            setContentView(R.layout.activity_azc_mx);
        } else {
            setContentView(R.layout.activity_azc_mx_1);
        }

        ButterKnife.bind(this);
        Intent intent = getIntent();
        flag = intent.getIntExtra("flag", flag);
        audirecordBean = (AudirecordBean) intent.getSerializableExtra("audirecordBean");
        sqdh = audirecordBean.getKeyvalue();
        module = audirecordBean.getModule();
        Log.e("LOG", "onCreate(AZcMxActivity.java:129)=module==" + module);
        url = SharedPreferencesUtil.getStringData(this, "setUrl", null) + AllUrl.AUDIRECORDMX_URL;
        usercode = SharedPreferencesUtil.getStringData(this, "usercode", "0000");
        init();
        ProgressDialogUtils.showProgressDialog(this, "正在加载...");
        presenter = new AZcmxPresenter(this);
        param.setUsercode(usercode);
        param.setKeyvalue(sqdh);
        param.setModule(module);
        presenter = new AZcmxPresenter(this);
        presenter.getZcmx(url, param);

    }

    private void init() {
        if ("1".equals(islistPush)) {
            CHScrollView2 headerScroll = (CHScrollView2) findViewById(R.id.item_scroll_title);
            //添加头滑动事件
            mHScrollViews.add(headerScroll);
        } else {
            CHScrollView1 headerScroll1 = (CHScrollView1) findViewById(R.id.item_scroll_title);
            mHScrollViews1.add(headerScroll1);
        }
        modulec = audirecordBean.getModulec();
        ivBack.setVisibility(View.VISIBLE);
        headerTitle.setText(modulec);
        //单据标识没有的
        String[] module1 = {"RA2", "RB2", "RQC", "CA2", "CD2", "CB2", "CE2", "CC1", "CH2", "CI2",
                "CK1", "CF2", "CG2", "CJ1", "CJ2", "RJ1", "RJ2"};
        List<String> list1 = Arrays.asList(module1);
        if (list1.contains(module)) {
            llZcMxDjbs.setVisibility(View.GONE);
        }
        // 物资入库
        String[] moduleWzrk = {"RB1", "RB2", "CI1", "CI2", "CG1", "CG2"};
        List<String> listWzrk = Arrays.asList(moduleWzrk);
        if (listWzrk.contains(module)) {
            tvZcMxDetail2.setVisibility(View.GONE);
            tvZcMxDetail3.setVisibility(View.GONE);
        }
        //期初盘入需要隐藏和改变的head部门
        if ("RQC".equals(module)) {
            //head部门名称变更
            tvZcMxGys1.setText(getResources().getString(R.string.prbm));
            tvZcMxJbr1.setText(getResources().getString(R.string.prr));
            //明细字段隐藏
            tvZcMxDetail2.setVisibility(View.GONE);
            tvZcMxDetail3.setVisibility(View.GONE);
            tvZcMxDetail20.setVisibility(View.GONE);
            tvZcMxDetail21.setVisibility(View.GONE);
        }
        //Head名称变更为 部门 领用人
        String[] moduleHead = {"CA1", "CA2", "CD1", "CD2",
                "CB1", "CB2", "CE1", "CE2", "CC1",
                "CH1", "CH2", "CI1", "CI2", "CK1"};
        List<String> listHead = Arrays.asList(moduleHead);
        if (listHead.contains(module)) {
            //head部门名称变更
            tvZcMxGys1.setText(getResources().getString(R.string.bm));
            tvZcMxJbr1.setText(getResources().getString(R.string.lyr));
        }
        //Head名称变更为 客户 经办人
        String[] moduleHead1 = {"CF1", "CF2", "CG1", "CG2"};
        List<String> listHead1 = Arrays.asList(moduleHead1);
        if (listHead1.contains(module)) {
            tvZcMxGys1.setText(getResources().getString(R.string.kh));
        }
        //物资领用和物资借用
        String[] moduleWzly = {"CA1", "CA2", "CD1", "CD2",
                "CB1", "CB2", "CE1", "CE2", "CC1",
                "CK1", "CJ1", "CJ2", "RJ1", "RJ2"};
        List<String> listWzly = Arrays.asList(moduleWzly);
        if (listWzly.contains(module)) {
            //total
            llZcMxTotalMoney.setVisibility(View.GONE);
            //明细字段隐藏
            tvZcMxDetail15.setVisibility(View.GONE);
            tvZcMxDetail16.setVisibility(View.GONE);
            String[] moduleWzly1 = {"CD1", "CD2", "CE1", "CE2", "CC1", "CI1", "CI2", "CK1"};
            List<String> listWzly1 = Arrays.asList(moduleWzly1);
            Log.e("LOG", "init(AZcMxActivity.java:178)==listWzly1.contains(module)=" + listWzly1.contains(module));
            if (listWzly1.contains(module)) {

                tvZcMxDetail2.setVisibility(View.GONE);
                tvZcMxDetail3.setVisibility(View.GONE);
            }
        }
        // 物资调动
        String[] moduleWzdd = {"CJ1", "CJ2", "RJ1", "RJ2"};
        List<String> listWzdd = Arrays.asList(moduleWzdd);
        if (listWzdd.contains(module)) {
            tvZcMxGys1.setText(getResources().getString(R.string.bm));
            tvZcMxDetail15.setVisibility(View.GONE);
            tvZcMxDetail16.setVisibility(View.GONE);
            if ("CJ1".equals(module)) {
                tvZcMxDetail20.setVisibility(View.GONE);
                tvZcMxDetail21.setVisibility(View.GONE);
            }
            if ("RJ1".equals(module) || "RJ2".equals(module)) {
                tvZcMxDetail2.setVisibility(View.GONE);
                tvZcMxDetail3.setVisibility(View.GONE);
            }
        }

        // 归还日期
        String[] moduleGhrq = {"CB1", "CB2", "CE1", "CE2","CH1", "CH2", "CI1", "CI2"};
        List<String> listGhrq= Arrays.asList(moduleGhrq);
        if (listGhrq.contains(module)) {
            tvZcMxDetail22.setVisibility(View.VISIBLE);
        }
        else {
            tvZcMxDetail22.setVisibility(View.GONE);
        }
    }

    @Override
    public void getZcmxSuccess(AudirecordMxZcBean list) {
        ProgressDialogUtils.dismissProgressDialog();
        ckzcBean = list.getTmatser();
        ckzcmxBeanList = list.getListdata();
        Log.e("LOG", "getZcmxSuccess(AZcMxActivity.java:114)===" + ckzcmxBeanList.size());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setHead();
                setTotal();
                setAdapter();
            }
        });
    }

    private void setTotal() {
        String[] moduleXs = {"RA1", "RA2", "RB1", "RB2", "RQC"};
        List<String> listXs = Arrays.asList(moduleXs);
        for (CkzcmxBean ckzcmxBean : ckzcmxBeanList) {
            totalNum = NumUtil.add(totalNum, ckzcmxBean.getSL());
            totalJs = NumUtil.add(totalJs, ckzcmxBean.getJS());
            if (listXs.contains(module)) {
                totalMoney = NumUtil.add(totalMoney, Double.valueOf(ckzcmxBean.getJE()));
            } else {
                totalMoney = NumUtil.add(totalMoney, Double.valueOf(ckzcmxBean.getXsje()));

            }
            totalMoney = NumUtil.add(totalMoney, Double.valueOf(ckzcmxBean.getXsje()));
        }
        tvZcMxTotalSl.setText(NumUtil.doubleTrans(totalNum));
        tvZcMxTotalJs.setText(NumUtil.doubleTrans(totalJs));
        tvZcMxTotalMoney.setText("¥"+NumUtil.doubleTrans(totalMoney));
    }

    private void setAdapter() {
        if (adapter == null) {
           /* adapter = new ZcmxAdapter(ckzcmxBeanList);
            //设置布局管理者
            rvZc.setLayoutManager(new LinearLayoutManager(AZcMxActivity.this));*/
            if ("1".equals(islistPush)) {
                adapter = new ZcmxAdapter(ckzcmxBeanList, mHScrollViews, rvZc);
                //设置布局管理者
                LinearLayoutManager layoutManager = new LinearLayoutManager(AZcMxActivity.this);
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                rvZc.setLayoutManager(layoutManager);
            } else {
                adapter = new ZcmxAdapter(ckzcmxBeanList, mHScrollViews1, rvZc, 1);
                //设置布局管理者
                LinearLayoutManager layoutManager = new LinearLayoutManager(AZcMxActivity.this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvZc.setLayoutManager(layoutManager);
            }
            rvZc.addItemDecoration(new RecycleViewDivider(
                    AZcMxActivity.this, LinearLayoutManager.HORIZONTAL, 1, R.color.color_b5));
            rvZc.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    private void setHead() {
        shzt = ckzcBean.getAuditingflag();
        if ("0".equals(shzt)) {
            setShzt(tvSqbmxShztZd);
        } else if ("1".equals(shzt)) {
            setShzt(tvSqbmxShztDsz);
        } else if ("2".equals(shzt)) {
            setShzt(tvSqbmxShztShz);
        } else if ("y".equals(shzt)) {
            setShzt(tvSqbmxShztShwc);
        }
        tvZcMxPzh.setText(sqdh);
        tvZcMxGys.setText(ckzcBean.getKHMC());
        tvZcMxRq.setText(ckzcBean.getRQ().split("T")[0]);
        tvZcMxCrkfs.setText(ckzcBean.getCRKFS());
        tvZcMxDjbs.setText(ckzcBean.getDJBS());
        tvZcMxZy.setText(ckzcBean.getZY());
        tvZcMxBz.setText(ckzcBean.getBZ());
        tvZcMxJbr.setText(ckzcBean.getLLR());
        tvZcMxJzy.setText(ckzcBean.getJZY());

    }

    @Override
    public void getZcmxFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                BaseUtil.myToast(errorMessage);
            }
        });
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

    @OnClick({R.id.iv_back, R.id.ll_sqbmx_shzt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_sqbmx_shzt:
                Intent intent = new Intent(this, AudireInfoActivity.class);
                intent.putExtra("sqdh", sqdh);
                intent.putExtra("flag", flag);
                startActivity(intent);
                break;
        }
    }

    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        if ("1".equals(islistPush)) {
            for (CHScrollView2 scrollView : mHScrollViews) {
                //防止重复滑动
                if (mTouchView != scrollView)
                    scrollView.smoothScrollTo(l, t);
            }
        } else {
            for (CHScrollView1 scrollView : mHScrollViews1) {
                //防止重复滑动
                if (mTouchView1 != scrollView)
                    scrollView.smoothScrollTo(l, t);
            }
        }
    }
}
