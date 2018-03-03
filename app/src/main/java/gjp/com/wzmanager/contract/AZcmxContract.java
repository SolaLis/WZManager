package gjp.com.wzmanager.contract;

import gjp.com.wzmanager.bean.AudirecordMxZcBean;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.param.AudirecordMxParam;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * Created by Administrator on 2017/8/2.
 */

public interface AZcmxContract {
    interface Model extends IModel {
        void getZcmx(String url, AudirecordMxParam param, AsyncCallback callback);
    }

    interface View extends IView {

        void getZcmxSuccess(AudirecordMxZcBean list);

        void getZcmxFailed(String errorMessage);
    }

    interface Presenter extends IPresenter {
        void getZcmx(String url, AudirecordMxParam param);
    }
}
