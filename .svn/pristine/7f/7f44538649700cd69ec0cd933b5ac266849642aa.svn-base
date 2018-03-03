package gjp.com.wzmanager.activity;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import gjp.com.wzmanager.R;
import gjp.com.wzmanager.util.AllUrl;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.ProgressDialogUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class YsgjActivity extends Fragment implements View.OnClickListener {
    //用户名 密码 端口号
    private EditText etYsgjUser,etYsgjPwd,etYsgjPort;
    //登录 返回
    private TextView btnYsgjLogin,btnYsgjBack;
    //用户名 密码 端口号
    private String username,pwd,port;
    private String ip,error,url;
    private View v;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){  //0 onFailed  1 succes 2 fasle 3 catch
                case 0:
                    ProgressDialogUtils.dismissProgressDialog();
                    Toast.makeText(getActivity(), "网络请求失败，请检查网络", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    ProgressDialogUtils.dismissProgressDialog();
                    SharedPreferencesUtil.saveStringData(getActivity(),"IP",ip);
                    SharedPreferencesUtil.saveStringData(getActivity(),"port",port);
                    SharedPreferencesUtil.saveStringData(getActivity(),"usernameY",username);
                    SharedPreferencesUtil.saveStringData(getActivity(),"pwdY",pwd);
                    url="http://"+ip+":"+port;
                    SharedPreferencesUtil.saveStringData(getActivity(),
                            "setUrl", url);
                    getActivity().finish();
                    break;
                case 2:
                    ProgressDialogUtils.dismissProgressDialog();
                    if (!"null".equals(error)){
                    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();}
                    break;
                case 3:
                    ProgressDialogUtils.dismissProgressDialog();
                    Toast.makeText(getActivity(), "返回数据问题", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.activity_ysgj, null);
        init();
        return v;
    }
    /**
     * 初始化控件
     */
    private void init() {
        etYsgjUser= (EditText) v.findViewById(R.id.et_ysgj_user);
        etYsgjPwd= (EditText)v. findViewById(R.id.et_ysgj_password);
        etYsgjPort= (EditText) v.findViewById(R.id.et_ysgj_port);
        String userS=  SharedPreferencesUtil.getStringData(getActivity(),"usernameY",null);
        String pwdS=  SharedPreferencesUtil.getStringData(getActivity(),"pwdY",null);
        String portS=  SharedPreferencesUtil.getStringData(getActivity(),"port",null);
        if (userS!=null){
            etYsgjUser.setText(userS);
        }if (pwdS!=null){
            etYsgjPwd.setText(pwdS);
        }
        if (portS!=null){
            etYsgjPort.setText(portS);
        }
        btnYsgjLogin= (TextView) v.findViewById(R.id.tv_ysgj_login);
        btnYsgjBack= (TextView)v. findViewById(R.id.tv_ysgj_back);
        btnYsgjLogin.setOnClickListener(this);
        btnYsgjBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_ysgj_login:
                username=etYsgjUser.getText().toString().trim();
                pwd=etYsgjPwd.getText().toString().trim();
                port=etYsgjPort.getText().toString().trim();
                if (TextUtils.isEmpty(username)||TextUtils.isEmpty(pwd)||TextUtils.isEmpty(port)){
                    Toast.makeText(getActivity(), "请完善登录信息及网络端口号...", Toast.LENGTH_SHORT).show();
                }else {
                getIP(username,pwd);
                }
                break;
            case R.id.tv_ysgj_back:
                    getActivity().finish();
                break;

        }
    }

    /**
     * 获取映射IP
     * @param username
     * @param pwd
     */
    private void getIP(String username, String pwd) {
       ProgressDialogUtils.showProgressDialog(getActivity(), "正在登陆...");
        JSONObject obj = new JSONObject();
        try {
            obj.put("LoginName", username);
            obj.put("LoginPwd", pwd);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(JSON, obj.toString());
        Log.e("login", "---" + obj.toString());
        try {
            Request request = new Request.Builder().url(AllUrl.YSGJ_URL).post(body).build();
            Call call = okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    String res2 = "网络请求失败，请检查服务器设置";
                    e.printStackTrace();
                    // 关闭进度条
                    handler.sendEmptyMessage(0);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String res = response.body().string();
                    try {
                        JSONObject obj = new JSONObject(BaseUtil.processDataYsgj(res));
                        boolean succes = obj.getBoolean("Success");
                        if (succes){
                            ip=obj.getString("Data");
                            handler.sendEmptyMessage(1);
                        }
                        else {
                            error=obj.getString("Error");
                            handler.sendEmptyMessage(2);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        handler.sendEmptyMessage(3);
                    }
                    Log.e("login", "res--" + res);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            ProgressDialogUtils.dismissProgressDialog();
        }
    }

}
