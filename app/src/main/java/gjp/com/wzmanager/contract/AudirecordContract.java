package gjp.com.wzmanager.contract;

import java.util.List;

import gjp.com.wzmanager.bean.AudirecordBean;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.param.AudirecordParam;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface AudirecordContract {
    interface Model extends IModel {
        void getAudirecord(String url,AudirecordParam param, AsyncCallback callback);
    }

    interface View extends IView {

        void getAudirecordSuccess(List<AudirecordBean> list);

        void getAudirecordFailed(String errorMessage);
    }

    interface Presenter extends IPresenter {
        void getAudirecord(String url,AudirecordParam param);
    }
}
