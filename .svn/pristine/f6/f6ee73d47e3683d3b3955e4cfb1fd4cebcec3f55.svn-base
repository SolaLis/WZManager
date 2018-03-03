package gjp.com.wzmanager.contract;

import gjp.com.wzmanager.bean.AudirecordMxBean;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.param.AudirecordMxParam;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * Created by Administrator on 2017/7/26.
 */

public interface ASqbmxContract {
    interface Model extends IModel {
        void getSqbmx(String url, AudirecordMxParam param, AsyncCallback callback);
    }

    interface View extends IView {

        void getSqbmxSuccess(AudirecordMxBean list);

        void getSqbmxFailed(String errorMessage);
    }

    interface Presenter extends IPresenter {
        void getSqbmx(String url, AudirecordMxParam param);
    }
}