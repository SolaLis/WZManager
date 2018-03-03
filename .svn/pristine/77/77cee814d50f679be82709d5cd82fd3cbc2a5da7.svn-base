package gjp.com.wzmanager.contract;

import gjp.com.wzmanager.bean.PdTimeMxBean;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.param.AudirecordMxParam;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * Created by Administrator on 2017/8/7.
 */

public interface PdTimeContract {
    interface Model extends IModel {
        void getPdTimeMx(String url, AudirecordMxParam param, AsyncCallback callback);
    }

    interface View extends IView {

        void getPdTimeMxSuccess(PdTimeMxBean list);

        void getPdTimeMxFailed(String errorMessage);
    }

    interface Presenter extends IPresenter {
        void getPdTimeMx(String url, AudirecordMxParam param);
    }
}
