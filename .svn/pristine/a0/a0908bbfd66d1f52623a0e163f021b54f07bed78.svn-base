package gjp.com.wzmanager.presenter;

import gjp.com.wzmanager.bean.PdMxBean;
import gjp.com.wzmanager.contract.PdContract;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.model.PdModel;
import gjp.com.wzmanager.param.AudirecordMxParam;

/**
 * Created by Administrator on 2017/8/5.
 */

public class PdPresenter implements PdContract.Presenter {
    private PdContract.View view;
    private PdContract.Model model;

    public PdPresenter(PdContract.View view) {
        this.view = view;
        model=new PdModel();
    }

    @Override
    public void getPdmx(String url, AudirecordMxParam param) {
        model.getPdmx(url, param, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getPdmxSuccess((PdMxBean) success);
            }
            @Override
            public void onError(Object error) {
                view.getPdmxFailed((String) error);
            }
        });

    }
}
