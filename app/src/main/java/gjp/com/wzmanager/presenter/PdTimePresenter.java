package gjp.com.wzmanager.presenter;

import gjp.com.wzmanager.bean.PdTimeMxBean;
import gjp.com.wzmanager.contract.PdTimeContract;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.model.PdTimeModel;
import gjp.com.wzmanager.param.AudirecordMxParam;

/**
 * Created by Administrator on 2017/8/7.
 */

public class PdTimePresenter implements PdTimeContract.Presenter {
    private PdTimeContract.View view;
    private PdTimeContract.Model model;

    public PdTimePresenter(PdTimeContract.View view) {
        this.view = view;
        model=new PdTimeModel();
    }

    @Override
    public void getPdTimeMx(String url, AudirecordMxParam param) {
        model.getPdTimeMx(url, param, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getPdTimeMxSuccess((PdTimeMxBean) success);
            }

            @Override
            public void onError(Object error) {
                view.getPdTimeMxFailed(error.toString());
            }
        });

    }
}
