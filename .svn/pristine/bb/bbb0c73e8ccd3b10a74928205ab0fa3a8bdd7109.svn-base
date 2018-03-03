package gjp.com.wzmanager.contract;

import java.util.List;

import gjp.com.wzmanager.bean.SqbmxBean;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * Created by Administrator on 2017/7/26.
 */

public interface SqbmxContract {
    interface Model extends IModel {
        void getSqbmx(String url, String sqdh, AsyncCallback callback);
    }

    interface View extends IView {

        void getSqbmxSuccess(List<SqbmxBean> list);

        void getSqbmxFailed(String errorMessage);
    }

    interface Presenter extends IPresenter {
        void getSqbmx(String url, String sqdh);
    }
}