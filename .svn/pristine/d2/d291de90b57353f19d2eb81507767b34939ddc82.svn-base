package gjp.com.wzmanager.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.fragment.CheckFragment;
import gjp.com.wzmanager.fragment.IndexFragment;
import gjp.com.wzmanager.fragment.SettingFragment;
import gjp.com.wzmanager.util.ActivityCollector;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.fl_main)
    FrameLayout flMain;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;


    private IndexFragment indexFragment=new IndexFragment();
    private SettingFragment settingFragment=new SettingFragment();
    private CheckFragment checkFragment=new CheckFragment();
    private int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Intent intert=getIntent();
        flag = intert.getIntExtra("flag",-1);
        init();
    }

    private void init() {
        setDefaultFragment();
        navigation.setOnNavigationItemSelectedListener(this);

    }

    // 给对话框里的按钮注册事件
    DialogInterface.OnClickListener hello = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {

            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// 点击 确认，退出程序
                    ActivityCollector.finishAll();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// 点击 取消 取消对话框
                    dialog.dismiss();
                    break;
                default:
                    break;
            }
        }

    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
// 创建退出对话框
            AlertDialog isExit = new AlertDialog.Builder(this).create();
// 设置对话框标题
            isExit.setTitle("提示");
// 对话框显示的内容
            isExit.setMessage("亲，真的要退出么？");
// 给提示框里的按钮添加监听
            isExit.setButton("确定", hello);
            isExit.setButton2("取消", hello);
// 显示对话框
            isExit.show();
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.navigation_home:
              if (indexFragment == null) {
                    indexFragment = new IndexFragment();
                }
                checkFragment=null;
                transaction.replace(R.id.fl_main, indexFragment);
                transaction.commit();
                return true;
            case R.id.navigation_dashboard:

             if (checkFragment == null) {
                 checkFragment = new CheckFragment();
                }
                transaction.replace(R.id.fl_main, checkFragment);
                transaction.commit();
                return true;
            case R.id.navigation_notifications:

           if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                }
                checkFragment=null;
                transaction.replace(R.id.fl_main, settingFragment);
                transaction.commit();
                return true;

        }

        return false;
    }


    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (flag==1){
            checkFragment = new CheckFragment();
            navigation.setSelectedItemId(R.id.navigation_dashboard);
            transaction.replace(R.id.fl_main, checkFragment);
        }else {
        indexFragment = new IndexFragment();
        transaction.replace(R.id.fl_main, indexFragment);
        }
        transaction.commit();
    }
}
