package gjp.com.wzmanager.presenter;

import java.util.List;

import gjp.com.wzmanager.bean.AudirecordBean;
import gjp.com.wzmanager.contract.AudirecordContract;
import gjp.com.wzmanager.model.AudirecordModel;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.param.AudirecordParam;

/**
 * Created by Administrator on 2017/7/31.
 */

public class AudirecordPresenter implements AudirecordContract.Presenter {
    private AudirecordContract.View view;
    private AudirecordContract.Model model;

    public AudirecordPresenter(AudirecordContract.View view) {
        this.view = view;
        model=new AudirecordModel();
    }

    @Override
    public void getAudirecord(String url, AudirecordParam param) {
        model.getAudirecord(url, param, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getAudirecordSuccess((List<AudirecordBean>) success);
            }

            @Override
            public void onError(Object error) {
                view.getAudirecordFailed(error.toString());
            }
        });
    }
}
