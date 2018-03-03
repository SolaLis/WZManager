package gjp.com.wzmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gjp.com.wzmanager.MyApplication;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.bean.SqbmxBean;
import gjp.com.wzmanager.ui.CHScrollView1;
import gjp.com.wzmanager.ui.CHScrollView2;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

/**
 * Created by Administrator on 2017/7/8.
 */

public class SqjyAdapter extends RecyclerView.Adapter<SqjyAdapter.ViewHolder> {

    private List<SqbmxBean> sqbmxBeanList;
    private List<CHScrollView2> mHScrollViews;
    private List<CHScrollView1> mHScrollViews1;
    private RecyclerView rv;
    private int flag;
    public SqjyAdapter(List<SqbmxBean> sqbmxBeanList, List<CHScrollView2> mHScrollViews, RecyclerView rv) {
        this.sqbmxBeanList = sqbmxBeanList;
        this.mHScrollViews = mHScrollViews;
        this.rv = rv;
    }

    public SqjyAdapter(List<SqbmxBean> sqbmxBeanList, List<CHScrollView1> mHScrollViews1, RecyclerView rv, int flag) {
        this.sqbmxBeanList = sqbmxBeanList;
        this.mHScrollViews1 = mHScrollViews1;
        this.rv = rv;
        this.flag = flag;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if ("1".equals(SharedPreferencesUtil.getStringData(MyApplication.getContext(),
                "islistPush", null))) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sqdmx_jysq, parent, false);
            //第一次初始化的时候装进来
            addHViews((CHScrollView2) view.findViewById(R.id.item_chscroll_scroll));
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sqdmx_jysq_1, parent, false);
            //第一次初始化的时候装进来
            addHViews1((CHScrollView1) view.findViewById(R.id.item_chscroll_scroll));
        }
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SqbmxBean sqbmxBean = sqbmxBeanList.get(position);
        holder.tvItemSqbmxJysq1.setText(sqbmxBean.getXH() + "");
        holder.tvItemSqbmxJysq2.setText(sqbmxBean.getWLBM());
        holder.tvItemSqbmxJysq3.setText(sqbmxBean.getMC());
        holder.tvItemSqbmxJysq4.setText(sqbmxBean.getGG());
        holder.tvItemSqbmxJysq5.setText(sqbmxBean.getPYM());
        holder.tvItemSqbmxJysq6.setText(sqbmxBean.getJL());
        holder.tvItemSqbmxJysq7.setText(sqbmxBean.getSL());
        holder.tvItemSqbmxJysq8.setText(sqbmxBean.getJS());
        holder.tvItemSqbmxJysq9.setText(sqbmxBean.getWLBZ());
        holder.tvItemSqbmxJysq10.setText(sqbmxBean.getYFSL());
        holder.tvItemSqbmxJysq11.setText(sqbmxBean.getYJS());
        holder.tvItemSqbmxJysq12.setText(sqbmxBean.getGhrq().split("T")[0]);
        holder.tvItemSqbmxJysq13.setText(sqbmxBean.getZYYFSL());
        holder.tvItemSqbmxJysq14.setText(sqbmxBean.getZYYJS());
        holder.tvItemSqbmxJysq15.setText(sqbmxBean.getTYFSL());
        holder.tvItemSqbmxJysq16.setText(sqbmxBean.getTYJS());
        holder.tvItemSqbmxJysq17.setText(sqbmxBean.getTZYYFSL());
        holder.tvItemSqbmxJysq18.setText(sqbmxBean.getTZYYJS());

    }

    @Override
    public int getItemCount() {
        return sqbmxBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item_sqbmx_jysq_1)
        TextView tvItemSqbmxJysq1;
        @BindView(R.id.tv_item_sqbmx_jysq_2)
        TextView tvItemSqbmxJysq2;
        @BindView(R.id.tv_item_sqbmx_jysq_3)
        TextView tvItemSqbmxJysq3;
        @BindView(R.id.tv_item_sqbmx_jysq_4)
        TextView tvItemSqbmxJysq4;
        @BindView(R.id.tv_item_sqbmx_jysq_5)
        TextView tvItemSqbmxJysq5;
        @BindView(R.id.tv_item_sqbmx_jysq_6)
        TextView tvItemSqbmxJysq6;
        @BindView(R.id.tv_item_sqbmx_jysq_7)
        TextView tvItemSqbmxJysq7;
        @BindView(R.id.tv_item_sqbmx_jysq_8)
        TextView tvItemSqbmxJysq8;
        @BindView(R.id.tv_item_sqbmx_jysq_9)
        TextView tvItemSqbmxJysq9;
        @BindView(R.id.tv_item_sqbmx_jysq_10)
        TextView tvItemSqbmxJysq10;
        @BindView(R.id.tv_item_sqbmx_jysq_11)
        TextView tvItemSqbmxJysq11;
        @BindView(R.id.tv_item_sqbmx_jysq_12)
        TextView tvItemSqbmxJysq12;
        @BindView(R.id.tv_item_sqbmx_jysq_13)
        TextView tvItemSqbmxJysq13;
        @BindView(R.id.tv_item_sqbmx_jysq_14)
        TextView tvItemSqbmxJysq14;
        @BindView(R.id.tv_item_sqbmx_jysq_15)
        TextView tvItemSqbmxJysq15;
        @BindView(R.id.tv_item_sqbmx_jysq_16)
        TextView tvItemSqbmxJysq16;
        @BindView(R.id.tv_item_sqbmx_jysq_17)
        TextView tvItemSqbmxJysq17;
        @BindView(R.id.tv_item_sqbmx_jysq_18)
        TextView tvItemSqbmxJysq18;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void addHViews(final CHScrollView2 hScrollView) {
        Log.e("LOG","addHViews(SqcgAdapter.java:137)==="+0);
        if (!mHScrollViews.isEmpty()) {
            int size = mHScrollViews.size();
            CHScrollView2 scrollView = mHScrollViews.get(0);
            final int scrollY = scrollView.getScrollY();
            Log.e("LOG","addHViews(SqcgAdapter.java:141)==size="+size+"==="+scrollY);
           // if (scrollY != 0) {
                rv.post(new Runnable() {
                    @Override
                    public void run() {
                        //当listView刷新完成之后，把该条移动到最终位置
                        hScrollView.scrollTo(0, scrollY);
                    }
                });
           // }
        }
        mHScrollViews.add(hScrollView);
    }

    public void addHViews1(final CHScrollView1 hScrollView) {
        Log.e("LOG","addHViews1(SqcgAdapter.java:154)==="+1);
        if (!mHScrollViews1.isEmpty()) {
            int size = mHScrollViews1.size();
            CHScrollView1 scrollView = mHScrollViews1.get(0);
            final int scrollX = scrollView.getScrollX();
            Log.e("LOG","addHViews1(SqcgAdapter.java:162)=size=="+size+"==="+scrollX);
           // if (scrollX != 0) {
                rv.post(new Runnable() {
                    @Override
                    public void run() {
                        //当listView刷新完成之后，把该条移动到最终位置
                        hScrollView.scrollTo(scrollX, 0);
                    }
                });
            //}
        }
        mHScrollViews1.add(hScrollView);
    }
}
