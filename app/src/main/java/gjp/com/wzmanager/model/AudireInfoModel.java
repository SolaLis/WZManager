package gjp.com.wzmanager.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import gjp.com.wzmanager.bean.AudireInfoBean;
import gjp.com.wzmanager.param.ExcuteAuditBean;
import gjp.com.wzmanager.param.IsLastBean;
import gjp.com.wzmanager.contract.AudireInfoContract;
import gjp.com.wzmanager.util.GsonUtil;
import gjp.com.wzmanager.util.OkHttpUtils;

/**
 * Created by Administrator on 2017/7/28.
 */

public class AudireInfoModel implements AudireInfoContract.Model {
    @Override
    public void getAudireInfo(String url, String sqdh, final AsyncCallback callback) {
        JSONObject obj=new JSONObject();
        try {
            obj.put("keyvalue",sqdh);
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
                        List<AudireInfoBean> lists = GsonUtil.getObjectList(data.toString(),AudireInfoBean.class);
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

    @Override
    public void audire(String url, ExcuteAuditBean excuteAuditBean, final AsyncCallback callback) {
        JSONObject obj=new JSONObject();
        try {
            obj.put("ls_keyvalue",excuteAuditBean.getLs_keyvalue());
            obj.put("ls_audiuser",excuteAuditBean.getLs_audiuser());
            obj.put("ls_audiuser_name",excuteAuditBean.getLs_audiuser_name());
            obj.put("ls_auditingflag",excuteAuditBean.getLs_auditingflag());
            obj.put("ls_auditingidea",excuteAuditBean.getLs_auditingidea());
            obj.put("ls_audiuser_next",excuteAuditBean.getLs_audiuser_next());
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
                        int data=jsonObject.getInt("Data");
                        callback.onSuccess(data);
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
    public void nextAudit(String url, IsLastBean isLastBean, final AsyncCallback callback) {
        JSONObject obj=new JSONObject();
        try {
            obj.put("level",isLastBean.getLevel());
            obj.put("keyValue",isLastBean.getKeyValue());
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
                        List<AudireInfoBean> lists = GsonUtil.getObjectList(data.toString(),AudireInfoBean.class);
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
    public void isLast(String url, IsLastBean isLastBean,final AsyncCallback callback) {
        JSONObject obj=new JSONObject();
        try {
            obj.put("keyValue",isLastBean.getKeyValue());
            obj.put("auditype",isLastBean.getAuditype());
            obj.put("level",isLastBean.getLevel());
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
                        String auditype=jsonObject.getString("Data");
                        callback.onSuccess(auditype);
                    } else {
                        String msg = jsonObject.getString("Message");
                        callback.onError(msg);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    callback.onSuccess("0");
                }
            }
        });
    }
}
