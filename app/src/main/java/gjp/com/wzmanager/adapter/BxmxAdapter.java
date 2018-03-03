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
import gjp.com.wzmanager.bean.FeeaskMxBean;
import gjp.com.wzmanager.util.NumUtil;

/**
 * Created by Administrator on 2017/7/8.
 */
public class BxmxAdapter extends RecyclerView.Adapter<BxmxAdapter.ViewHolder> {

    private List<FeeaskMxBean> feeaskMxBeanList;

    public BxmxAdapter(List<FeeaskMxBean> feeaskMxBeanList) {
        this.feeaskMxBeanList = feeaskMxBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bx_mx, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FeeaskMxBean feeaskMxBean = feeaskMxBeanList.get(position);
        holder.tvItemBxMx1.setText(feeaskMxBean.getInputno()+"");
        holder.tvItemBxMx2.setText(feeaskMxBean.getContent());
        holder.tvItemBxMx3.setText(NumUtil.doubleTrans(feeaskMxBean.getQty()));
        holder.tvItemBxMx4.setText(NumUtil.doubleTrans(feeaskMxBean.getFmone()));

    }

    @Override
    public int getItemCount() {
        return feeaskMxBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item_bx_mx_1)
        TextView tvItemBxMx1;
        @BindView(R.id.tv_item_bx_mx_2)
        TextView tvItemBxMx2;
        @BindView(R.id.tv_item_bx_mx_3)
        TextView tvItemBxMx3;
        @BindView(R.id.tv_item_bx_mx_4)
        TextView tvItemBxMx4;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
