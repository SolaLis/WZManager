package gjp.com.wzmanager.presenter;

import java.util.List;

import gjp.com.wzmanager.bean.EmployeeBean;
import gjp.com.wzmanager.contract.EmployeeContract;
import gjp.com.wzmanager.model.EmployeeModel;
import gjp.com.wzmanager.model.IModel;

/**
 * Created by Administrator on 2017/7/25.
 */

public class EmployeePresenter implements EmployeeContract.Presenter {
    private EmployeeContract.View view;
    private EmployeeContract.Model model;

    public EmployeePresenter(EmployeeContract.View view) {
        this.view = view;
        model=new EmployeeModel();
    }

    @Override
    public void getEmployee(String url, String usercode, String bm_id,int currentPage,int pageSize) {
            model.getEmployee(url, usercode, bm_id,currentPage,pageSize ,new IModel.AsyncCallback() {
                @Override
                public void onSuccess(Object success) {
                    view.getEmployeeSuccess((List<EmployeeBean>) success);
                }

                @Override
                public void onError(Object error) {
                    view.getEmployeeFailed(error.toString());
                }
            });
    }
}
