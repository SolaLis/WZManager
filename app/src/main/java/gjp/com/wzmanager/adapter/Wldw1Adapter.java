package gjp.com.wzmanager.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import gjp.com.wzmanager.R;
import gjp.com.wzmanager.bean.ClientBean;

/**
 * Created by Administrator on 2017/7/11.
 */

public class Wldw1Adapter extends BaseQuickAdapter<ClientBean,BaseViewHolder> {

    public Wldw1Adapter(@LayoutRes int layoutResId, @Nullable List<ClientBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ClientBean item) {
        helper.setText(R.id.tv_item_wldw_name,item.getClient_name());
        helper.setText(R.id.tv_item_wldw_lxr,item.getClient_lxr());


    }
}
