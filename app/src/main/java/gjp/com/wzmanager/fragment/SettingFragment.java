package gjp.com.wzmanager.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import gjp.com.wzmanager.R;
import gjp.com.wzmanager.activity.AboutActivity;
import gjp.com.wzmanager.activity.LoginActivity;
import gjp.com.wzmanager.activity.UsermessageActivity;
import gjp.com.wzmanager.ui.SlipButton;
import gjp.com.wzmanager.util.ActivityCollector;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

public class SettingFragment extends BaseFragment {
    private TextView header_title;
    private RelativeLayout rl_information_information; // 基础信息

    private RelativeLayout rl_about; // 关于
    private Button btn_out; // 注销
    private Intent intent;
    private SlipButton slip_btn_image;//是否显示图片的按钮
    private String islistPush;
    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_setting, null);
        rl_information_information = (RelativeLayout) view
                .findViewById(R.id.rl_information_information);
        rl_about = (RelativeLayout) view.findViewById(R.id.rl_about);
        btn_out = (Button) view.findViewById(R.id.btn_out);
        slip_btn_image = (SlipButton) view.findViewById(R.id.slip_btn_image);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        header_title = (TextView) getView().findViewById(R.id.header_title);
        header_title.setText(R.string.tv_circle);
        // 是否显示图片
        islistPush = SharedPreferencesUtil.getStringData(context, "islistPush",
                null);
        if (TextUtils.isEmpty(islistPush)) {
            slip_btn_image.setCheck(false);
            SharedPreferencesUtil.saveStringData(context, "islistPush", "0");
        } else {
            if (islistPush.equals("0")) {
                slip_btn_image.setCheck(false);
            } else if (islistPush.equals("1")) {
                slip_btn_image.setCheck(true);
            }
        }
        slip_btn_image.SetOnChangedListener(new SlipButton.OnChangedListener() {
            @Override
            public void OnChanged(boolean CheckState) {
                islistPush = SharedPreferencesUtil.getStringData(context,
                        "islistPush", null);
                if (islistPush.equals("1")) {
                    Log.e("TAG", "不显示图片");
                    SharedPreferencesUtil.saveStringData(context, "islistPush",
                            "0");
                    slip_btn_image.setCheck(false);
                } else if (islistPush.equals("0")) {
                    Log.e("TAG", "显示图片");
                    SharedPreferencesUtil.saveStringData(context, "islistPush",
                            "1");
                    slip_btn_image.setCheck(true);
                }
            }
        });
        // 基础信息点击事件
        rl_information_information
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        intent = new Intent(getActivity(),
                                UsermessageActivity.class);
                        startActivity(intent);
                    }
                });


        // 关于点击事件
        rl_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
        });

        // 注销点击事件
        btn_out.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
                // 清除共享参数
                SharedPreferencesUtil.removeStringData(getActivity(), "usercode");
                SharedPreferencesUtil.removeStringData(getActivity(),"bm_name");
                SharedPreferencesUtil.removeStringData(getActivity(),"username");
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

    }
}
