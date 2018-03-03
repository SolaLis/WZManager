package gjp.com.wzmanager.presenter;

import java.util.List;

import gjp.com.wzmanager.bean.BmBean;
import gjp.com.wzmanager.contract.BmContract;
import gjp.com.wzmanager.model.BmModel;
import gjp.com.wzmanager.model.IModel;

/**
 * Created by Administrator on 2017/7/22.
 */

public class BmPresenter implements BmContract.Presenter {
    private BmContract.View view;
    private BmContract.Model model;

    public BmPresenter(BmContract.View view) {
        this.view = view;
        model=new BmModel();
    }

    @Override
    public void getBm(String url, String usercode) {
        model.getBm(url, usercode, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getBmSuccess((List<BmBean>) success);
            }

            @Override
            public void onError(Object error) {
                view.getBmFailed(error.toString());
            }
        });

    }
}
