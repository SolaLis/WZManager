package gjp.com.wzmanager.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import gjp.com.wzmanager.adapter.PdTimeMxAdapter;
import gjp.com.wzmanager.adapter.RecycleViewDivider;
import gjp.com.wzmanager.bean.AudirecordBean;
import gjp.com.wzmanager.bean.PcBean;
import gjp.com.wzmanager.bean.PcTimeMxBean;
import gjp.com.wzmanager.bean.PdTimeMxBean;
import gjp.com.wzmanager.contract.PdTimeContract;
import gjp.com.wzmanager.param.AudirecordMxParam;
import gjp.com.wzmanager.presenter.PdTimePresenter;
import gjp.com.wzmanager.ui.CHScrollView1;
import gjp.com.wzmanager.ui.CHScrollView2;
import gjp.com.wzmanager.util.AllUrl;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.NumUtil;
import gjp.com.wzmanager.util.ProgressDialogUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

public class PdTimeMxActivity extends BaseActivity implements PdTimeContract.View {

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
    @BindView(R.id.tv_pc_mx_pzh)
    TextView tvPcMxPzh;
    @BindView(R.id.tv_pc_mx_rq)
    TextView tvPcMxRq;
    @BindView(R.id.tv_pc_mx_pdlx)
    TextView tvPcMxPdlx;
    @BindView(R.id.tv_pc_mx_kcrq)
    TextView tvPcMxKcrq;
    @BindView(R.id.tv_pc_mx_pdbm)
    TextView tvPcMxPdbm;
    @BindView(R.id.tv_pc_mx_crkfs)
    TextView tvPcMxCrkfs;
    @BindView(R.id.tv_pc_mx_zy)
    TextView tvPcMxZy;
    @BindView(R.id.tv_pc_mx_bz)
    TextView tvPcMxBz;
    @BindView(R.id.tv_zc_mx_jbr1)
    TextView tvZcMxJbr1;
    @BindView(R.id.tv_pc_mx_pdr)
    TextView tvPcMxPdr;
    @BindView(R.id.tv_pc_mx_jzy)
    TextView tvPcMxJzy;
    @BindView(R.id.tv_pd_mx_total_sl)
    TextView tvPdMxTotalSl;
    @BindView(R.id.tv_pd_mx_total_js)
    TextView tvPdMxTotalJs;
    @BindView(R.id.tv_pd_mx_total_kcsl)
    TextView tvPdMxTotalKcsl;
    @BindView(R.id.tv_pd_mx_total_kcjs)
    TextView tvPdMxTotalKcjs;
    @BindView(R.id.rv_pd)
    RecyclerView rvPd;
    // public HorizontalScrollView mTouchView;
    public ScrollView mTouchView;
    //装入所有的HScrollView
    protected List<CHScrollView2> mHScrollViews =new ArrayList<CHScrollView2>();
    public HorizontalScrollView mTouchView1;
    protected List<CHScrollView1> mHScrollViews1 =new ArrayList<CHScrollView1>();
    private String islistPush;

    private PdTimeContract.Presenter presenter;
    private String url;
    private String usercode;
    private String sqdh;
    private String module;
    private String modulec;
    private String shzt;
    private AudirecordMxParam param = new AudirecordMxParam();
    private PcBean pcBean = new PcBean();
    private List<PcTimeMxBean> pcTimeMxBeanList = new ArrayList<>();
    private AudirecordBean audirecordBean = new AudirecordBean();

    private PdTimeMxAdapter adapter;
    private double totalNum = 0;
    private double totalJs = 0;
    private double totalPcNum = 0;
    private double totalPcJs = 0;
    private int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        islistPush=SharedPreferencesUtil.getStringData(MyApplication.getContext(), "islistPush", null);
        if ("1".equals(islistPush)) {
            setContentView(R.layout.activity_pd_time_mx);
        }else {
            setContentView(R.layout.activity_pd_time_mx_1);
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
        param.setUsercode(usercode);
        param.setKeyvalue(sqdh);
        param.setModule(module);
        presenter = new PdTimePresenter(this);
        presenter.getPdTimeMx(url, param);
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
    }

