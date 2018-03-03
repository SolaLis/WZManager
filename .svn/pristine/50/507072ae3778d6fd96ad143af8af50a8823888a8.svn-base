package gjp.com.wzmanager.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import gjp.com.wzmanager.R;
import gjp.com.wzmanager.contract.LoginContract;
import gjp.com.wzmanager.presenter.LoginPresenter;
import gjp.com.wzmanager.util.ActivityCollector;
import gjp.com.wzmanager.util.AllUrl;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.ProgressDialogUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

public class LoginActivity extends BaseActivity implements LoginContract.View, View.OnClickListener {
    private LoginContract.Presenter presenter;
    private EditText etUserName, etPwd;
    private TextView tvLogin, tvServer;
    private String mUrl;
    private String userName;
    private String pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //透明状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        init();

        presenter = new LoginPresenter(this);
        setListener();
    }
    private void setListener() {
        tvLogin.setOnClickListener(this);
        tvServer.setOnClickListener(this);
    }

    private void init() {
        etUserName = (EditText) findViewById(R.id.et_login_user);
        etPwd = (EditText) findViewById(R.id.et_login_pass);
        tvLogin = (TextView) findViewById(R.id.tv_login_btn);
        tvServer = (TextView) findViewById(R.id.tv_set_server);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ActivityCollector.finishAll();
        }
        return false;
    }

    @Override
    public void loginSuccess() {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void loginFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
           @Override
           public void run() {
               BaseUtil.myToast(errorMessage);
           }
       });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_set_server://服务器设置
                Intent intent = new Intent(LoginActivity.this, SerActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_login_btn://登录按钮
                mUrl = SharedPreferencesUtil.getStringData(this, "setUrl", null);
                userName = etUserName.getText().toString().trim();
                pwd = etPwd.getText().toString().trim();
                if (mUrl == null) {
                   BaseUtil.myToast("请先进行服务器设置");
                } else if (TextUtils.isEmpty(userName)) {
                    BaseUtil.myToast("用户名不能为空");
                } else if (TextUtils.isEmpty(pwd)) {
                    BaseUtil.myToast("密码不能为空");
                } else {
                    ProgressDialogUtils.showProgressDialog(LoginActivity.this,"正在登陆...");
                    String url=mUrl+ AllUrl.LOGIN_URL;
                    presenter.login(userName,pwd, url);
                }
                break;
        }
    }
}
