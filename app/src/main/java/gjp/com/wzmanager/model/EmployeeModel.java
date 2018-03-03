package gjp.com.wzmanager.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import gjp.com.wzmanager.bean.EmployeeBean;
import gjp.com.wzmanager.contract.EmployeeContract;
import gjp.com.wzmanager.util.GsonUtil;
import gjp.com.wzmanager.util.OkHttpUtils;

/**
 * Created by Administrator on 2017/7/25.
 */

public class EmployeeModel implements EmployeeContract.Model {
    @Override
    public void getEmployee(String url, String usercode, String bm_id,int currentPage,int pageSize, final AsyncCallback callback) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("usercode", usercode);
            obj.put("bm_id", bm_id);
            obj.put("currentPage", currentPage);
            obj.put("pageSize", pageSize);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OkHttpUtils.postHttp(obj, url, callback, new AsyncCallback2() {
            @Override
            public void onSuccess(Object s) {
                try {
                    String res=s.toString();
                    Log.e("LOG","onSuccess(EmployeeModel.java:35)==="+res);
                    JSONObject jsonObject = new JSONObject(res);
                    boolean success = jsonObject.getBoolean("Success");
                    if (success) {
                        JSONArray data = jsonObject.getJSONArray("Data");
                        List<EmployeeBean> lists = GsonUtil.getObjectList(data.toString(),EmployeeBean.class);
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
