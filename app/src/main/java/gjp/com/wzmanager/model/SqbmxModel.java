package gjp.com.wzmanager.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import gjp.com.wzmanager.bean.SqbmxBean;
import gjp.com.wzmanager.contract.SqbmxContract;
import gjp.com.wzmanager.util.GsonUtil;
import gjp.com.wzmanager.util.OkHttpUtils;

/**
 * Created by Administrator on 2017/7/26.
 */

public class SqbmxModel implements SqbmxContract.Model {
    @Override
    public void getSqbmx(String url, String sqdh, final AsyncCallback callback) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("SQDH", sqdh);

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
                        List<SqbmxBean> lists = GsonUtil.getObjectList(data.toString(),SqbmxBean.class);
                        Log.e("LOG","onSuccess(EmployeeModel.java:41)==="+lists.size());
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
