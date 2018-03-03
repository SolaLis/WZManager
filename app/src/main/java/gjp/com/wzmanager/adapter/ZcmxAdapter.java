package gjp.com.wzmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
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
 * Created by Administrator on 2017/7/8.
 */
public class ZcmxAdapter extends RecyclerView.Adapter<ZcmxAdapter.ViewHolder> {
    private List<CkzcmxBean> ckzcmxBeanList;
    private List<CHScrollView2> mHScrollViews;
    private List<CHScrollView1> mHScrollViews1;
    private RecyclerView rv;
    private int flag;

    public ZcmxAdapter(List<CkzcmxBean> ckzcmxBeanList, List<CHScrollView2> mHScrollViews, RecyclerView rv) {
        this.ckzcmxBeanList = ckzcmxBeanList;
        this.mHScrollViews = mHScrollViews;
        this.rv = rv;
    }

    public ZcmxAdapter(List<CkzcmxBean> ckzcmxBeanList, List<CHScrollView1> mHScrollViews1, RecyclerView rv, int flag) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_zc_mx, parent, false);
            //第一次初始化的时候装进来
            addHViews((CHScrollView2) view.findViewById(R.id.item_chscroll_scroll));
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_zc_mx_1, parent, false);
            //第一次初始化的时候装进来
            addHViews1((CHScrollView1) view.findViewById(R.id.item_chscroll_scroll));
        }
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CkzcmxBean ckzcmxBean = ckzcmxBeanList.get(position);
        String module=ckzcmxBean.getPZH().substring(0,3);
        if ("RQC".equals(module)){
            holder.tvItemZcMx2.setVisibility(View.GONE);
            holder.tvItemZcMx3.setVisibility(View.GONE);
            holder.tvItemZcMx20.setVisibility(View.GONE);
            holder.tvItemZcMx21.setVisibility(View.GONE);
        }
        if ("CJ1".equals(module)){
            holder.tvItemZcMx20.setVisibility(View.GONE);
            holder.tvItemZcMx21.setVisibility(View.GONE);
        }
        // 物资入库
        String[] moduleWzrk = {"RB1", "RB2","CI1", "CI2","CG1","CG2","RJ1","RJ2"};
        List<String> listWzrk = Arrays.asList(moduleWzrk);
        if (listWzrk.contains(module)){
            holder.tvItemZcMx2.setVisibility(View.GONE);
            holder.tvItemZcMx3.setVisibility(View.GONE);
        }
        //物资领用
        String[] moduleWzly = {"CA1", "CA2", "CD1", "CD2",
                "CB1", "CB2", "CE1", "CE2","CC1",
               "CK1","CJ1","CJ2","RJ1","RJ2"};
        List<String> listWzly = Arrays.asList(moduleWzly);
        if (listWzly.contains(module)){
            holder.tvItemZcMx15.setVisibility(View.GONE);
            holder.tvItemZcMx16.setVisibility(View.GONE);
            String[] moduleWzly1 = { "CD1", "CD2", "CE1", "CE2","CC1", "CI1", "CI2","CK1"};
            List<String> listWzly1 = Arrays.asList(moduleWzly1);
            if (listWzly1.contains(module)){
                holder.tvItemZcMx2.setVisibility(View.GONE);
                holder.tvItemZcMx3.setVisibility(View.GONE);
            }
        }
        int xh=position+1;
        holder.tvItemZcMx1.setText(xh+"");
        holder.tvItemZcMx2.setText(ckzcmxBean.getSQDH());
        holder.tvItemZcMx3.setText(ckzcmxBean.getSQDH_XH());
        holder.tvItemZcMx4.setText(ckzcmxBean.getCKMC());
        holder.tvItemZcMx5.setText(ckzcmxBean.getCCW());
        holder.tvItemZcMx6.setText(ckzcmxBean.getMC());
        holder.tvItemZcMx7.setText(ckzcmxBean.getGG());
        holder.tvItemZcMx8.setText(ckzcmxBean.getJL());
        String rq=ckzcmxBean.getSCRQ();
            if (rq==null||rq.length()==0||"0001-01-01T00:00:00".equals(rq)){
                rq="";
            }else {
                rq=rq.split("T")[0];
            }
        holder.tvItemZcMx9.setText(rq);
        holder.tvItemZcMx10.setText(ckzcmxBean.getCRKPZH());
        holder.tvItemZcMx11.setText(ckzcmxBean.getCRK_XH());
        holder.tvItemZcMx12.setText(ckzcmxBean.getBZQ());
        holder.tvItemZcMx13.setText(NumUtil.doubleTrans(ckzcmxBean.getSL()));
        holder.tvItemZcMx14.setText(NumUtil.doubleTrans(ckzcmxBean.getJS()));
     //物资入库
        String[] moduleXs = {"RA1", "RA2", "RB1", "RB2","RQC"};
        List<String> listXs = Arrays.asList(moduleXs);
        if (listXs.contains(module)){
            holder.tvItemZcMx15.setText(NumUtil.doubleTrans(ckzcmxBean.getDJ()));
            holder.tvItemZcMx16.setText(NumUtil.doubleTrans(ckzcmxBean.getJE()));
        }else {
            holder.tvItemZcMx15.setText(ckzcmxBean.getXsj());
            holder.tvItemZcMx16.setText(ckzcmxBean.getXsje());

        }
        holder.tvItemZcMx17.setText(ckzcmxBean.getBsbm());
        holder.tvItemZcMx18.setText(ckzcmxBean.getBsmc());
        holder.tvItemZcMx19.setText(ckzcmxBean.getWLBZ());
        holder.tvItemZcMx20.setText(ckzcmxBean.getCRK_XH1());
        holder.tvItemZcMx21.setText(ckzcmxBean.getCRKPZH1());
        // 归还日期
        String[] moduleGhrq = {"CB1", "CB2", "CE1", "CE2","CH1", "CH2", "CI1", "CI2"};
        List<String> listGhrq= Arrays.asList(moduleGhrq);
        if (listGhrq.contains(module)) {
            String ghrq=ckzcmxBean.getGhrq();
            if (ghrq==null||ghrq.length()==0||"0001-01-01T00:00:00".equals(ghrq)){
                ghrq="";
            }else {
                ghrq=ghrq.split("T")[0];
            }
            holder.tvItemZcMx22.setVisibility(View.VISIBLE);
            holder.tvItemZcMx22.setText(ghrq);
        }
        else {
            holder.tvItemZcMx22.setVisibility(View.GONE);
        }
    }
    @Override
    public int getItemCount() {
        return ckzcmxBeanList.size();
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
          //  }
        }
        mHScrollViews1.add(hScrollView);
    }
}
