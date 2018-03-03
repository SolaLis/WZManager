package gjp.com.wzmanager.presenter;

import java.util.List;

import gjp.com.wzmanager.bean.AudireInfoBean;
import gjp.com.wzmanager.contract.AudireInfoContract;
import gjp.com.wzmanager.model.AudireInfoModel;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.param.ExcuteAuditBean;
import gjp.com.wzmanager.param.IsLastBean;

/**
 * Created by Administrator on 2017/7/28.
 */

public class AudireInfoPresenter implements AudireInfoContract.Presenter {
    private AudireInfoContract.View view;
    private AudireInfoContract.Model model;

    public AudireInfoPresenter(AudireInfoContract.View view) {
        this.view = view;
        model=new AudireInfoModel();
    }

    @Override
    public void getAudireInfo(String url, String sqdh) {
        model.getAudireInfo(url, sqdh, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getAudireInfoSuccess((List<AudireInfoBean>) success);
            }
            @Override
            public void onError(Object error) {
                view.getAudireInfoFailed(error.toString());
            }
        });
    }

    @Override
    public void audire(String url, ExcuteAuditBean excuteAuditBean) {
        model.audire(url, excuteAuditBean, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getAudireSuccess((Integer) success);
            }
            @Override
            public void onError(Object error) {
                view.getAudireFailed(error.toString());
            }
        });
    }

    @Override
    public void nextAudit(String url, IsLastBean isLastBean) {
        model.nextAudit(url,isLastBean, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getNextAuditSuccess((List<AudireInfoBean>) success);
            }

            @Override
            public void onError(Object error) {
            view.getAudireFailed(error.toString());
            }
        });
    }

    @Override
    public void isLast(String url, IsLastBean isLastBean) {
        model.isLast(url, isLastBean, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getIsLastSuccess(success.toString());
            }

            @Override
            public void onError(Object error) {
                view.getIsLastFailed(error.toString());
            }
        });
    }
}
