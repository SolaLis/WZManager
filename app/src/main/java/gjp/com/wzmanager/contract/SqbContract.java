package gjp.com.wzmanager.contract;

import java.util.List;

import gjp.com.wzmanager.bean.SqbBean;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * Created by Administrator on 2017/7/25.
 */

public interface SqbContract {
    interface Model extends IModel {
        void getSqb(String url,String sqmsbm,String sqbm_id,String sqr,String usercode,
                    String startDate,String endDate,int currentPage,int pageSize,AsyncCallback callback);
        void getSearchSqb(String url,String search,String usercode,int currentPage,int pageSize,AsyncCallback callback);
    }

    interface View extends IView {

        void getSqbSuccess(List<SqbBean> list);

        void getSqbFailed(String errorMessage);

        void getSearchSqbSuccess(List<SqbBean> list);

        void geSearchSqbFailed(String errorMessage);
    }

    interface Presenter extends IPresenter {
        void getSqb(String url,String sqmsbm,String sqbm_id,String sqr,String usercode,
                    String startDate,String endDate,int currentPage,int pageSize);
        void getSearchSqb(String url,String search,String usercode,int currentPage,int pageSize);
    }
}
