package gjp.com.wzmanager.contract;

import java.util.List;

import gjp.com.wzmanager.bean.AudireInfoBean;
import gjp.com.wzmanager.param.ExcuteAuditBean;
import gjp.com.wzmanager.param.IsLastBean;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface AudireInfoContract {
    interface Model extends IModel {
        void getAudireInfo(String url, String sqdh, AsyncCallback callback);
        void audire(String url, ExcuteAuditBean excuteAuditBean, AsyncCallback callback);
        void nextAudit(String url,IsLastBean isLastBean, AsyncCallback callback);
        void isLast(String url, IsLastBean isLastBean, AsyncCallback callback);
    }

    interface View extends IView {
        void getAudireInfoSuccess(List<AudireInfoBean> list);
        void getAudireInfoFailed(String errorMessage);

        void getAudireSuccess(int i);
        void getAudireFailed(String errorMessage);

        void getNextAuditSuccess(List<AudireInfoBean> list);
        void getNextAuditFailed(String errorMessage);

        void getIsLastSuccess(String auditype);
        void getIsLastFailed(String errorMessage);
    }


    interface Presenter extends IPresenter {
        void getAudireInfo(String url, String sqdh);
        void audire(String url, ExcuteAuditBean excuteAuditBean);
        void nextAudit(String url, IsLastBean isLastBean);
        void isLast(String url, IsLastBean isLastBean);
    }
}
