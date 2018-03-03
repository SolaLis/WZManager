package gjp.com.wzmanager.presenter;

import gjp.com.wzmanager.bean.BxMxBean;
import gjp.com.wzmanager.contract.ABxmxContract;
import gjp.com.wzmanager.model.ABxmxModel;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.param.AudirecordMxParam;

/**
 * Created by Administrator on 2017/8/2.
 */

public class ABxmxPresenter implements ABxmxContract.Presenter {
    private ABxmxContract.View view;
    private ABxmxContract.Model model;

    public ABxmxPresenter(ABxmxContract.View view) {
        this.view = view;
        model=new ABxmxModel();
    }

    @Override
    public void getBxmx(String url, AudirecordMxParam param) {
        model.getBxmx(url, param, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getBxmxSuccess((BxMxBean) success);
            }

            @Override
            public void onError(Object error) {
                view.getBxmxFailed(error.toString());
            }
        });

    }
}
