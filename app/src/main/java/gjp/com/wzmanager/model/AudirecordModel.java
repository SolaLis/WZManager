package gjp.com.wzmanager.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import gjp.com.wzmanager.bean.AudirecordBean;
import gjp.com.wzmanager.contract.AudirecordContract;
import gjp.com.wzmanager.param.AudirecordParam;
import gjp.com.wzmanager.util.GsonUtil;
import gjp.com.wzmanager.util.OkHttpUtils;

/**
 * Created by Administrator on 2017/7/31.
 */

public class AudirecordModel implements AudirecordContract.Model {
    @Override
    public void getAudirecord(String url, AudirecordParam param, final AsyncCallback callback) {
        JSONObject obj=new JSONObject();
        try {
            obj.put("usercode",param.getUsercode());
            obj.put("module",param.getModule());
            obj.put("auditingflag",param.getAuditingflag());
            obj.put("currentPage",param.getCurrentPage());
            obj.put("pageSize",param.getPageSize());
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
                        List<AudirecordBean> lists = GsonUtil.getObjectList(data.toString(),AudirecordBean.class);
                        Log.e("LOG","onSuccess(BmModel.java:37)==="+lists.size());
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
