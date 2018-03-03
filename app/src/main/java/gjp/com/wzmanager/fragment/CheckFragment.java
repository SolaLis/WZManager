package gjp.com.wzmanager.fragment;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import butterknife.Unbinder;
import gjp.com.wzmanager.MyApplication;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.activity.ABxMxActivity;
import gjp.com.wzmanager.activity.ADd3Activity;
import gjp.com.wzmanager.activity.ASqbCgActivity;
import gjp.com.wzmanager.activity.ASqbDrActivity;
import gjp.com.wzmanager.activity.ASqbJyActivity;
import gjp.com.wzmanager.activity.ASqbLyActivity;
import gjp.com.wzmanager.activity.ASqbXsActivity;
import gjp.com.wzmanager.activity.ASqbZyActivity;
import gjp.com.wzmanager.activity.AZcMxActivity;
import gjp.com.wzmanager.activity.PdMxActivity;
import gjp.com.wzmanager.activity.PdTimeMxActivity;
import gjp.com.wzmanager.adapter.AudirecordAdapter;
import gjp.com.wzmanager.adapter.MainAdapter;
import gjp.com.wzmanager.adapter.MoreAdapter;
import gjp.com.wzmanager.bean.AudirecordBean;
import gjp.com.wzmanager.bean.ModuleBean;
import gjp.com.wzmanager.contract.AudirecordContract;
import gjp.com.wzmanager.param.AudirecordParam;
import gjp.com.wzmanager.presenter.AudirecordPresenter;
import gjp.com.wzmanager.util.AllUrl;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.ProgressDialogUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckFragment extends BaseFragment implements AudirecordContract.View {

    @BindView(R.id.header_title)
    TextView headerTitle;
    @BindView(R.id.rb_deal_1)
    RadioButton rbDeal1;
    @BindView(R.id.rb_deal_2)
    RadioButton rbDeal2;
    @BindView(R.id.rg_deal)
    RadioGroup rgDeal;
   /* @BindView(R.id.rv_audirecord)
    LRecyclerView rvAudirecord;*/
    Unbinder unbinder;
    @BindView(R.id.tv)
    TextView tv;
    private AudirecordContract.Presenter presenter;
    private AudirecordParam param = new AudirecordParam();
    private String url,url1;
    private String usercode;
    private LRecyclerView rvAudirecord,rvAudirecord1;
    private List<AudirecordBean> audirecordBeanList = new ArrayList<>();
    private List<AudirecordBean> audirecordBeanList1 = new ArrayList<>();
    private AudirecordAdapter adapter;
    private AudirecordAdapter adapter1;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter1;
    private int pageSize = 10;
    private int currentPage = 1;

    private List<ModuleBean> moduleBeanList = new ArrayList<>();
    private DisplayMetrics dm;
    private PopupWindow popWindow;
    private MoreAdapter moreAdapter;
    private ListView morelist;
    private ListView mainlist;
    private MainAdapter mainAdapter;

    private String blzt = "dbl";
    private int flag;

    private int flag1=0;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                   // rgDeal.setEnabled(true);
                    rbDeal1.setEnabled(true);
                    rbDeal2.setEnabled(true);
                    break;
                case 2:
                        setAdapter();
                    break;
            }
        }
    };

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_check, null);
        ButterKnife.bind(this, view);
       rvAudirecord= (LRecyclerView) view.findViewById(R.id.rv_audirecord);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        ProgressDialogUtils.showProgressDialog(getActivity(), "正在加载...");
        dm = new DisplayMetrics();
        // 取得窗口属性
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        getAllModule();
        headerTitle.setText("单据审核");
        presenter = new AudirecordPresenter(this);
        url = SharedPreferencesUtil.getStringData(MyApplication.getContext(), "setUrl", null) + AllUrl.AUDIRECORD_URL;
        url1 = SharedPreferencesUtil.getStringData(MyApplication.getContext(), "setUrl", null) + AllUrl.AUDIRECORD_Examine_URL;
        usercode = SharedPreferencesUtil.getStringData(MyApplication.getContext(), "usercode", "0000");
        param.setPageSize(pageSize);
        param.setCurrentPage(currentPage);
        param.setUsercode(usercode);
        param.setAuditingflag("dbl");
        presenter.getAudirecord(url1, param);
        setListener();
    }


    @Override
    public void getAudirecordSuccess(List<AudirecordBean> list) {
        ProgressDialogUtils.dismissProgressDialog();
        audirecordBeanList.addAll(list);
        Log.e("LOG","getAudirecordSuccess(CheckFragment.java:136)==="+audirecordBeanList.size());
        handler.sendEmptyMessage(2);
      /* getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setAdapter();
            }
        });*/
    }

    @Override
    public void getAudirecordFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setAdapter();
                if (AllUrl.NETWORK_ERROR.equals(errorMessage)&&currentPage!=1) {
                    rvAudirecord.setOnNetWorkErrorListener(new OnNetWorkErrorListener() {
                        @Override
                        public void reload() {
                            if ("dbl".equals(blzt)){
                                presenter.getAudirecord(url1, param);
                            }else {
                                presenter.getAudirecord(url, param);
                            }
                        }
                    });
                } else {
                    if (currentPage == 1) {
                        BaseUtil.myToast(errorMessage);
                    } else {
                        rvAudirecord.setNoMore(true);
                    }
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setListener() {
        rgDeal.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_deal_1:
                        flag1=0;
                        blzt = "dbl";
                        ProgressDialogUtils.showProgressDialog(getActivity(), "正在加载...");
                        audirecordBeanList.clear();
                        param.setAuditingflag("dbl");
                        currentPage = 1;
                        param.setCurrentPage(currentPage);
                        presenter.getAudirecord(url1, param);
                        break;
                    case R.id.rb_deal_2:
                        flag1=0;
                        blzt = "ybl";
                        ProgressDialogUtils.showProgressDialog(getActivity(), "正在加载...");
                        audirecordBeanList.clear();
                        param.setAuditingflag("ybl");
                        currentPage = 1;
                        param.setCurrentPage(currentPage);
                        presenter.getAudirecord(url, param);
                        break;
                }
            }
        });

        rvAudirecord.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                flag1=1;
                rgDeal.setEnabled(false);
                rbDeal1.setEnabled(false);
                rbDeal2.setEnabled(false);
                audirecordBeanList.clear();
                adapter = null;
                mLRecyclerViewAdapter.notifyDataSetChanged();//必须调用此方法
                currentPage = 1;
                param.setCurrentPage(currentPage);
                if ("dbl".equals(blzt)){
                presenter.getAudirecord(url1, param);
                }else {
                    presenter.getAudirecord(url, param);
                }

            }
        });
        rvAudirecord.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                flag1=1;
                rgDeal.setEnabled(false);
                rbDeal1.setEnabled(false);
                rbDeal2.setEnabled(false);
                currentPage++;
                param.setCurrentPage(currentPage);
                if ("dbl".equals(blzt)){
                    presenter.getAudirecord(url1, param);
                }else {
                    presenter.getAudirecord(url, param);
                }
            }
        });
    }

    private void setAdapter() {
        rvAudirecord.refreshComplete(0);
        Log.e("LOG", "setAdapter(CheckFragment.java:162)===" + 0);
        if (mLRecyclerViewAdapter == null) {
            Log.e("LOG", "setAdapter(CheckFragment.java:163)===" + 1);
            adapter = new AudirecordAdapter(audirecordBeanList);
            mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
            rvAudirecord.setAdapter(mLRecyclerViewAdapter);
            LinearLayoutManager lm = new LinearLayoutManager(getActivity());
            rvAudirecord.setLayoutManager(lm);
            DividerDecoration divider = new DividerDecoration.Builder(MyApplication.getContext())
                    .setHeight(R.dimen.fgx)
                    .setPadding(R.dimen.fgx)
                    .setColorResource(R.color.red)
                    .build();
            //mRecyclerView.setHasFixedSize(true);
            rvAudirecord.addItemDecoration(divider);
            rvAudirecord.setRefreshProgressStyle(ProgressStyle.LineSpinFadeLoader);
            rvAudirecord.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
            rvAudirecord.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
            //设置头部加载颜色
            rvAudirecord.setHeaderViewColor(R.color.colorAccent, R.color.blue_size, android.R.color.white);
            //设置底部加载颜色
            rvAudirecord.setFooterViewColor(R.color.colorAccent, R.color.blue_size, android.R.color.white);
            //设置底部加载文字提示
            rvAudirecord.setFooterViewHint("拼命加载中", "已经全部为你呈现了", "网络不给力啊，点击再试一次吧");
        } else {
            Log.e("LOG", "setAdapter(CheckFragment.java:188)===" + 2);
            mLRecyclerViewAdapter.notifyDataSetChanged();
        }
        rvAudirecord.setNoMore(false);
        if (flag1==1){
        handler.sendEmptyMessageDelayed(1,1000);}


        mLRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                AudirecordBean audirecordBean = audirecordBeanList.get(position);
                String module = audirecordBean.getModule();
                String classname = audirecordBean.getClassname();
                Log.e("LOG", "onItemClick(CheckFragment.java:263)=module==" + module);
                Log.e("LOG", "onItemClick(CheckFragment.java:264)=classname==" + classname);
                Class<?> cls = null;
                if ("001".equals(module)) {
                    cls = ASqbCgActivity.class;
                } else if ("002".equals(module)) {
                    cls = ASqbLyActivity.class;
                } else if ("003".equals(module)) {
                    cls = ASqbJyActivity.class;
                } else if ("004".equals(module)) {
                    cls = ASqbXsActivity.class;
                } else if ("005".equals(module)) {
                    cls = ASqbZyActivity.class;
                } else if ("006".equals(module)) {
                    cls = ASqbDrActivity.class;
                } else if ("007".equals(module)) {
                    cls = ASqbDrActivity.class;
                } else if ("BX".equals(module)) {
                    cls = ABxMxActivity.class;
                } else if ("CJ2".equals(module) || "CDB".equals(module)) {
                    cls = ADd3Activity.class;
                } else if ("PC".equals(module)) {
                    if ("w_kc_sj_pd".equals(audirecordBean.getClassname())) {
                        cls = PdTimeMxActivity.class;
                    } else {
                        cls = PdMxActivity.class;
                    }
                } else {
                    cls = AZcMxActivity.class;
                }
                Intent intent = new Intent(MyApplication.getContext(), cls);
              /*  intent.putExtra("keyvalue",sqbBean.getSqdh());
                intent.putExtra("module",sqbBean.getSqmsbm());*/
                if ("dbl".equals(blzt)) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("flag",flag);
                bundle.putSerializable("audirecordBean", audirecordBean);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void getAllModule() {
        ModuleBean moduleBean0 = new ModuleBean();
        moduleBean0.setName("全部单据");
        List<ModuleBean.MBean> mBeanList0 = new ArrayList<>();
        mBeanList0.add(new ModuleBean.MBean("", "全部单据"));
        moduleBean0.setmBeanList(mBeanList0);
        ModuleBean moduleBean1 = new ModuleBean();
        moduleBean1.setName("物资申请");
        List<ModuleBean.MBean> mBeanList1 = new ArrayList<>();
        mBeanList1.add(new ModuleBean.MBean("001", "采购申请"));
        mBeanList1.add(new ModuleBean.MBean("002", "领用申请"));
        mBeanList1.add(new ModuleBean.MBean("003", "借用申请"));
        mBeanList1.add(new ModuleBean.MBean("004", "销售申请"));
        mBeanList1.add(new ModuleBean.MBean("005", "租用申请"));
        mBeanList1.add(new ModuleBean.MBean("006", "调入申请"));
        mBeanList1.add(new ModuleBean.MBean("007", "调出申请"));
        moduleBean1.setmBeanList(mBeanList1);

        ModuleBean moduleBean2 = new ModuleBean();
        moduleBean2.setName("物资入库");
        List<ModuleBean.MBean> mBeanList2 = new ArrayList<>();
        mBeanList2.add(new ModuleBean.MBean("RA1", "采购入库"));
        mBeanList2.add(new ModuleBean.MBean("RA2", "采购入库退货"));
        mBeanList2.add(new ModuleBean.MBean("RB1", "其它入库"));
        mBeanList2.add(new ModuleBean.MBean("RB2", "其它入库退货"));
        mBeanList2.add(new ModuleBean.MBean("RQC", "期初盘入"));
        moduleBean2.setmBeanList(mBeanList2);

        ModuleBean moduleBean3 = new ModuleBean();
        moduleBean3.setName("物资领用");
        List<ModuleBean.MBean> mBeanList3 = new ArrayList<>();
        mBeanList3.add(new ModuleBean.MBean("CA1", "领用出库"));
        mBeanList3.add(new ModuleBean.MBean("CA2", "领用出库退仓"));
        mBeanList3.add(new ModuleBean.MBean("CD1", "其它出库"));
        mBeanList3.add(new ModuleBean.MBean("CD2", "其它出库退仓"));
        moduleBean3.setmBeanList(mBeanList3);

        ModuleBean moduleBean4 = new ModuleBean();
        moduleBean4.setName("物资借用");
        List<ModuleBean.MBean> mBeanList4 = new ArrayList<>();
        mBeanList4.add(new ModuleBean.MBean("CB1", "借用出库"));
        mBeanList4.add(new ModuleBean.MBean("CB2", "借用出库退仓"));
        mBeanList4.add(new ModuleBean.MBean("CE1", "其它借用"));
        mBeanList4.add(new ModuleBean.MBean("CE2", "其它借用退仓"));
        mBeanList4.add(new ModuleBean.MBean("CC1", "借用还入"));
        moduleBean4.setmBeanList(mBeanList4);

        ModuleBean moduleBean5 = new ModuleBean();
        moduleBean5.setName("物资租用");
        List<ModuleBean.MBean> mBeanList5 = new ArrayList<>();
        mBeanList5.add(new ModuleBean.MBean("CH1", "租用出库"));
        mBeanList5.add(new ModuleBean.MBean("CH2", "租用出库退仓"));
        mBeanList5.add(new ModuleBean.MBean("CI1", "其它租用出库"));
        mBeanList5.add(new ModuleBean.MBean("CI2", "其它租用出库退仓"));
        mBeanList5.add(new ModuleBean.MBean("CK1", "租用还入"));
        moduleBean5.setmBeanList(mBeanList5);

        ModuleBean moduleBean6 = new ModuleBean();
        moduleBean6.setName("物资销售");
        List<ModuleBean.MBean> mBeanList6 = new ArrayList<>();
        mBeanList6.add(new ModuleBean.MBean("CF1", "销售出库"));
        mBeanList6.add(new ModuleBean.MBean("CF2", "销售出库退货"));
        mBeanList6.add(new ModuleBean.MBean("CG1", "其它销售出库"));
        mBeanList6.add(new ModuleBean.MBean("CG2", "其它销售出库退货"));
        moduleBean6.setmBeanList(mBeanList6);

        ModuleBean moduleBean7 = new ModuleBean();
        moduleBean7.setName("物资仓库");
        List<ModuleBean.MBean> mBeanList7 = new ArrayList<>();
        mBeanList7.add(new ModuleBean.MBean("PC", "盘点/时间区间盘点"));
        mBeanList7.add(new ModuleBean.MBean("CDB", "物资调拨"));
        moduleBean7.setmBeanList(mBeanList7);

        ModuleBean moduleBean8 = new ModuleBean();
        moduleBean8.setName("物资调动");
        List<ModuleBean.MBean> mBeanList8 = new ArrayList<>();
        mBeanList8.add(new ModuleBean.MBean("CJ1", "物资调出"));
        mBeanList8.add(new ModuleBean.MBean("RJ1", "物资调入"));
        mBeanList8.add(new ModuleBean.MBean("CJ2", "其它调出"));
        mBeanList8.add(new ModuleBean.MBean("RJ2", "其它调入"));
        moduleBean8.setmBeanList(mBeanList8);

        ModuleBean moduleBean9 = new ModuleBean();
        moduleBean9.setName("费用报销管理");
        List<ModuleBean.MBean> mBeanList9 = new ArrayList<>();
        mBeanList9.add(new ModuleBean.MBean("BX", "费用报销申请"));
        moduleBean9.setmBeanList(mBeanList9);

        moduleBeanList.add(moduleBean0);
        moduleBeanList.add(moduleBean1);
        moduleBeanList.add(moduleBean2);
        moduleBeanList.add(moduleBean3);
        moduleBeanList.add(moduleBean4);
        moduleBeanList.add(moduleBean5);
        moduleBeanList.add(moduleBean6);
        moduleBeanList.add(moduleBean7);
        moduleBeanList.add(moduleBean8);
        moduleBeanList.add(moduleBean9);

    }

    private void downPopwindow() {
        // showAsDropDown(View anchor);相对某个控件的位置（正左下方），无偏移
        // showAsDropDown(View anchor, int x, int
        // y);相对某个控件的位置，有偏移;x表示相对x轴的偏移，正表示向左，负表示向右；y表示相对y轴的偏移，正是向下，负是向上；
        View contentView = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.pop_down,
                null);
        int screenHeight = dm.heightPixels * 2 / 3;
        // 这里就给具体大小的数字，要不然位置不好计算
        popWindow = new PopupWindow(contentView, LayoutParams.MATCH_PARENT,
                screenHeight);
        // popWindow.setAnimationStyle(R.style.anim);// 淡入淡出动画
        // popWindow.setTouchable(false);// 是否响应touch事件
        popWindow.setFocusable(true);// 是否具有获取焦点的能力
        // 点击PopupWindow以外的区域，PopupWindow是否会消失。
        popWindow.setBackgroundDrawable(new BitmapDrawable());
        popWindow.setOutsideTouchable(true);

        mainlist = (ListView) contentView.findViewById(R.id.classify_mainlist);
        morelist = (ListView) contentView.findViewById(R.id.classify_morelist);

        mainAdapter = new MainAdapter(MyApplication.getContext(), moduleBeanList);
        mainAdapter.setSelectItem(0);
        mainlist.setAdapter(mainAdapter);
        mainlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<ModuleBean.MBean> lists = moduleBeanList.get(position).getmBeanList();
                initAdapter(lists);
                mainAdapter.setSelectItem(position);
                mainAdapter.notifyDataSetChanged();
            }
        });

        mainlist.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        // 一定要设置这个属性，否则ListView不会刷新
        initAdapter(moduleBeanList.get(0).getmBeanList());

        morelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProgressDialogUtils.showProgressDialog(getActivity(), "正在加载...");
                ModuleBean.MBean s = moreAdapter.getItem(position);
                //Toast.makeText(MyApplication.getContext(), s.getModulec(), Toast.LENGTH_SHORT).show();
                moreAdapter.setSelectItem(position);
                moreAdapter.notifyDataSetChanged();
                tv.setText(s.getModulec());
                popWindow.dismiss();
                audirecordBeanList.clear();
                adapter = null;
                mLRecyclerViewAdapter.notifyDataSetChanged();//必须调用此方法
                currentPage = 1;
                param.setCurrentPage(currentPage);
                param.setModule(s.getModule());
                if ("dbl".equals(blzt)){
                    presenter.getAudirecord(url1, param);
                }else {
                    presenter.getAudirecord(url, param);
                }
            }
        });
        popWindow.showAsDropDown(tv);
    }

    private void initAdapter(List<ModuleBean.MBean> lists) {
        moreAdapter = new MoreAdapter(MyApplication.getContext(), lists);
        morelist.setAdapter(moreAdapter);
        moreAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
        downPopwindow();
    }

    @Override
    public void onStop() {
        super.onStop();
        handler.removeMessages(1);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeMessages(1);
    }

    @Override
    public void onResume() {
        super.onResume();
        rgDeal.setEnabled(true);
        rbDeal1.setEnabled(true);
        rbDeal2.setEnabled(true);
    }
}
