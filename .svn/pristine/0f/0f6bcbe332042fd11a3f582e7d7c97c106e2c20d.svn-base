package gjp.com.wzmanager.model;

import org.json.JSONException;
import org.json.JSONObject;

import gjp.com.wzmanager.MyApplication;
import gjp.com.wzmanager.bean.TsUser;
import gjp.com.wzmanager.contract.LoginContract;
import gjp.com.wzmanager.util.GsonUtil;
import gjp.com.wzmanager.util.OkHttpUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

/**
 * Created by Administrator on 2017/5/12.
 */

public class LoginModel implements LoginContract.Model {
    @Override
    public void login(String usercode, String password, String url, final AsyncCallback callback) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("usercode", usercode);
            obj.put("usernamec", usercode);
            obj.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OkHttpUtils.postHttp(obj, url, callback, new AsyncCallback2() {
            @Override
            public void onSuccess(Object s) {
                try {
                    String res=s.toString();
                    JSONObject jsonObject = new JSONObject(res);
                    boolean success = jsonObject.getBoolean("Success");
                    if (success) {
                        JSONObject data = jsonObject.getJSONObject("Data");
                        TsUser tsUser = GsonUtil.parseJsonWithGson(data.toString(), TsUser.class);
                        SharedPreferencesUtil.saveStringData(MyApplication.getContext(),"usercode",tsUser.getUsercode());
                        SharedPreferencesUtil.saveStringData(MyApplication.getContext(),"username",tsUser.getUsernamec());
                        SharedPreferencesUtil.saveStringData(MyApplication.getContext(),"bm_name",tsUser.getBm_name());
                        callback.onSuccess(tsUser);
                    } else {
                        String msg = jsonObject.getString("Message");
                        callback.onError(msg);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
