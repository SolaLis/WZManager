package gjp.com.wzmanager.contract;

import java.util.List;

import gjp.com.wzmanager.bean.EmployeeBean;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * Created by Administrator on 2017/7/25.
 */

public interface EmployeeContract {
    interface Model extends IModel {
        void getEmployee(String url,String usercode,String bm_id,int currentPage,int pageSize,AsyncCallback callback);
    }

    interface View extends IView {

        void getEmployeeSuccess(List<EmployeeBean> list);

        void getEmployeeFailed(String errorMessage);
    }

    interface Presenter extends IPresenter {
        void getEmployee(String url,String usercode,String bm_id,int currentPage,int pageSize);
    }
}
