package gjp.com.wzmanager.contract;

import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * Created by Administrator on 2017/5/12.
 */

public interface LoginContract {
    interface Model extends IModel{
         void login(String loginame, String password,String url, AsyncCallback callback);
    }

    interface View extends IView{
        /**
         * 登录成功提示
         */
         void loginSuccess();
        /**
         * 登录失败提示  并且附带失败原因
         * @param errorMessage
         */
         void loginFailed(String errorMessage);
    }

    interface Presenter extends IPresenter{
        /**
         *登录
         */
         void login(String loginname, String password,String url);
    }
}
