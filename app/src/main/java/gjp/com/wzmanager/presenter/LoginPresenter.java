package gjp.com.wzmanager.presenter;

import gjp.com.wzmanager.contract.LoginContract;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.model.LoginModel;

/**
 * Created by Administrator on 2017/5/12.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;
    private LoginContract.Model model;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.model=new LoginModel();
    }

    @Override
    public void login(String loginname, String password, String url) {
        model.login(loginname, password, url, new IModel.AsyncCallback() {
            @Override
            public void onSuccess(Object success) {
                view.loginSuccess();
            }

            @Override
            public void onError(Object error) {
                view.loginFailed(error.toString());
            }
        });
    }
}
