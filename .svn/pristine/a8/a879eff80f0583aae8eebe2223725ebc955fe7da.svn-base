package gjp.com.wzmanager.contract;

import java.util.List;

import gjp.com.wzmanager.bean.BmBean;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * Created by Administrator on 2017/7/22.
 */

public interface BmContract {
    interface Model extends IModel {
        void getBm(String url,String usercode,AsyncCallback callback);
    }

    interface View extends IView {

        void getBmSuccess(List<BmBean> list);

        void getBmFailed(String errorMessage);
    }

    interface Presenter extends IPresenter {
        void getBm(String url,String usercode);
    }
}
