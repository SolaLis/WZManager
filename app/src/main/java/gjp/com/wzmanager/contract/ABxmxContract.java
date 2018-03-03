package gjp.com.wzmanager.contract;

import gjp.com.wzmanager.bean.BxMxBean;
import gjp.com.wzmanager.model.IModel;
import gjp.com.wzmanager.param.AudirecordMxParam;
import gjp.com.wzmanager.presenter.IPresenter;
import gjp.com.wzmanager.view.IView;

/**
 * 报销单据明细接口
 * Created by Administrator on 2017/8/2.
 */

public interface ABxmxContract {
    interface Model extends IModel {
        /**
         * 获取报销明细
         * @param url
         * @param param
         * @param callback
         */
        void getBxmx(String url, AudirecordMxParam param, AsyncCallback callback);
    }

    interface View extends IView {
        /**
         * 获取报销明细成功
         * @param list
         */
        void getBxmxSuccess(BxMxBean list);

        /**
         * 获取报销明细失败
         * @param errorMessage
         */
        void getBxmxFailed(String errorMessage);
    }

    interface Presenter extends IPresenter {
        /**
         * 获取报销明细
         * @param url
         * @param param
         */
        void getBxmx(String url, AudirecordMxParam param);
    }
}
