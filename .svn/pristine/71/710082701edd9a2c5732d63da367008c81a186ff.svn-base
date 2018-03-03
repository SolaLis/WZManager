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
import gjp.com.wzmanager.bean.SqbBean;

/**
 * Created by Administrator on 2017/7/8.
 */

public class SqbAdapter extends RecyclerView.Adapter<SqbAdapter.ViewHolder> {


    private List<SqbBean> sqbBeanList;


    public SqbAdapter(List<SqbBean> sqbBeanList) {
        this.sqbBeanList = sqbBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sqd, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SqbBean sqbBean = sqbBeanList.get(position);
        holder.tvItemSqbSqdh.setText(sqbBean.getSqdh());
        holder.tvItemSqbSqr.setText(sqbBean.getSqr());
        String shzt="";
        String auditingflag=sqbBean.getAuditingflag();
        if ("0".equals(auditingflag)){
            shzt="制单";
        }else if ("1".equals(auditingflag)){
            shzt="待审中";
        }else if ("2".equals(auditingflag)){
            shzt="审核中";
        }else if ("y".equals(auditingflag)){
            shzt="审核完成";
        }
        holder.tvItemSqbShzt.setText(shzt);
        holder.tvItemSqbSqbm.setText(sqbBean.getSqbm());
        holder.tvItemSqbSqsj.setText(sqbBean.getSqrq().split("T")[0]);

    }

    @Override
    public int getItemCount() {
        return sqbBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_sqb_sqdh)
        TextView tvItemSqbSqdh;
        @BindView(R.id.tv_item_sqb_sqr)
        TextView tvItemSqbSqr;
        @BindView(R.id.tv_item_sqb_shzt)
        TextView tvItemSqbShzt;
        @BindView(R.id.tv_item_sqb_sqbm)
        TextView tvItemSqbSqbm;
        @BindView(R.id.tv_item_sqb_sqsj)
        TextView tvItemSqbSqsj;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
