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
import gjp.com.wzmanager.bean.PcTimeMxBean;
import gjp.com.wzmanager.ui.CHScrollView1;
import gjp.com.wzmanager.ui.CHScrollView2;
import gjp.com.wzmanager.util.NumUtil;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

/**
 * 物资调拨和其他调入
 * Created by Administrator on 2017/7/8.
 */
public class PdTimeMxAdapter extends RecyclerView.Adapter<PdTimeMxAdapter.ViewHolder> {

    private List<PcTimeMxBean> pcTimeMxBeanList;
    private List<CHScrollView1> mHScrollViews1;
    private List<CHScrollView2> mHScrollViews;
    private RecyclerView rv;
    private int flag;

    public PdTimeMxAdapter(List<PcTimeMxBean> pcTimeMxBeanList, List<CHScrollView2> mHScrollViews, RecyclerView rv) {
        this.pcTimeMxBeanList = pcTimeMxBeanList;
        this.mHScrollViews = mHScrollViews;
        this.rv = rv;
    }

    public PdTimeMxAdapter(List<PcTimeMxBean> pcTimeMxBeanList, List<CHScrollView1> mHScrollViews1, RecyclerView rv, int flag) {
        this.pcTimeMxBeanList = pcTimeMxBeanList;
        this.mHScrollViews1 = mHScrollViews1;
        this.rv = rv;
        this.flag = flag;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if ("1".equals(SharedPreferencesUtil.getStringData(MyApplication.getContext(),
                "islistPush", null))) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pd_time_mx, parent, false);
            //第一次初始化的时候装进来
            addHViews((CHScrollView2) view.findViewById(R.id.item_chscroll_scroll));
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pd_time_mx_1, parent, false);
            //第一次初始化的时候装进来
            addHViews1((CHScrollView1) view.findViewById(R.id.item_chscroll_scroll));
        }
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PcTimeMxBean pcTimeMxBean = pcTimeMxBeanList.get(position);
        int xh = pcTimeMxBean.getXH();
        holder.tvItemZcMx1.setText(xh + "");
        holder.tvItemZcMx2.setText(pcTimeMxBean.getCKMC());
        holder.tvItemZcMx3.setText(pcTimeMxBean.getCCW());
        holder.tvItemZcMx4.setText(pcTimeMxBean.getMC());
        holder.tvItemZcMx5.setText(pcTimeMxBean.getGG());
        holder.tvItemZcMx6.setText(pcTimeMxBean.getJL());
        String rq = pcTimeMxBean.getSCRQ();
        if (rq == null || rq.length() == 0 || "0001-01-01T00:00:00".equals(rq)) {
            rq = "";
        } else {
            rq = rq.split("T")[0];
        }
        holder.tvItemZcMx7.setText(rq);
        holder.tvItemZcMx8.setText(pcTimeMxBean.getCRKPZH());
        holder.tvItemZcMx9.setText(pcTimeMxBean.getCRK_XH());
        holder.tvItemZcMx10.setText(pcTimeMxBean.getBZQ());
        holder.tvItemZcMx11.setText(NumUtil.doubleTrans(pcTimeMxBean.getSL()));
        holder.tvItemZcMx12.setText(NumUtil.doubleTrans(pcTimeMxBean.getJS()));
        holder.tvItemZcMx13.setText(NumUtil.doubleTrans(pcTimeMxBean.getPCSL()));
        holder.tvItemZcMx14.setText(NumUtil.doubleTrans(pcTimeMxBean.getPCJS()));
        holder.tvItemZcMx15.setText(pcTimeMxBean.getWLBZ());
        holder.tvItemZcMx16.setText(pcTimeMxBean.getKcsl());
        holder.tvItemZcMx17.setText(pcTimeMxBean.getKcjs());
        holder.tvItemZcMx18.setText(pcTimeMxBean.getRksl());
        holder.tvItemZcMx19.setText(pcTimeMxBean.getRkjs());
        holder.tvItemZcMx20.setText(pcTimeMxBean.getCksl());
        holder.tvItemZcMx21.setText(pcTimeMxBean.getCkjs());
        holder.tvItemZcMx22.setText(pcTimeMxBean.getSprq().replace("T"," ").substring(0,16));


    }

    @Override
    public int getItemCount() {
        return pcTimeMxBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item_zc_mx_1)
        TextView tvItemZcMx1;
        @BindView(R.id.tv_item_zc_mx_2)
        TextView tvItemZcMx2;
        @BindView(R.id.tv_item_zc_mx_3)
        TextView tvItemZcMx3;
        @BindView(R.id.tv_item_zc_mx_4)
        TextView tvItemZcMx4;
        @BindView(R.id.tv_item_zc_mx_5)
        TextView tvItemZcMx5;
        @BindView(R.id.tv_item_zc_mx_6)
        TextView tvItemZcMx6;
        @BindView(R.id.tv_item_zc_mx_7)
        TextView tvItemZcMx7;
        @BindView(R.id.tv_item_zc_mx_8)
        TextView tvItemZcMx8;
        @BindView(R.id.tv_item_zc_mx_9)
        TextView tvItemZcMx9;
        @BindView(R.id.tv_item_zc_mx_10)
        TextView tvItemZcMx10;
        @BindView(R.id.tv_item_zc_mx_16)
        TextView tvItemZcMx16;
        @BindView(R.id.tv_item_zc_mx_17)
        TextView tvItemZcMx17;
        @BindView(R.id.tv_item_zc_mx_18)
        TextView tvItemZcMx18;
        @BindView(R.id.tv_item_zc_mx_19)
        TextView tvItemZcMx19;
        @BindView(R.id.tv_item_zc_mx_20)
        TextView tvItemZcMx20;
        @BindView(R.id.tv_item_zc_mx_21)
        TextView tvItemZcMx21;
        @BindView(R.id.tv_item_zc_mx_22)
        TextView tvItemZcMx22;
        @BindView(R.id.tv_item_zc_mx_11)
        TextView tvItemZcMx11;
        @BindView(R.id.tv_item_zc_mx_12)
        TextView tvItemZcMx12;
        @BindView(R.id.tv_item_zc_mx_13)
        TextView tvItemZcMx13;
        @BindView(R.id.tv_item_zc_mx_14)
        TextView tvItemZcMx14;
        @BindView(R.id.tv_item_zc_mx_15)
        TextView tvItemZcMx15;

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
            //if (scrollY != 0) {
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
            //if (scrollX != 0) {
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
