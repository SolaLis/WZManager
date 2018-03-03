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
import gjp.com.wzmanager.listener.MyItemClickListener;
import gjp.com.wzmanager.listener.MyItemLongClickListener;
import gjp.com.wzmanager.ui.CHScrollView1;
import gjp.com.wzmanager.ui.CHScrollView2;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

/**
 * Created by Administrator on 2017/7/8.
 */

public class SqcgAdapter extends RecyclerView.Adapter<SqcgAdapter.ViewHolder> {
    private List<SqbmxBean> sqbmxBeanList;
    private List<CHScrollView2> mHScrollViews;
    private List<CHScrollView1> mHScrollViews1;
    private RecyclerView rv;
    private int flag;
    private MyItemClickListener mItemClickListener;
    private MyItemLongClickListener mItemLongClickListener;
    public SqcgAdapter(List<SqbmxBean> sqbmxBeanList, List<CHScrollView2> mHScrollViews, RecyclerView rv) {
        this.sqbmxBeanList = sqbmxBeanList;
        this.mHScrollViews = mHScrollViews;
        this.rv = rv;
    }

    public SqcgAdapter(List<SqbmxBean> sqbmxBeanList, List<CHScrollView1> mHScrollViews1, RecyclerView rv, int flag) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sqdmx_cgsq, parent, false);
            //第一次初始化的时候装进来
            addHViews((CHScrollView2) view.findViewById(R.id.item_chscroll_scroll));
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sqdmx_cgsq_1, parent, false);
            //第一次初始化的时候装进来
            addHViews1((CHScrollView1) view.findViewById(R.id.item_chscroll_scroll));
        }
        ViewHolder holder = new ViewHolder(view,mItemClickListener,mItemLongClickListener);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SqbmxBean sqbmxBean = sqbmxBeanList.get(position);
        holder.tvItemSqbmxCgsq1.setText(sqbmxBean.getXH()+"");
        holder.tvItemSqbmxCgsq2.setText(sqbmxBean.getWLBM());
        holder.tvItemSqbmxCgsq3.setText(sqbmxBean.getMC());
        holder.tvItemSqbmxCgsq4.setText(sqbmxBean.getGG());
        holder.tvItemSqbmxCgsq5.setText(sqbmxBean.getPYM());
        holder.tvItemSqbmxCgsq6.setText(sqbmxBean.getJL());
        holder.tvItemSqbmxCgsq7.setText(sqbmxBean.getSL());
        holder.tvItemSqbmxCgsq8.setText(sqbmxBean.getJS());
        holder.tvItemSqbmxCgsq9.setText(sqbmxBean.getDJ());
        holder.tvItemSqbmxCgsq10.setText(sqbmxBean.getJE());
        holder.tvItemSqbmxCgsq11.setText(sqbmxBean.getWLBZ());
        holder.tvItemSqbmxCgsq12.setText(sqbmxBean.getYFSL());
        holder.tvItemSqbmxCgsq13.setText(sqbmxBean.getYJS());
        holder.tvItemSqbmxCgsq14.setText(sqbmxBean.getZYYFSL());
        holder.tvItemSqbmxCgsq15.setText(sqbmxBean.getZYYJS());
        holder.tvItemSqbmxCgsq16.setText(sqbmxBean.getTYFSL());
        holder.tvItemSqbmxCgsq17.setText(sqbmxBean.getTYJS());
        holder.tvItemSqbmxCgsq18.setText(sqbmxBean.getTZYYFSL());
        holder.tvItemSqbmxCgsq19.setText(sqbmxBean.getTZYYJS());

    }

    @Override
    public int getItemCount() {
        return sqbmxBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        @BindView(R.id.tv_item_sqbmx_cgsq_1)
        TextView tvItemSqbmxCgsq1;
        @BindView(R.id.tv_item_sqbmx_cgsq_2)
        TextView tvItemSqbmxCgsq2;
        @BindView(R.id.tv_item_sqbmx_cgsq_3)
        TextView tvItemSqbmxCgsq3;
        @BindView(R.id.tv_item_sqbmx_cgsq_4)
        TextView tvItemSqbmxCgsq4;
        @BindView(R.id.tv_item_sqbmx_cgsq_5)
        TextView tvItemSqbmxCgsq5;
        @BindView(R.id.tv_item_sqbmx_cgsq_6)
        TextView tvItemSqbmxCgsq6;
        @BindView(R.id.tv_item_sqbmx_cgsq_7)
        TextView tvItemSqbmxCgsq7;
        @BindView(R.id.tv_item_sqbmx_cgsq_8)
        TextView tvItemSqbmxCgsq8;
        @BindView(R.id.tv_item_sqbmx_cgsq_9)
        TextView tvItemSqbmxCgsq9;
        @BindView(R.id.tv_item_sqbmx_cgsq_10)
        TextView tvItemSqbmxCgsq10;
        @BindView(R.id.tv_item_sqbmx_cgsq_11)
        TextView tvItemSqbmxCgsq11;
        @BindView(R.id.tv_item_sqbmx_cgsq_12)
        TextView tvItemSqbmxCgsq12;
        @BindView(R.id.tv_item_sqbmx_cgsq_13)
        TextView tvItemSqbmxCgsq13;
        @BindView(R.id.tv_item_sqbmx_cgsq_14)
        TextView tvItemSqbmxCgsq14;
        @BindView(R.id.tv_item_sqbmx_cgsq_15)
        TextView tvItemSqbmxCgsq15;
        @BindView(R.id.tv_item_sqbmx_cgsq_16)
        TextView tvItemSqbmxCgsq16;
        @BindView(R.id.tv_item_sqbmx_cgsq_17)
        TextView tvItemSqbmxCgsq17;
        @BindView(R.id.tv_item_sqbmx_cgsq_18)
        TextView tvItemSqbmxCgsq18;
        @BindView(R.id.tv_item_sqbmx_cgsq_19)
        TextView tvItemSqbmxCgsq19;

        private MyItemClickListener mListener;
        private MyItemLongClickListener mLongClickListener;

        public ViewHolder(View itemView, MyItemClickListener mListener, MyItemLongClickListener mLongClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mListener = mListener;
            this.mLongClickListener = mLongClickListener;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

    /*    public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }*/
        /**
         * 点击监听
         */
        @Override
        public void onClick(View v) {
            if(mListener != null){
                mListener.onItemClick(v,getPosition());
            }
        }

        /**
         * 长按监听
         */
        @Override
        public boolean onLongClick(View arg0) {
            if(mLongClickListener != null){
                mLongClickListener.onItemLongClick(arg0, getPosition());
            }
            return true;
        }
    }

    public void addHViews(final CHScrollView2 hScrollView) {
        Log.e("LOG","addHViews(SqcgAdapter.java:137)==="+1);
        if (!mHScrollViews.isEmpty()) {
          //int size = mHScrollViews.size();
            //int size=sqbmxBeanList.size();
           // CHScrollView2 scrollView = mHScrollViews.get(size - 1);
            final int scrollY = mHScrollViews.get(0).getScrollY();
            //final int scrollY = scrollView.getScrollY();
             // Log.e("LOG","addHViews(SqcgAdapter.java:141)==size="+size+"==="+scrollY);
            Log.e("LOG","addHViews(SqcgAdapter.java:183)==scrollY="+scrollY);
          //  if (scrollY != 0) {
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
         //  int size = mHScrollViews1.size();
            //int size=sqbmxBeanList.size();
          //  CHScrollView1 scrollView = mHScrollViews1.get(size - 1);
            final int scrollX = mHScrollViews1.get(0).getScrollX();
           // Log.e("LOG","addHViews1(SqcgAdapter.java:162)=size=="+size+"==="+scrollX);
            Log.e("LOG","addHViews1(SqcgAdapter.java:204)=scrollX=="+scrollX);
           // if (scrollX != 0) {
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

    /**
     * 设置Item点击监听
     * @param listener
     */
    public void setOnItemClickListener(MyItemClickListener listener){
        this.mItemClickListener = listener;
    }

    public void setOnItemLongClickListener(MyItemLongClickListener listener){
        this.mItemLongClickListener = listener;
    }
}
