package gjp.com.wzmanager.presenter;

import gjp.com.wzmanager.bean.AudirecordMxZcBean;
import gjp.com.wzmanager.contract.AZcmxContract;
import gjp.com.wzmanager.model.AZcmxModel;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.param.AudirecordMxParam;

/**
 * Created by Administrator on 2017/8/2.
 */

public class AZcmxPresenter implements AZcmxContract.Presenter {
    private  AZcmxContract.View view;
    private AZcmxContract.Model model;

    public AZcmxPresenter(AZcmxContract.View view) {
        this.view = view;
        model=new AZcmxModel();
    }

    @Override
    public void getZcmx(String url, AudirecordMxParam param) {
        model.getZcmx(url, param, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getZcmxSuccess((AudirecordMxZcBean) success);
            }

            @Override
            public void onError(Object error) {
                view.getZcmxFailed(error.toString());
            }
        });
    }
}
