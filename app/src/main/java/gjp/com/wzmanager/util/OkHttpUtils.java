package gjp.com.wzmanager.util;

import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import gjp.com.wzmanager.model.IModel;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/7/19.
 */

public class OkHttpUtils {
    public static void postHttp(JSONObject jsonObject, String url, final IModel.AsyncCallback callback, final IModel.AsyncCallback2 asyncCallback){
       // OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        Log.e("LOG","postHttp(OkHttpUtils.java:25)==="+jsonObject.toString());
        Log.e("LOG","postHttp(OkHttpUtils.java:28)==="+url);
        final Request request;
        try {
            request = new Request.Builder().url(url).post(body).build();
            Call call = okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    callback.onError(AllUrl.NETWORK_ERROR);
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    int code = response.code();
                    Log.e("LOG","onResponse(OkHttpUtils.java:48)==="+code);
                    if (code==200){
                        String res=response.body().string();
                        Log.e("LOG","onResponse(OkHttpUtils.java:43)==="+res);
                        asyncCallback.onSuccess(res);
                    }else if (code==404){
                        callback.onError(AllUrl.CODE_404);
                    }
                    else if (code==500){
                        callback.onError(AllUrl.CODE_500);
                    }
                    else if (code==501){
                        callback.onError(AllUrl.CODE_501);
                    }
                    else if (code==503){
                        callback.onError(AllUrl.CODE_503);
                    }else {
                        callback.onError("服务端其他错误");
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            callback.onError(AllUrl.PORT_TOO_LOONG);
        }


    }
    public static void postHttp(String jsonObject, String url, final IModel.AsyncCallback callback, final IModel.AsyncCallback2 asyncCallback){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonObject);
        Log.e("LOG","postHttp(OkHttpUtils.java:25)==="+jsonObject.toString());
        Log.e("LOG","postHttp(OkHttpUtils.java:28)==="+url);
        try {
        final Request request = new Request.Builder().url(url).post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String error = "网络请求失败，请检查服务器设置";
                callback.onError(error);
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                int code = response.code();
                if (code==200){
                    String res=response.body().string();
                    Log.e("LOG","onResponse(OkHttpUtils.java:43)==="+res);
                    asyncCallback.onSuccess(res);
                }else if (code==404){
                    callback.onError(AllUrl.CODE_404);
                }
                else if (code==500){
                    callback.onError(AllUrl.CODE_500);
                }
                else if (code==501){
                    callback.onError(AllUrl.CODE_501);
                }
                else if (code==503){
                    callback.onError(AllUrl.CODE_503);
                }else {
                    callback.onError("服务端其他错误");
                }
            }
        });
        } catch (Exception e) {
            e.printStackTrace();
            callback.onError(AllUrl.PORT_TOO_LOONG);
        }
    }

}
