package gjp.com.wzmanager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jdsjlzx.ItemDecoration.DividerDecoration;
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
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.adapter.WldwAdapter;
import gjp.com.wzmanager.bean.ClientBean;
import gjp.com.wzmanager.contract.WldwContract;
import gjp.com.wzmanager.presenter.WldwPresenter;

public class TestActivity extends AppCompatActivity implements WldwContract.View {

    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    private WldwContract.Presenter presenter;
    private int currPage = 1;
    private List<ClientBean> clientBeanList = new ArrayList<>();
    private WldwAdapter wldwAdapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;
   /* private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 2:
                    mRecyclerView.setNoMore(true);
                    break;
                case 1:

                   *//* wldwAdapter=new Wldw1Adapter(R.layout.item_wldw,clientBeanList);
                    recyclerView.setAdapter(wldwAdapter);
                    //wldwAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                    wldwAdapter.openLoadAnimation(new BaseAnimation() {
                        @Override
                        public Animator[] getAnimators(View view) {
                            return new Animator[]{
                                    ObjectAnimator.ofFloat(view, "scaleY", 1, 1.1f, 1),
                                    ObjectAnimator.ofFloat(view, "scaleX", 1, 1.1f, 1)
                            };
                        }
                    });
                    wldwAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            Toast.makeText(TestActivity.this, "itemclick", Toast.LENGTH_SHORT).show();
                        }
                    });

                    wldwAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
                        @Override
                        public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                            Toast.makeText(TestActivity.this, "setOnItemLongClickListener", Toast.LENGTH_SHORT).show();

                            return false;
                        }
                    });
                        wldwAdapter.setFooterViewAsFlow(false);
                    wldwAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                        @Override
                        public void onLoadMoreRequested() {
                            Toast.makeText(TestActivity.this, "setOnLoadMoreListener", Toast.LENGTH_SHORT).show();
                            wldwAdapter.loadMoreEnd();
                        }
                    },recyclerView);*//*
                   clientBeanList.addAll(clientBeanList1);
                    Log.e("LOG", "handleMessage(TestActivity.java:46)===" + clientBeanList.size());
                    mRecyclerView.refreshComplete(5);

                    wldwAdapter = new WldwAdapter(clientBeanList);
                    lRecyclerViewAdapter = new LRecyclerViewAdapter(wldwAdapter);
                    mRecyclerView.setAdapter(lRecyclerViewAdapter);

                    break;
            }
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        init();


     /*   mRecyclerView.addItemDecoration(new RecycleViewDivider(
                this, LinearLayoutManager.HORIZONTAL, 10, R.color.colorPrimary));*/
        presenter=new WldwPresenter(this);
        presenter.getGhdw("",currPage);

        setListener();
    }

    private void init() {

    }

    private void setListener() {
        mRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                clientBeanList.clear();
                wldwAdapter=null;
                mLRecyclerViewAdapter.notifyDataSetChanged();//必须调用此方法
                currPage=1;
                presenter.getGhdw("",currPage);

            }
        });
        mRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                currPage++;
                presenter.getGhdw("",currPage);
            }
        });

    }
    private void setAdapter() {
        mRecyclerView.refreshComplete(6);
        if (mLRecyclerViewAdapter==null){
            wldwAdapter = new WldwAdapter(this,clientBeanList);
            mLRecyclerViewAdapter = new LRecyclerViewAdapter(wldwAdapter);
            mRecyclerView.setAdapter(mLRecyclerViewAdapter);
            //禁用自动加载更多功能
            //mRecyclerView.setLoadMoreEnabled(false);
            LinearLayoutManager lm = new LinearLayoutManager(TestActivity.this);
            mRecyclerView.setLayoutManager(lm);
            DividerDecoration divider = new DividerDecoration.Builder(TestActivity.this)
                    .setHeight(R.dimen.fgx)
                    .setPadding(R.dimen.fgx)
                    .setColorResource(R.color.red)
                    .build();

            //mRecyclerView.setHasFixedSize(true);
            mRecyclerView.addItemDecoration(divider);
//add a HeaderView
            final View header = LayoutInflater.from(this).inflate(R.layout.sample_header,(ViewGroup)findViewById(android.R.id.content), false);
            mLRecyclerViewAdapter.addHeaderView(header);
            mRecyclerView.setRefreshProgressStyle(ProgressStyle.LineSpinFadeLoader);
            mRecyclerView.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
            mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
            //设置头部加载颜色
            mRecyclerView.setHeaderViewColor(R.color.colorAccent, R.color.blue_size ,android.R.color.white);
            //设置底部加载颜色
            mRecyclerView.setFooterViewColor(R.color.colorAccent, R.color.blue_size ,android.R.color.white);
            //设置底部加载文字提示
            mRecyclerView.setFooterViewHint("拼命加载中","已经全部为你呈现了","网络不给力啊，点击再试一次吧");
        }else {
            mLRecyclerViewAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void getGhdwSuccess(List<ClientBean> list) {
        clientBeanList.addAll(list);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setAdapter();
            }
        });

    }


    @Override
    public void getGhdwFailed(final String errorMessage) {
        Log.e("LOG","run(TestActivity.java:199)==="+3);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if ("网络无连接".equals(errorMessage)){
                    Log.e("LOG","run(TestActivity.java:199)==="+2);
                    mRecyclerView.setOnNetWorkErrorListener(new OnNetWorkErrorListener() {
                        @Override
                        public void reload() {
                            presenter.getGhdw("",currPage);
                        }
                    });
                }else {
                    Log.e("LOG","run(TestActivity.java:199)==="+1);
                mRecyclerView.setNoMore(true);
                }
            }
        });

    }
}
