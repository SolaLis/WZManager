package gjp.com.wzmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gjp.com.wzmanager.R;
import gjp.com.wzmanager.bean.EmployeeBean;

/**
 * Created by Administrator on 2017/7/25.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    private List<EmployeeBean> employeeBeanList;

    public EmployeeAdapter(List<EmployeeBean> employeeBeanList) {
        this.employeeBeanList = employeeBeanList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvBmItemId;

        TextView tvBmItemName;
        public ViewHolder(View itemView) {
            super(itemView);
            tvBmItemId= (TextView) itemView.findViewById(R.id.tv_bm_item_id);
            tvBmItemName= (TextView) itemView.findViewById(R.id.tv_bm_item_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bm, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            EmployeeBean employeeBean=employeeBeanList.get(position);
            holder.tvBmItemId.setText(employeeBean.getEm_code());
            holder.tvBmItemName.setText(employeeBean.getEm_name());
    }

    @Override
    public int getItemCount() {
        return employeeBeanList.size();
    }
}
