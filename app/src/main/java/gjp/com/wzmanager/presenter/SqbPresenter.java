package gjp.com.wzmanager.presenter;

import java.util.List;

import gjp.com.wzmanager.bean.SqbBean;
import gjp.com.wzmanager.contract.SqbContract;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.model.SqbModel;

/**
 * Created by Administrator on 2017/7/25.
 */

public class SqbPresenter implements SqbContract.Presenter {
    private SqbContract.View view;
    private SqbContract.Model model;

    public SqbPresenter(SqbContract.View view) {
        this.view = view;
        model=new SqbModel();
    }
    @Override
    public void getSqb(String url, String sqmsbm, String sqbm_id, String sqr, String usercode, String startDate, String endDate, int currentPage, int pageSize) {
        model.getSqb(url, sqmsbm, sqbm_id, sqr, usercode, startDate, endDate, currentPage, pageSize, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getSqbSuccess((List<SqbBean>) success);
            }

            @Override
            public void onError(Object error) {
                view.getSqbFailed(error.toString());
            }
        });
    }

    @Override
    public void getSearchSqb(String url, String search,String usercode, int currentPage, int pageSize) {
        model.getSearchSqb(url, search, usercode,currentPage, pageSize, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.getSearchSqbSuccess((List<SqbBean>) success);
            }

            @Override
            public void onError(Object error) {
                view.getSqbFailed(error.toString());
            }
        });
    }
}
