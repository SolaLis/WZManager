package gjp.com.wzmanager.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import gjp.com.wzmanager.bean.BmBean;
import gjp.com.wzmanager.contract.BmContract;
import gjp.com.wzmanager.util.GsonUtil;
import gjp.com.wzmanager.util.OkHttpUtils;

/**
 * Created by Administrator on 2017/7/22.
 */

public class BmModel implements BmContract.Model {

    @Override
    public void getBm(String url, String usercode, final AsyncCallback callback) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("usercode", usercode);
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
                        JSONArray data = jsonObject.getJSONArray("Data");
                        List<BmBean> lists = GsonUtil.getObjectList(data.toString(),BmBean.class);

                        callback.onSuccess(lists);
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
