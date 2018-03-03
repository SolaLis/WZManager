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

public class SqdrAdapter extends RecyclerView.Adapter<SqdrAdapter.ViewHolder> {
    private List<SqbmxBean> sqbmxBeanList;
    private List<CHScrollView2> mHScrollViews;
    private List<CHScrollView1> mHScrollViews1;
    private RecyclerView rv;
    private int flag;

    public SqdrAdapter(List<SqbmxBean> sqbmxBeanList, List<CHScrollView2> mHScrollViews, RecyclerView rv) {
        this.sqbmxBeanList = sqbmxBeanList;
        this.mHScrollViews = mHScrollViews;
        this.rv = rv;
    }

    public SqdrAdapter(List<SqbmxBean> sqbmxBeanList, List<CHScrollView1> mHScrollViews1, RecyclerView rv, int flag) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sqdmx_drsq, parent, false);
            //第一次初始化的时候装进来
            addHViews((CHScrollView2) view.findViewById(R.id.item_chscroll_scroll));
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sqdmx_drsq_1, parent, false);
            //第一次初始化的时候装进来
            addHViews1((CHScrollView1) view.findViewById(R.id.item_chscroll_scroll));
        }
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SqbmxBean sqbmxBean = sqbmxBeanList.get(position);
        holder.tvItemSqbmxLysq1.setText(sqbmxBean.getXH() + "");
        holder.tvItemSqbmxLysq2.setText(sqbmxBean.getWLBM());
        holder.tvItemSqbmxLysq3.setText(sqbmxBean.getMC());
        holder.tvItemSqbmxLysq4.setText(sqbmxBean.getGG());
        holder.tvItemSqbmxLysq5.setText(sqbmxBean.getPYM());
        holder.tvItemSqbmxLysq6.setText(sqbmxBean.getJL());
        holder.tvItemSqbmxLysq7.setText(sqbmxBean.getSL());
        holder.tvItemSqbmxLysq8.setText(sqbmxBean.getJS());
        holder.tvItemSqbmxLysq9.setText(sqbmxBean.getYFSL());
        holder.tvItemSqbmxLysq10.setText(sqbmxBean.getYJS());
        holder.tvItemSqbmxLysq11.setText(sqbmxBean.getWLBZ());
        holder.tvItemSqbmxLysq12.setText(sqbmxBean.getZYYFSL());
        holder.tvItemSqbmxLysq13.setText(sqbmxBean.getZYYJS());
        holder.tvItemSqbmxLysq14.setText(sqbmxBean.getTYFSL());
        holder.tvItemSqbmxLysq15.setText(sqbmxBean.getTYJS());
        holder.tvItemSqbmxLysq16.setText(sqbmxBean.getTZYYFSL());
        holder.tvItemSqbmxLysq17.setText(sqbmxBean.getTZYYJS());

    }

    @Override
    public int getItemCount() {
        return sqbmxBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_sqbmx_lysq_1)
        TextView tvItemSqbmxLysq1;
        @BindView(R.id.tv_item_sqbmx_lysq_2)
        TextView tvItemSqbmxLysq2;
        @BindView(R.id.tv_item_sqbmx_lysq_3)
        TextView tvItemSqbmxLysq3;
        @BindView(R.id.tv_item_sqbmx_lysq_4)
        TextView tvItemSqbmxLysq4;
        @BindView(R.id.tv_item_sqbmx_lysq_5)
        TextView tvItemSqbmxLysq5;
        @BindView(R.id.tv_item_sqbmx_lysq_6)
        TextView tvItemSqbmxLysq6;
        @BindView(R.id.tv_item_sqbmx_lysq_7)
        TextView tvItemSqbmxLysq7;
        @BindView(R.id.tv_item_sqbmx_lysq_8)
        TextView tvItemSqbmxLysq8;
        @BindView(R.id.tv_item_sqbmx_lysq_9)
        TextView tvItemSqbmxLysq9;
        @BindView(R.id.tv_item_sqbmx_lysq_10)
        TextView tvItemSqbmxLysq10;
        @BindView(R.id.tv_item_sqbmx_lysq_11)
        TextView tvItemSqbmxLysq11;
        @BindView(R.id.tv_item_sqbmx_lysq_12)
        TextView tvItemSqbmxLysq12;
        @BindView(R.id.tv_item_sqbmx_lysq_13)
        TextView tvItemSqbmxLysq13;
        @BindView(R.id.tv_item_sqbmx_lysq_14)
        TextView tvItemSqbmxLysq14;
        @BindView(R.id.tv_item_sqbmx_lysq_15)
        TextView tvItemSqbmxLysq15;
        @BindView(R.id.tv_item_sqbmx_lysq_16)
        TextView tvItemSqbmxLysq16;
        @BindView(R.id.tv_item_sqbmx_lysq_17)
        TextView tvItemSqbmxLysq17;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void addHViews(final CHScrollView2 hScrollView) {
        Log.e("LOG","addHViews(SqcgAdapter.java:137)==="+1);
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
         //   }
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
          //  if (scrollX != 0) {
                rv.post(new Runnable() {
                    @Override
                    public void run() {
                        //当listView刷新完成之后，把该条移动到最终位置
                        hScrollView.scrollTo(scrollX, 0);
                    }
                });
           // }
        }
        mHScrollViews1.add(hScrollView);
    }
}
