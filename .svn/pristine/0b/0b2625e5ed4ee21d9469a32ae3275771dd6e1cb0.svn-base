package gjp.com.wzmanager.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import gjp.com.wzmanager.bean.SqbBean;
import gjp.com.wzmanager.contract.SqbContract;
import gjp.com.wzmanager.util.GsonUtil;
import gjp.com.wzmanager.util.OkHttpUtils;

/**
 * Created by Administrator on 2017/7/25.
 */

public class SqbModel implements SqbContract.Model {
    @Override
    public void getSqb(String url, String sqmsbm, String sqbm_id, String sqr, String usercode, String startDate, String endDate, int currentPage, int pageSize, final AsyncCallback callback) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("SQMSBM", sqmsbm);
            obj.put("SQBM_ID", sqbm_id);
            obj.put("SQR", sqr);
            obj.put("usercode", usercode);
            obj.put("startDate", startDate);
            obj.put("endDate", endDate);
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
                        List<SqbBean> lists = GsonUtil.getObjectList(data.toString(),SqbBean.class);
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

    @Override
    public void getSearchSqb(String url, String search,String usercode, int currentPage, int pageSize , final AsyncCallback callback) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("search", search);
            obj.put("usercode", usercode);
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
                        List<SqbBean> lists = GsonUtil.getObjectList(data.toString(),SqbBean.class);
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
