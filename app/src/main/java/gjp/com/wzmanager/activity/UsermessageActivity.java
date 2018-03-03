package gjp.com.wzmanager.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

public class UsermessageActivity extends BaseActivity {
    @BindView(R.id.header_title)
    TextView headerTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    private TextView yh_no_message; // 账号
    private TextView yh_name_message; // 姓名
    private TextView yh_no_source; // 部门


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermessage);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        headerTitle.setText("基础信息");
        ivBack.setVisibility(View.VISIBLE);

        yh_no_message = (TextView) findViewById(R.id.yh_no_message);
        yh_name_message = (TextView) findViewById(R.id.yh_name_message);
        yh_no_source = (TextView) findViewById(R.id.yh_no_source);
        String yh_no = SharedPreferencesUtil.getStringData(
                getApplicationContext(), "usercode", null);
        String yh_name = SharedPreferencesUtil.getStringData(
                getApplicationContext(), "username", null);
        String Bm_name = SharedPreferencesUtil.getStringData(
                getApplicationContext(), "bm_name", null);
        Log.e("TAG", "基础信息----" + yh_name + "---" + yh_no + "---" + Bm_name);


        yh_no_message.setText(yh_no);
        yh_name_message.setText(yh_name);
        yh_no_source.setText(Bm_name);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
