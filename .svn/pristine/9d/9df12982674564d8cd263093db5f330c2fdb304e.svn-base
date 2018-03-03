package gjp.com.wzmanager.model;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import gjp.com.wzmanager.bean.PdTimeMxBean;
import gjp.com.wzmanager.contract.PdTimeContract;
import gjp.com.wzmanager.param.AudirecordMxParam;
import gjp.com.wzmanager.util.OkHttpUtils;

/**
 * Created by Administrator on 2017/8/7.
 */

public class PdTimeModel implements PdTimeContract.Model {
    @Override
    public void getPdTimeMx(String url, AudirecordMxParam param, final AsyncCallback callback) {
        JSONObject obj = new JSONObject();
        try {
            //obj.put("tablename", "tc_ck_zc");
            // obj.put("keycol", "pzh");
            obj.put("keyvalue", param.getKeyvalue());
            obj.put("module", param.getModule());
            obj.put("usercode", param.getUsercode());
            obj.put("classname", "w_kc_sj_pd");
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
                        Gson gson = new Gson();
                        PdTimeMxBean pdTimeMxBean = gson.fromJson(data.toString(), PdTimeMxBean.class);
                        callback.onSuccess(pdTimeMxBean);
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
