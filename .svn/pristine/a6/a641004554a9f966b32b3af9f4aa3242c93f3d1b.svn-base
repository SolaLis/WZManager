package gjp.com.wzmanager.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import gjp.com.wzmanager.R;
import gjp.com.wzmanager.bean.BmBean;

/**
 * Created by Administrator on 2017/7/22.
 */

public class BmAdapter extends BaseQuickAdapter<BmBean,BaseViewHolder> {
    public BmAdapter(int layoutResId, List<BmBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BmBean item) {
        helper.setText(R.id.tv_bm_item_id,item.getBm_id());
        helper.setText(R.id.tv_bm_item_name,item.getBm_name());
    }
}
