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

public class SqzyAdapter extends RecyclerView.Adapter<SqzyAdapter.ViewHolder> {


    private List<SqbmxBean> sqbmxBeanList;
    private List<CHScrollView2> mHScrollViews;
    private List<CHScrollView1> mHScrollViews1;
    private RecyclerView rv;
    private int flag;

    public SqzyAdapter(List<SqbmxBean> sqbmxBeanList, List<CHScrollView2> mHScrollViews, RecyclerView rv) {
        this.sqbmxBeanList = sqbmxBeanList;
        this.mHScrollViews = mHScrollViews;
        this.rv = rv;
    }

    public SqzyAdapter(List<SqbmxBean> sqbmxBeanList, List<CHScrollView1> mHScrollViews1, RecyclerView rv, int flag) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sqdmx_zysq, parent, false);
            //第一次初始化的时候装进来
            addHViews((CHScrollView2) view.findViewById(R.id.item_chscroll_scroll));
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sqdmx_zysq_1, parent, false);
            //第一次初始化的时候装进来
            addHViews1((CHScrollView1) view.findViewById(R.id.item_chscroll_scroll));
        }
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SqbmxBean sqbmxBean = sqbmxBeanList.get(position);
        holder.tvItemSqbmxZysq1.setText(sqbmxBean.getXH() + "");
        holder.tvItemSqbmxZysq2.setText(sqbmxBean.getWLBM());
        holder.tvItemSqbmxZysq3.setText(sqbmxBean.getMC());
        holder.tvItemSqbmxZysq4.setText(sqbmxBean.getGG());
        holder.tvItemSqbmxZysq5.setText(sqbmxBean.getPYM());
        holder.tvItemSqbmxZysq6.setText(sqbmxBean.getJL());
        holder.tvItemSqbmxZysq7.setText(sqbmxBean.getSL());
        holder.tvItemSqbmxZysq8.setText(sqbmxBean.getJS());
        holder.tvItemSqbmxZysq9.setText(sqbmxBean.getDJ());
        holder.tvItemSqbmxZysq10.setText(sqbmxBean.getJE());
        String ghrq = sqbmxBean.getGhrq();
     /*  Log.e("LOG","onBindViewHolder(SqzyAdapter.java:51)==="+ghrq);
        Log.e("LOG","onBindViewHolder(SqzyAdapter.java:53)==="+ BaseUtil.strIsEmpty(ghrq));
        Log.e("LOG","onBindViewHolder(SqzyAdapter.java:54)==="+"null".equals(ghrq));
        Log.e("LOG","onBindViewHolder(SqzyAdapter.java:54)==="+"".equals(ghrq));
        Log.e("LOG","onBindViewHolder(SqzyAdapter.java:54)==="+(ghrq==""));
        Log.e("LOG","onBindViewHolder(SqzyAdapter.java:54)==="+(ghrq.length()==0));*/

        if (ghrq == null ||ghrq.isEmpty()) {
            ghrq = "";
        } else {
            if ("0001-01-01T00:00:00".equals(ghrq)) {
                ghrq = "";
            } else {
                ghrq = ghrq.split("T")[0];
            }
        }

      /*  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss.SSS");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date date = df.parse(ghrq);
            ghrq=date.toString();
          //  System.out.println(df.parse(ghrq).toString());
        } catch (ParseException e) {
            e.printStackTrace();
            ghrq="";
        }*/


        holder.tvItemSqbmxZysq11.setText(ghrq);
        holder.tvItemSqbmxZysq12.setText(sqbmxBean.getWLBZ());
        holder.tvItemSqbmxZysq13.setText(sqbmxBean.getYFSL());
        holder.tvItemSqbmxZysq14.setText(sqbmxBean.getYJS());
        holder.tvItemSqbmxZysq15.setText(sqbmxBean.getZYYFSL());
        holder.tvItemSqbmxZysq16.setText(sqbmxBean.getZYYJS());
        holder.tvItemSqbmxZysq17.setText(sqbmxBean.getTYFSL());
        holder.tvItemSqbmxZysq18.setText(sqbmxBean.getTYJS());
        holder.tvItemSqbmxZysq19.setText(sqbmxBean.getTZYYFSL());
        holder.tvItemSqbmxZysq20.setText(sqbmxBean.getTZYYJS());

    }

    @Override
    public int getItemCount() {
        return sqbmxBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_sqbmx_zysq_1)
        TextView tvItemSqbmxZysq1;
        @BindView(R.id.tv_item_sqbmx_zysq_2)
        TextView tvItemSqbmxZysq2;
        @BindView(R.id.tv_item_sqbmx_zysq_3)
        TextView tvItemSqbmxZysq3;
        @BindView(R.id.tv_item_sqbmx_zysq_4)
        TextView tvItemSqbmxZysq4;
        @BindView(R.id.tv_item_sqbmx_zysq_5)
        TextView tvItemSqbmxZysq5;
        @BindView(R.id.tv_item_sqbmx_zysq_6)
        TextView tvItemSqbmxZysq6;
        @BindView(R.id.tv_item_sqbmx_zysq_7)
        TextView tvItemSqbmxZysq7;
        @BindView(R.id.tv_item_sqbmx_zysq_8)
        TextView tvItemSqbmxZysq8;
        @BindView(R.id.tv_item_sqbmx_zysq_9)
        TextView tvItemSqbmxZysq9;
        @BindView(R.id.tv_item_sqbmx_zysq_10)
        TextView tvItemSqbmxZysq10;
        @BindView(R.id.tv_item_sqbmx_zysq_11)
        TextView tvItemSqbmxZysq11;
        @BindView(R.id.tv_item_sqbmx_zysq_12)
        TextView tvItemSqbmxZysq12;
        @BindView(R.id.tv_item_sqbmx_zysq_13)
        TextView tvItemSqbmxZysq13;
        @BindView(R.id.tv_item_sqbmx_zysq_14)
        TextView tvItemSqbmxZysq14;
        @BindView(R.id.tv_item_sqbmx_zysq_15)
        TextView tvItemSqbmxZysq15;
        @BindView(R.id.tv_item_sqbmx_zysq_16)
        TextView tvItemSqbmxZysq16;
        @BindView(R.id.tv_item_sqbmx_zysq_17)
        TextView tvItemSqbmxZysq17;
        @BindView(R.id.tv_item_sqbmx_zysq_18)
        TextView tvItemSqbmxZysq18;
        @BindView(R.id.tv_item_sqbmx_zysq_19)
        TextView tvItemSqbmxZysq19;
        @BindView(R.id.tv_item_sqbmx_zysq_20)
        TextView tvItemSqbmxZysq20;

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
          //  }
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
         //   if (scrollX != 0) {
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
