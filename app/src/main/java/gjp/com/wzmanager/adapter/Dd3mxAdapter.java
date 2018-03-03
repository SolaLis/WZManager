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
import gjp.com.wzmanager.bean.CkzcmxBean;
import gjp.com.wzmanager.ui.CHScrollView1;
import gjp.com.wzmanager.ui.CHScrollView2;
import gjp.com.wzmanager.util.NumUtil;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

/**
 * 物资调拨和其他调入
 * Created by Administrator on 2017/7/8.
 */
public class Dd3mxAdapter extends RecyclerView.Adapter<Dd3mxAdapter.ViewHolder> {

    private List<CkzcmxBean> ckzcmxBeanList;
    private List<CHScrollView2> mHScrollViews;
    private List<CHScrollView1> mHScrollViews1;
    private RecyclerView rv;
    private int flag;

    public Dd3mxAdapter(List<CkzcmxBean> ckzcmxBeanList, List<CHScrollView2> mHScrollViews, RecyclerView rv) {
        this.ckzcmxBeanList = ckzcmxBeanList;
        this.mHScrollViews = mHScrollViews;
        this.rv = rv;
    }

    public Dd3mxAdapter(List<CkzcmxBean> ckzcmxBeanList, List<CHScrollView1> mHScrollViews1, RecyclerView rv, int flag) {
        this.ckzcmxBeanList = ckzcmxBeanList;
        this.mHScrollViews1 = mHScrollViews1;
        this.rv = rv;
        this.flag = flag;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if ("1".equals(SharedPreferencesUtil.getStringData(MyApplication.getContext(),
                "islistPush", null))) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_zc_dd3_mx, parent, false);
            //第一次初始化的时候装进来
            addHViews((CHScrollView2) view.findViewById(R.id.item_chscroll_scroll));
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_zc_dd3_mx1, parent, false);
            //第一次初始化的时候装进来
            addHViews1((CHScrollView1) view.findViewById(R.id.item_chscroll_scroll));
        }
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CkzcmxBean ckzcmxBean = ckzcmxBeanList.get(position);
        String module = ckzcmxBean.getPZH().substring(0, 3);
        if ("CJ2".equals(module)) {
            holder.tvItemZcDd3MxDrcw.setVisibility(View.GONE);
        } else {
            holder.tvItemZcDd3MxDrcw.setVisibility(View.VISIBLE);
            holder.tvItemZcDd3MxDrcw.setText(ckzcmxBean.getCwmc_r());
        }
        int xh = position + 1;
        holder.tvItemZcDd3Mx1.setText(xh + "");
        holder.tvItemZcDd3Mx2.setText(ckzcmxBean.getCKMC());
        holder.tvItemZcDd3Mx3.setText(ckzcmxBean.getCCW());
        holder.tvItemZcDd3Mx4.setText(ckzcmxBean.getCkmc_r());
        holder.tvItemZcDd3Mx5.setText(ckzcmxBean.getMC());
        holder.tvItemZcDd3Mx6.setText(ckzcmxBean.getGG());
        holder.tvItemZcDd3Mx7.setText(ckzcmxBean.getJL());
        String rq = ckzcmxBean.getSCRQ();
        if (rq == null || rq.length() == 0 || "0001-01-01T00:00:00".equals(rq)) {
            rq = "";
        } else {
            rq = rq.split("T")[0];
        }
        holder.tvItemZcDd3Mx8.setText(rq);
        holder.tvItemZcDd3Mx9.setText(ckzcmxBean.getCRKPZH());
        holder.tvItemZcDd3Mx10.setText(ckzcmxBean.getCRK_XH());
        holder.tvItemZcDd3Mx11.setText(ckzcmxBean.getBZQ());
        holder.tvItemZcDd3Mx12.setText(NumUtil.doubleTrans(ckzcmxBean.getSL()));
        holder.tvItemZcDd3Mx13.setText(NumUtil.doubleTrans(ckzcmxBean.getJS()));
        holder.tvItemZcDd3Mx14.setText(ckzcmxBean.getWLBZ());
        holder.tvItemZcDd3Mx15.setText(ckzcmxBean.getBsbm());
        holder.tvItemZcDd3Mx16.setText(ckzcmxBean.getBsmc());
    }

    @Override
    public int getItemCount() {
        return ckzcmxBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item_zc_dd3_mx_1)
        TextView tvItemZcDd3Mx1;
        @BindView(R.id.tv_item_zc_dd3_mx_2)
        TextView tvItemZcDd3Mx2;
        @BindView(R.id.tv_item_zc_dd3_mx_3)
        TextView tvItemZcDd3Mx3;
        @BindView(R.id.tv_item_zc_dd3_mx_4)
        TextView tvItemZcDd3Mx4;
        @BindView(R.id.tv_item_zc_dd3_mx_5)
        TextView tvItemZcDd3Mx5;
        @BindView(R.id.tv_item_zc_dd3_mx_6)
        TextView tvItemZcDd3Mx6;
        @BindView(R.id.tv_item_zc_dd3_mx_7)
        TextView tvItemZcDd3Mx7;
        @BindView(R.id.tv_item_zc_dd3_mx_8)
        TextView tvItemZcDd3Mx8;
        @BindView(R.id.tv_item_zc_dd3_mx_9)
        TextView tvItemZcDd3Mx9;
        @BindView(R.id.tv_item_zc_dd3_mx_10)
        TextView tvItemZcDd3Mx10;
        @BindView(R.id.tv_item_zc_dd3_mx_11)
        TextView tvItemZcDd3Mx11;
        @BindView(R.id.tv_item_zc_dd3_mx_12)
        TextView tvItemZcDd3Mx12;
        @BindView(R.id.tv_item_zc_dd3_mx_13)
        TextView tvItemZcDd3Mx13;
        @BindView(R.id.tv_item_zc_dd3_mx_14)
        TextView tvItemZcDd3Mx14;
        @BindView(R.id.tv_item_zc_dd3_mx_15)
        TextView tvItemZcDd3Mx15;
        @BindView(R.id.tv_item_zc_dd3_mx_16)
        TextView tvItemZcDd3Mx16;

        @BindView(R.id.tv_item_zc_dd3_mx_drcw)
        TextView tvItemZcDd3MxDrcw;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void addHViews(final CHScrollView2 hScrollView) {
        Log.e("LOG","addHViews(SqcgAdapter.java:137)==="+1);
        if (!mHScrollViews.isEmpty()) {
            int size = mHScrollViews.size();
            CHScrollView2 scrollView = mHScrollViews.get(size - 1);
            final int scrollY = scrollView.getScrollY();
            Log.e("LOG","addHViews(SqcgAdapter.java:141)==size="+size+"==="+scrollY);
            if (scrollY != 0) {
                rv.post(new Runnable() {
                    @Override
                    public void run() {
                        //当listView刷新完成之后，把该条移动到最终位置
                        hScrollView.scrollTo(0, scrollY);
                    }
                });
            }
        }
        mHScrollViews.add(hScrollView);
    }

    public void addHViews1(final CHScrollView1 hScrollView) {
        Log.e("LOG","addHViews1(SqcgAdapter.java:154)==="+1);
        if (!mHScrollViews1.isEmpty()) {
            int size = mHScrollViews1.size();
            CHScrollView1 scrollView = mHScrollViews1.get(size - 1);
            final int scrollX = scrollView.getScrollX();
            Log.e("LOG","addHViews1(SqcgAdapter.java:162)=size=="+size+"==="+scrollX);
            if (scrollX != 0) {
                rv.post(new Runnable() {
                    @Override
                    public void run() {
                        //当listView刷新完成之后，把该条移动到最终位置
                        hScrollView.scrollTo(scrollX, 0);
                    }
                });
            }
        }
        mHScrollViews1.add(hScrollView);
    }
}
