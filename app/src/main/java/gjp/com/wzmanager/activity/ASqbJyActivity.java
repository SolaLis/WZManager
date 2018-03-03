package gjp.com.wzmanager.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import gjp.com.wzmanager.adapter.RecycleViewDivider;
import gjp.com.wzmanager.adapter.SqjyAdapter;
import gjp.com.wzmanager.bean.AudirecordBean;
import gjp.com.wzmanager.bean.AudirecordMxBean;
import gjp.com.wzmanager.bean.SqbBean;
import gjp.com.wzmanager.bean.SqbmxBean;
import gjp.com.wzmanager.contract.ASqbmxContract;
import gjp.com.wzmanager.param.AudirecordMxParam;
import gjp.com.wzmanager.presenter.ASqbmxPresenter;
import gjp.com.wzmanager.ui.CHScrollView1;
import gjp.com.wzmanager.ui.CHScrollView2;
import gjp.com.wzmanager.util.AllUrl;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.ProgressDialogUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

public class ASqbJyActivity extends BaseActivity implements ASqbmxContract.View {

    @BindView(R.id.header_title)
    TextView headerTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.btn_right)
    Button btnRight;
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
    @BindView(R.id.tv_sqbmx_sqdh)
    TextView tvSqbmxSqdh;
    @BindView(R.id.tv_sqbmx_sqr)
    TextView tvSqbmxSqr;
    @BindView(R.id.tv_sqbmx_bm)
    TextView tvSqbmxBm;
    @BindView(R.id.tv_sqbmx_sqrq)
    TextView tvSqbmxSqrq;
    @BindView(R.id.tv_sqbmx_ywbm)
    TextView tvSqbmxYwbm;
    @BindView(R.id.tv_sqbmx_zdr)
    TextView tvSqbmxZdr;
    @BindView(R.id.tv_sqbmx_zdrq)
    TextView tvSqbmxZdrq;
    @BindView(R.id.tv_sqbmx_bz)
    TextView tvSqbmxBz;
    @BindView(R.id.rv_jysq)
    RecyclerView rvJysq;

    private ASqbmxContract.Presenter presenter;
    private String url;
    private String usercode;
    private String sqdh;
    private String module;
    private String shzt;
    private SqbBean sqbBean = new SqbBean();
    private AudirecordBean audirecordBean=new AudirecordBean();
    private AudirecordMxParam param=new AudirecordMxParam();
    private List<SqbmxBean> sqbmxBeanList = new ArrayList<>();
    private SqjyAdapter adapter;
    private int flag;

    public ScrollView mTouchView;
    //装入所有的HScrollView
    protected List<CHScrollView2> mHScrollViews =new ArrayList<CHScrollView2>();
    public HorizontalScrollView mTouchView1;
    protected List<CHScrollView1> mHScrollViews1 =new ArrayList<CHScrollView1>();
    private String islistPush;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        islistPush=SharedPreferencesUtil.getStringData(MyApplication.getContext(), "islistPush", null);
        if ("1".equals(islistPush)) {
            setContentView(R.layout.activity_sqb_jy);
        }else {
            setContentView(R.layout.activity_sqb_jy_1);
        }
        ButterKnife.bind(this);
        Intent intent = getIntent();
        flag=intent.getIntExtra("flag",flag);
        audirecordBean = (AudirecordBean) intent.getSerializableExtra("audirecordBean");
        sqdh =audirecordBean.getKeyvalue();
        module =audirecordBean.getModule();
        url = SharedPreferencesUtil.getStringData(this, "setUrl", null) + AllUrl.AUDIRECORDMX_URL;
        usercode = SharedPreferencesUtil.getStringData(this, "usercode", "0000");
        init();
        ProgressDialogUtils.showProgressDialog(this,"正在加载...");
        presenter = new ASqbmxPresenter(this);
        param.setUsercode(usercode);
        param.setKeyvalue(sqdh);
        param.setModule(module);
        presenter.getSqbmx(url, param);
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
        ivBack.setVisibility(View.VISIBLE);
        // setShzt();
        headerTitle.setText("借用申请单");
    }

    @Override
    public void getSqbmxSuccess(AudirecordMxBean list) {
        ProgressDialogUtils.dismissProgressDialog();
        sqbmxBeanList = list.getListdata();
        sqbBean=list.getTmatser();
        Log.e("LOG", "getSqbmxSuccess(ASqbCgActivity.java:44)===" + sqbmxBeanList.size());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setHead();
                setAdapter();
            }
        });
    }
    private void setHead() {
        shzt = sqbBean.getAuditingflag();
        if ("0".equals(shzt)) {
            setShzt(tvSqbmxShztZd);
        } else if ("1".equals(shzt)) {
            setShzt(tvSqbmxShztDsz);
        } else if ("2".equals(shzt)) {
            setShzt(tvSqbmxShztShz);
        } else if ("y".equals(shzt)) {
            setShzt(tvSqbmxShztShwc);
        }
        tvSqbmxSqdh.setText(sqdh);
        tvSqbmxBm.setText(sqbBean.getSqbm());
        tvSqbmxSqr.setText(sqbBean.getSqr());
        tvSqbmxSqrq.setText(sqbBean.getSqrq().split("T")[0]);
        tvSqbmxZdr.setText(sqbBean.getZdr());
        tvSqbmxZdrq.setText(sqbBean.getZdrq().split("T")[0]);
        tvSqbmxYwbm.setText(sqbBean.getBm_name());
        tvSqbmxBz.setText(sqbBean.getBz());
    }
    private void setAdapter() {
            if ("1".equals(islistPush)){
                adapter = new SqjyAdapter(sqbmxBeanList,mHScrollViews,rvJysq);
                //设置布局管理者
                LinearLayoutManager layoutManager=new LinearLayoutManager(ASqbJyActivity.this);
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                rvJysq.setLayoutManager(layoutManager);
            } else {
                adapter = new SqjyAdapter(sqbmxBeanList, mHScrollViews1, rvJysq, 1);
                //设置布局管理者
                LinearLayoutManager layoutManager = new LinearLayoutManager(ASqbJyActivity.this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvJysq.setLayoutManager(layoutManager);
            }
            rvJysq.addItemDecoration(new RecycleViewDivider(
                    ASqbJyActivity.this, LinearLayoutManager.HORIZONTAL, 1, R.color.color_b5));
            rvJysq.setAdapter(adapter);

    }

    @Override
    public void getSqbmxFailed(final String errorMessage) {
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
