package gjp.com.wzmanager.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gjp.com.wzmanager.bean.ClientBean;
import gjp.com.wzmanager.contract.WldwContract;
import gjp.com.wzmanager.util.BaseUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/7/13.
 */

public class WldwModel implements WldwContract.Model {
    @Override
    public void getGhdw(String strCondition, final int currPage, final AsyncCallback callback) {
       String url = "http://192.168.18.44:8888//ManagersDataService.asmx/ManagersGoodsPost";
       // String url = "http://122.224.132.6:44001//ManagersDataService.asmx/ManagersGoodsPost";
        strCondition= "client.sys_del =  0  AND exists(select * from employee" +
                " a where ((em_code in(select operation from sys_operationright where kind" +
                " = 5 and viewflag = 1 and yh_no = '" +
                "000000" +
                "')  OR a.em_code='" +
             "000000" +
                "') and (charindex(a.em_code,client.handler_id) > 0 ) " +
                "or len(isnull(client.handler_id,''))=0)) ";
        JSONObject obj = new JSONObject();
        try {
            obj.put("currPage", currPage);
            obj.put("showColumn","*");
            obj.put("tabName", "client");
            obj.put("strCondition",strCondition);
            obj.put("ascColumn", "client_id");
            obj.put("bitOrderType", "0");
            obj.put("pkColumn", "client_id");
            obj.put("pageSize", 10);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OkHttpClient okHttpClient=new OkHttpClient();
        MediaType JSON = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(JSON, obj.toString());
        Log.e("LOG","getGhdw(GhdwModel.java:39)==="+obj.toString());
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError("网络无连接");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                Log.e("LOG","onResponse(GhdwModel.java:63)==="+ BaseUtil.processData(res));
                try {
                    JSONObject jsonObject=new JSONObject(BaseUtil.processData(res));
                    boolean success =jsonObject.getBoolean("Success");
                    if (success){
                        JSONObject object=jsonObject.getJSONObject("Data");
                        JSONArray array=object.getJSONArray("Data");
                        List<ClientBean> lists=new ArrayList<ClientBean>();
                        for (int i=0;i<array.length();i++){
                            JSONObject obj=array.getJSONObject(i);
                            String client_id=obj.getString("client_id");
                            String sys_date=obj.getString("sys_date");
                            String client_name=obj.getString("client_name");
                            String client_area=obj.getString("client_area");
                            String client_pym=obj.getString("client_pym");
                            String client_short=obj.getString("client_short");
                            String client_lxr=obj.getString("client_lxr");
                            String client_tel=obj.getString("client_tel");
                            String client_address=obj.getString("client_address");
                            String client_mail=obj.getString("client_mail");
                            String client_zip=obj.getString("client_zip");
                            String client_fax=obj.getString("client_fax");
                            String client_bank=obj.getString("client_bank");
                            String client_account=obj.getString("client_account");
                            String client_tax=obj.getString("client_tax");
                            String client_price=obj.getString("client_price");
                            String comment=obj.getString("comment");
                            String sys_del=obj.getString("sys_del");
                            String sys_default=obj.getString("sys_default");
                            String gys_flag=obj.getString("gys_flag");
                            String kehu_flag=obj.getString("kehu_flag");
                            String ps_money=obj.getString("ps_money");
                            String ys_money=obj.getString("ys_money");
                            String pf_money=obj.getString("pf_money");
                            String yf_money=obj.getString("yf_money");
                            String ys_limit=obj.getString("ys_limit");
                            String yf_limit=obj.getString("yf_limit");
                            String js_limit=obj.getString("js_limit");
                            String begin_ps=obj.getString("begin_ps");
                            String begin_ys=obj.getString("begin_ys");
                            String begin_pf=obj.getString("begin_pf");
                            String begin_yf=obj.getString("begin_yf");
                            String handler_id=obj.getString("handler_id");
                            String handler_name=obj.getString("handler_name");
                            String client_kind=obj.getString("client_kind");
                            String supplier_kind=obj.getString("supplier_kind");
                            ClientBean list=new ClientBean();
                            list.setClient_id(client_id);
                            list.setSys_date(sys_date);
                            list.setClient_name(client_name);
                            list.setClient_area(client_area);
                            list.setClient_pym(client_pym);
                            list.setClient_short(client_short);
                            list.setClient_lxr(client_lxr);
                            list.setClient_tel(client_tel);
                            list.setClient_address(client_address);
                            list.setClient_mail(client_mail);
                            list.setClient_zip(client_zip);
                            list.setClient_fax(client_fax);
                            list.setClient_bank(client_bank);
                            list.setClient_account(client_account);
                            list.setClient_tax(client_tax);
                            list.setClient_price(client_price);
                            list.setComment(comment);
                            list.setSys_del(sys_del);
                            list.setSys_default(sys_default);
                            list.setGys_flag(gys_flag);
                            list.setKehu_flag(kehu_flag);
                            list.setPs_money(ps_money);
                            list.setYs_money(ys_money);
                            list.setYf_money(yf_money);
                            list.setPf_money(pf_money);
                            list.setYs_limit(ys_limit);
                            list.setYf_limit(yf_limit);
                            list.setJs_limit(js_limit);
                            list.setBegin_ps(begin_ps);
                            list.setBegin_ys(begin_ys);
                            list.setBegin_pf(begin_pf);
                            list.setBegin_yf(begin_yf);
                            list.setBegin_pf(begin_pf);
                            list.setHandler_id(handler_id);
                            list.setHandler_name(handler_name);
                            list.setClient_kind(client_kind);
                            list.setSupplier_kind(supplier_kind);
                            lists.add(list);
                        }
                        callback.onSuccess(lists);
                    }else {
                        String error=jsonObject.getString("Error");
                        callback.onError(error);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (currPage==1){
                        callback.onError("搜索无结果");
                    }else {
                        callback.onError("已经到底了");}
                }
            }
        });
    }
}