    @Override
    public void getPdTimeMxSuccess(PdTimeMxBean list) {
        ProgressDialogUtils.dismissProgressDialog();
        pcBean = list.getTmatser();
        pcTimeMxBeanList = list.getListdata();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setHead();
                setTotal();
                setAdapter();
            }
        });
    }

    @Override
    public void getPdTimeMxFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                BaseUtil.myToast(errorMessage);
            }
        });
    }

    private void setHead() {
        shzt = pcBean.getAuditingflag();
        if ("0".equals(shzt)) {
            setShzt(tvSqbmxShztZd);
        } else if ("1".equals(shzt)) {
            setShzt(tvSqbmxShztDsz);
        } else if ("2".equals(shzt)) {
            setShzt(tvSqbmxShztShz);
        } else if ("y".equals(shzt)) {
            setShzt(tvSqbmxShztShwc);
        }
        tvPcMxPzh.setText(sqdh);
        tvPcMxRq.setText(pcBean.getRQ().split("T")[0]);
        tvPcMxPdlx.setText(pcBean.getPdlx());
        String kcrq=pcBean.getKcsj();
        if (kcrq==null||kcrq.length()==0||"0001-01-01T00:00:00".equals(kcrq)){
            kcrq="";
        }else {
            kcrq=kcrq.split("T")[0];
        }
        tvPcMxKcrq.setText(kcrq);
        tvPcMxPdbm.setText(pcBean.getKHMC());
        tvPcMxCrkfs.setText(pcBean.getCRKFS());
        tvPcMxZy.setText(pcBean.getZY());
        tvPcMxBz.setText(pcBean.getBZ());
        tvPcMxPdr.setText(pcBean.getLLR());
        tvPcMxJzy.setText(pcBean.getJZY());

    }
    private void setTotal() {
        for (int i = 0; i < pcTimeMxBeanList.size(); i++) {
            totalNum = NumUtil.add(totalNum, pcTimeMxBeanList.get(i).getSL());
            totalJs = NumUtil.add(totalJs, pcTimeMxBeanList.get(i).getJS());
            totalPcNum = NumUtil.add(totalPcNum, pcTimeMxBeanList.get(i).getPCSL());
            totalPcJs = NumUtil.add(totalPcJs, pcTimeMxBeanList.get(i).getPCJS());
        }
        tvPdMxTotalSl.setText(NumUtil.doubleTrans(totalNum));
        tvPdMxTotalJs.setText(NumUtil.doubleTrans(totalJs));
        tvPdMxTotalKcsl.setText(NumUtil.doubleTrans(totalPcNum));
        tvPdMxTotalKcjs.setText(NumUtil.doubleTrans(totalPcJs));
    }
    private void setAdapter() {
        if (adapter == null) {
          /*  adapter = new PdTimeMxAdapter(pcTimeMxBeanList);
            //设置布局管理者
            rvPd.setLayoutManager(new LinearLayoutManager(PdTimeMxActivity.this));*/
            if ("1".equals(islistPush)){
            adapter = new PdTimeMxAdapter(pcTimeMxBeanList,mHScrollViews,rvPd);
            //设置布局管理者
            LinearLayoutManager layoutManager=new LinearLayoutManager(PdTimeMxActivity.this);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rvPd.setLayoutManager(layoutManager);}
            else {
                adapter = new PdTimeMxAdapter(pcTimeMxBeanList,mHScrollViews1,rvPd,1);
                //设置布局管理者
                LinearLayoutManager layoutManager=new LinearLayoutManager(PdTimeMxActivity.this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvPd.setLayoutManager(layoutManager);
            }
            rvPd.addItemDecoration(new RecycleViewDivider(
                    PdTimeMxActivity.this, LinearLayoutManager.HORIZONTAL, 1, R.color.color_b5));
            rvPd.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
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
