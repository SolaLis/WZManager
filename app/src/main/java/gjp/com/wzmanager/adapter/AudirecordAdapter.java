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
import gjp.com.wzmanager.bean.AudirecordBean;

/**
 * Created by Administrator on 2017/7/8.
 */

public class AudirecordAdapter extends RecyclerView.Adapter<AudirecordAdapter.ViewHolder> {



    private List<AudirecordBean> audirecordBeanList;

    public AudirecordAdapter(List<AudirecordBean> audirecordBeanList) {
        this.audirecordBeanList = audirecordBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_audirecord, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AudirecordBean audirecordBean = audirecordBeanList.get(position);
        holder.tvItemAudirecordSqdh.setText(audirecordBean.getKeyvalue());
        holder.tvItemAudirecordDjlx.setText(audirecordBean.getModulec());
        holder.tvItemAudirecordSqrq.setText(audirecordBean.getDates().split("T")[0]);
        holder.tvItemAudirecordSqbm.setText(audirecordBean.getBm_name());
        holder.tvItemAudirecordSqr.setText(audirecordBean.getUsernamec());
        String audiitem=audirecordBean.getAudiitem();
        String spxz="";
        if ("y".equals(audiitem)){
            spxz="执行";
        }else {
            spxz="准备/修改";
        }
        holder.tvItemAudirecordSpxz.setText(spxz);
        holder.tvItemAudirecordSqsm.setText(audirecordBean.getApplydescribe());
    }

    @Override
    public int getItemCount() {
        return audirecordBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_audirecord_sqdh)
        TextView tvItemAudirecordSqdh;
        @BindView(R.id.tv_item_audirecord_sqrq)
        TextView tvItemAudirecordSqrq;
        @BindView(R.id.tv_item_audirecord_sqr)
        TextView tvItemAudirecordSqr;
        @BindView(R.id.tv_item_audirecord_sqbm)
        TextView tvItemAudirecordSqbm;
        @BindView(R.id.tv_item_audirecord_djlx)
        TextView tvItemAudirecordDjlx;
        @BindView(R.id.tv_item_audirecord_spxz)
        TextView tvItemAudirecordSpxz;
        @BindView(R.id.tv_item_audirecord_sqsm)
        TextView tvItemAudirecordSqsm;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
