package gjp.com.wzmanager.presenter;

import java.util.List;

import gjp.com.wzmanager.bean.SqbmxBean;
import gjp.com.wzmanager.contract.SqbmxContract;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.model.SqbmxModel;

/**
 * Created by Administrator on 2017/7/26.
 */

public class SqbmxPresenter implements SqbmxContract.Presenter {
    private SqbmxContract.View view;
    private SqbmxContract.Model model;

    public SqbmxPresenter(SqbmxContract.View view) {
        this.view = view;
        model=new SqbmxModel();
    }

    @Override
    public void getSqbmx(String url, String sqdh) {
        model.getSqbmx(url, sqdh, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getSqbmxSuccess((List<SqbmxBean>) success);
            }

            @Override
            public void onError(Object error) {
                view.getSqbmxFailed(error.toString());
            }
        });

    }
}
