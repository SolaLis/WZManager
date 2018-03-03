package gjp.com.wzmanager.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gjp.com.wzmanager.R;

public class AboutActivity extends BaseActivity {

    @BindView(R.id.header_title)
    TextView headerTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    private TextView tv_version_no; // 版本号
    private LinearLayout ll_about_qq; // qq联系
    private String URL = "mqqwpa://im/chat?chat_type=wpa&uin=2851167840&version=1";
    private TextView Tv;    //文本超链接

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        headerTitle.setText("关于我们");
        ivBack.setVisibility(View.VISIBLE);
        // 实例化
        tv_version_no = (TextView) findViewById(R.id.tv_version_no);
        ll_about_qq = (LinearLayout) findViewById(R.id.ll_about_qq);
        Tv = (TextView) findViewById(R.id.Tv);

        //文本超链接
        SpannableString ss = new SpannableString("http://www.qmpcn.com/");
        ss.setSpan(new URLSpan("http://www.qmpcn.com/"), 0, 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Tv.setText(ss);
        Tv.setMovementMethod(LinkMovementMethod.getInstance());


        // 获取版本信息
        getVersion();

        //qq联系方式
        ll_about_qq.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                startActivity(intent);
            }
        });


    }

    /**
     * 获取版本号
     */
    private void getVersion() {
        // TODO Auto-generated method stub
        PackageManager pManager = getPackageManager();
        String packageName = getPackageName();
        PackageInfo packageInfo;
        try {
            packageInfo = pManager.getPackageInfo(packageName, 0);
            // return packageInfo.versionName;
            Log.e("TAG", "版本---" + packageInfo.versionName);
            tv_version_no.setText(packageInfo.versionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}