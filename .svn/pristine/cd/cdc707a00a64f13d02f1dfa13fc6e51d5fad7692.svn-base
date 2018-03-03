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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gjp.com.wzmanager.MyApplication;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.adapter.Dd3mxAdapter;
import gjp.com.wzmanager.adapter.RecycleViewDivider;
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
/**
 * 物资调拨和其他调入
 */
public class ADd3Activity extends BaseActivity implements AZcmxContract.View {

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
    @BindView(R.id.ll_zc_mx_total_money)
    LinearLayout llZcMxTotalMoney;
    @BindView(R.id.tv_zc_mx_dd3_detail_drcw)
    TextView tvZcMxDd3DetailDrcw;


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

    private Dd3mxAdapter adapter;
    private double totalNum = 0;
    private double totalJs = 0;
    private double totalMoney = 0;

    private int flag;

    public ScrollView mTouchView;
    protected List<CHScrollView2> mHScrollViews =new ArrayList<CHScrollView2>();
    public HorizontalScrollView mTouchView1;
    protected List<CHScrollView1> mHScrollViews1 =new ArrayList<CHScrollView1>();
    private String islistPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        islistPush=SharedPreferencesUtil.getStringData(MyApplication.getContext(), "islistPush", null);
        if ("1".equals(islistPush)) {
            setContentView(R.layout.activity_add3);
        }else {
            setContentView(R.layout.activity_add31);
        }
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
        }else {
            CHScrollView1 headerScroll1 = (CHScrollView1) findViewById(R.id.item_scroll_title);
            mHScrollViews1.add(headerScroll1);
        }

        modulec = audirecordBean.getModulec();
        ivBack.setVisibility(View.VISIBLE);
        headerTitle.setText(modulec);
        llZcMxDjbs.setVisibility(View.GONE);
        llZcMxTotalMoney.setVisibility(View.GONE);
        if ("CJ2".equals(module)){
            tvZcMxDd3DetailDrcw.setVisibility(View.GONE);
            //head部门名称变更
            tvZcMxGys1.setText(getResources().getString(R.string.bm));
        }else {
            tvZcMxDd3DetailDrcw.setVisibility(View.VISIBLE);
            //head 调拨部门  调拨人
            tvZcMxGys1.setText(getResources().getString(R.string.dbbm));
            tvZcMxJbr1.setText("调拨人:");
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
        for (int i = 0; i < ckzcmxBeanList.size(); i++) {
            totalNum = NumUtil.add(totalNum, ckzcmxBeanList.get(i).getSL());
            totalJs = NumUtil.add(totalJs, ckzcmxBeanList.get(i).getJS());
        }
        tvZcMxTotalSl.setText(NumUtil.doubleTrans(totalNum));
        tvZcMxTotalJs.setText(NumUtil.doubleTrans(totalJs));
    }

    private void setAdapter() {
        if (adapter == null) {
           /* adapter = new Dd3mxAdapter(ckzcmxBeanList);
            //设置布局管理者
            rvZc.setLayoutManager(new LinearLayoutManager(ADd3Activity.this));*/
           if ("1".equals(islistPush)){
            adapter = new Dd3mxAdapter(ckzcmxBeanList,mHScrollViews,rvZc);
            //设置布局管理者
            LinearLayoutManager layoutManager=new LinearLayoutManager(ADd3Activity.this);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rvZc.setLayoutManager(layoutManager);}
            else {
               adapter = new Dd3mxAdapter(ckzcmxBeanList,mHScrollViews1,rvZc,1);
               //设置布局管理者
               LinearLayoutManager layoutManager=new LinearLayoutManager(ADd3Activity.this);
               layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
               rvZc.setLayoutManager(layoutManager);
           }
            rvZc.addItemDecoration(new RecycleViewDivider(
                    ADd3Activity.this, LinearLayoutManager.HORIZONTAL, 1, R.color.color_b5));
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
                Intent intent=new Intent(this,AudireInfoActivity.class);
                intent.putExtra("sqdh",sqdh);
                intent.putExtra("flag",flag);
                startActivity(intent);
                break;
        }
    }
    public void onScrollChanged(int l, int t, int oldl, int oldt){
        if ("1".equals(islistPush)){
        for(CHScrollView2 scrollView : mHScrollViews) {
            //防止重复滑动
            if(mTouchView != scrollView)
                scrollView.smoothScrollTo(l, t);
        }}else {
            for(CHScrollView1 scrollView : mHScrollViews1) {
                //防止重复滑动
                if(mTouchView1 != scrollView)
                    scrollView.smoothScrollTo(l, t);
            }

        }
    }

}
