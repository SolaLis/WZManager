package gjp.com.wzmanager.contract;

import java.util.List;

import gjp.com.wzmanager.bean.ClientBean;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * Created by Administrator on 2017/7/13.
 */

public interface WldwContract {
    interface Model extends IModel {
        void getGhdw(String strCondition,int currPage,AsyncCallback callback);
    }

    interface View extends IView {

        void getGhdwSuccess(List<ClientBean> list);

        void getGhdwFailed(String errorMessage);
    }

    interface Presenter extends IPresenter {
        void getGhdw(String strCondition,int currPage);
    }
}
