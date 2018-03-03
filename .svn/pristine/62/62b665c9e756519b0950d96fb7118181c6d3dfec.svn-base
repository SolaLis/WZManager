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
import gjp.com.wzmanager.bean.ClientBean;

/**
 * Created by Administrator on 2017/7/8.
 */

public class Wldw2Adapter extends RecyclerView.Adapter<Wldw2Adapter.ViewHolder> {

    private List<ClientBean> clientBeanList;

    public Wldw2Adapter(List<ClientBean> clientBeanList) {
        this.clientBeanList = clientBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wldw, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClientBean clientBean = clientBeanList.get(position);
        holder.tvItemWldwName.setText(clientBean.getClient_name());
        holder.tvItemWldwLxr.setText(clientBean.getClient_lxr());
        holder.tvItemWldwYsmoney.setText(clientBean.getYs_money());
        holder.tvItemWldwPsmoney.setText(clientBean.getPs_money());
        holder.tvItemWldwTel.setText(clientBean.getClient_tel());
        holder.tvItemWldwYfmoney.setText(clientBean.getYf_money());
        holder.tvItemWldwPfmoney.setText(clientBean.getPf_money());
    }
    @Override
    public int getItemCount() {
        return clientBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_wldw_name)
        TextView tvItemWldwName;
        @BindView(R.id.tv_item_wldw_lxr)
        TextView tvItemWldwLxr;
        @BindView(R.id.tv_item_wldw_ysmoney)
        TextView tvItemWldwYsmoney;
        @BindView(R.id.tv_item_wldw_psmoney)
        TextView tvItemWldwPsmoney;
        @BindView(R.id.tv_item_wldw_tel)
        TextView tvItemWldwTel;
        @BindView(R.id.tv_item_wldw_yfmoney)
        TextView tvItemWldwYfmoney;
        @BindView(R.id.tv_item_wldw_pfmoney)
        TextView tvItemWldwPfmoney;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}
