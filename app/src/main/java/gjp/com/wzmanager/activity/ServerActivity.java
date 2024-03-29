package gjp.com.wzmanager.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import gjp.com.wzmanager.R;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

public class ServerActivity extends Fragment implements View.OnClickListener {


    private TextView tv_server_save;//保存
    private TextView tv_server_back;//返回
    private View v;
    private EditText et;//服务器地址输入框
    private String aurl = "http://188kj21855.imwork.net:14916";
    private String etString;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.activity_server, null);
        init();
        //透明状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getActivity().getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        return v;
    }
    /*
     * 初始化控件
     * */
    private void init() {
        tv_server_save = (TextView)v.findViewById(R.id.tv_server_save);
        tv_server_back = (TextView)v. findViewById(R.id.tv_server_back);
        et = (EditText)v. findViewById(R.id.et_server);

        tv_server_back.setOnClickListener(this);
        tv_server_save.setOnClickListener(this);

        String serUrl = SharedPreferencesUtil.getStringData(
                getActivity(), "setUrl", null);

        if (serUrl != null) {
            et.setText(serUrl);
        } else {
            et.setText(aurl);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_server_back://返回按钮
                getActivity().finish();
                break;
            case R.id.tv_server_save://保存按钮
                etString=et.getText().toString().trim();
                SharedPreferencesUtil.saveStringData(getActivity(),
                        "setUrl", etString);
                getActivity().finish();
                Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;

        }
    }
}
