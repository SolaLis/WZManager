package gjp.com.wzmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.bean.AudireInfoBean;

/**
 * Created by Administrator on 2017/7/8.
 */

public class AudireInfoAdapter extends RecyclerView.Adapter<AudireInfoAdapter.ViewHolder> {
    //建立枚举 2个item 类型
    public enum ITEM_TYPE {ITEM1,ITEM2}

    private List<AudireInfoBean> audireInfoBeanList;

    public AudireInfoAdapter(List<AudireInfoBean> audireInfoBeanList) {
        this.audireInfoBeanList = audireInfoBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        if (viewType==ITEM_TYPE.ITEM2.ordinal()){
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_audire_info_red, parent, false);}
        else {
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_audire_info , parent, false);}
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        AudireInfoBean audireInfoBean = audireInfoBeanList.get(position);
        if ("0".equals(audireInfoBean.getAuditingflag())){
            return ITEM_TYPE.ITEM2.ordinal();
        }else {
            return ITEM_TYPE.ITEM1.ordinal();
        }

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AudireInfoBean audireInfoBean = audireInfoBeanList.get(position);
        int xh=position+1;
      //  holder.tvItemAudireInfo1.setText(xh + "");
        holder.tvItemAudireInfo2.setText(audireInfoBean.getUsernamec());
        holder.tvItemAudireInfo3.setText(audireInfoBean.getDates().substring(0,audireInfoBean.getDates().length()-3).replace("T"," "));
        holder.tvItemAudireInfo4.setText(audireInfoBean.getAudiuser_name());
        holder.tvItemAudireInfo5.setText(audireInfoBean.getAudit());
        String auditingdate=audireInfoBean.getAuditingdate();
        if ("0001-01-01T00:00:00".equals(auditingdate)){
            auditingdate="";
        }else {
            auditingdate=auditingdate.substring(0,auditingdate.length()-3).replace("T"," ");
        }
        holder.tvItemAudireInfo6.setText(auditingdate);
        holder.tvItemAudireInfo7.setText(audireInfoBean.getLevel()+"");
        holder.tvItemAudireInfo8.setText(audireInfoBean.getShlb());
        String shxm="";
        String audiitem=audireInfoBean.getAudiitem();
        if ("y".equals(audiitem)){
            shxm="执行";
        }else {
            shxm="准备/修改";
        }
        holder.tvItemAudireInfo9.setText(shxm);
        holder.tvItemAudireInfo10.setText(audireInfoBean.getAuditingidea());

    }

    @Override
    public int getItemCount() {
        return audireInfoBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_audire_info_2)
        TextView tvItemAudireInfo2;
        @BindView(R.id.tv_item_audire_info_3)
        TextView tvItemAudireInfo3;
        @BindView(R.id.tv_item_audire_info_4)
        TextView tvItemAudireInfo4;
        @BindView(R.id.tv_item_audire_info_5)
        TextView tvItemAudireInfo5;
        @BindView(R.id.tv_item_audire_info_6)
        TextView tvItemAudireInfo6;
        @BindView(R.id.tv_item_audire_info_7)
        TextView tvItemAudireInfo7;
        @BindView(R.id.tv_item_audire_info_8)
        TextView tvItemAudireInfo8;
        @BindView(R.id.tv_item_audire_info_9)
        TextView tvItemAudireInfo9;
        @BindView(R.id.tv_item_audire_info_10)
        TextView tvItemAudireInfo10;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
