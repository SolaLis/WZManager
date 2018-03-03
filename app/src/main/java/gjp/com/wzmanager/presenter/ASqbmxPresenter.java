package gjp.com.wzmanager.presenter;

import gjp.com.wzmanager.bean.AudirecordMxBean;
import gjp.com.wzmanager.contract.ASqbmxContract;
import gjp.com.wzmanager.model.ASqbmxModel;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.param.AudirecordMxParam;

/**
 * Created by Administrator on 2017/7/26.
 */

public class ASqbmxPresenter implements ASqbmxContract.Presenter {
    private ASqbmxContract.View view;
    private ASqbmxContract.Model model;

    public ASqbmxPresenter(ASqbmxContract.View view) {
        this.view = view;
        model=new ASqbmxModel();
    }

    @Override
    public void getSqbmx(String url, AudirecordMxParam param) {
        model.getSqbmx(url, param, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getSqbmxSuccess((AudirecordMxBean) success);
            }

            @Override
            public void onError(Object error) {
                view.getSqbmxFailed(error.toString());
            }
        });

    }
}
