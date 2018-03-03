package gjp.com.wzmanager.presenter;

import java.util.List;

import gjp.com.wzmanager.bean.ClientBean;
import gjp.com.wzmanager.contract.WldwContract;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.model.WldwModel;

/**
 * Created by Administrator on 2017/7/13.
 */

public class WldwPresenter implements WldwContract.Presenter {
    private WldwContract.View view;
    private WldwContract.Model model;

    public WldwPresenter(WldwContract.View view) {
        this.view = view;
        this.model=new WldwModel();
    }
    @Override
    public void getGhdw(String strCondition, int currPage) {
        model.getGhdw(strCondition,currPage ,new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                List<ClientBean> list= (List<ClientBean>) success;
                view.getGhdwSuccess(list);
            }

            @Override
            public void onError(Object error) {
                view.getGhdwFailed(error.toString());
            }
        });

    }
}
