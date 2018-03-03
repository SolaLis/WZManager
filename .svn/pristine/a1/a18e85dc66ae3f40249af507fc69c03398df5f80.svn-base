package gjp.com.wzmanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gjp.com.wzmanager.R;
import gjp.com.wzmanager.bean.EmployeeBean;

/**
 * Created by Administrator on 2017/7/8.
 */

public class EAdapter extends RecyclerView.Adapter<SuperViewHolder> {
    protected Context mContext;
    private LayoutInflater mInflater;
    private List<EmployeeBean> mclientBeanList;

    public EAdapter(Context context, List<EmployeeBean> clientBeanList) {
        mContext = context;
        mclientBeanList = clientBeanList;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public SuperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_bm, parent, false);
        return new SuperViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SuperViewHolder holder, final int position) {
    ; EmployeeBean clientBean = mclientBeanList.get(position);
        TextView id = holder.getView(R.id.tv_bm_item_id);
        TextView name = holder.getView(R.id.tv_bm_item_name);

        id.setText(clientBean.getEm_code());
        name.setText(clientBean.getEm_name());

    }

    @Override
    public int getItemCount() {
        return mclientBeanList.size();
    }
    //局部刷新关键：带payload的这个onBindViewHolder方法必须实现
    @Override
    public void onBindViewHolder(SuperViewHolder holder, int position, List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            onBindItemHolder(holder, position, payloads);
        }

    }
    public void onBindItemHolder(SuperViewHolder holder, int position, List<Object> payloads){

    }

    /**
     * 和Activity通信的接口
     */
    public interface onSwipeListener {
        void onDel(int pos);

        void onTop(int pos);
    }

    private onSwipeListener mOnSwipeListener;

    public void setOnDelListener(onSwipeListener mOnDelListener) {
        this.mOnSwipeListener = mOnDelListener;
    }

}