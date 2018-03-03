package gjp.com.wzmanager.contract;

import gjp.com.wzmanager.bean.PdMxBean;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.param.AudirecordMxParam;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * Created by Administrator on 2017/8/5.
 */

public interface PdContract {
    interface Model extends IModel {
        void getPdmx(String url, AudirecordMxParam param, AsyncCallback callback);
    }

    interface View extends IView {

        void getPdmxSuccess(PdMxBean list);

        void getPdmxFailed(String errorMessage);
    }

    interface Presenter extends IPresenter {
        void getPdmx(String url, AudirecordMxParam param);
    }
}
