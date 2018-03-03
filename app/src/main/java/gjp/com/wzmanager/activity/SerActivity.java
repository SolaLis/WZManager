package gjp.com.wzmanager.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import gjp.com.wzmanager.R;

public class SerActivity extends BaseActivity {
    private ViewPager mVp;
    private TextView tv1,tv2;
    //用于存储切换的碎片
    private List<Fragment> list=new ArrayList<Fragment>();
    //准备适配器
    private FragmentPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ser);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        init();
        setAdapter();
        Linten();

    }

    /**
     * 设置监听器
     */
    private void Linten() {
        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                //切换小圆点
                    switch (position){
                        case 0:
                            tv1.setBackgroundResource(R.drawable.ciecle_yellow);
                            tv2.setBackgroundResource(R.drawable.ciecle);
                            break;
                        case 1:
                            tv2.setBackgroundResource(R.drawable.ciecle_yellow);
                            tv1.setBackgroundResource(R.drawable.ciecle);
                            break;
                    }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /**
     * 设置适配器
     */
    private void setAdapter() {
        //通过内部类形式获取适配器
        adapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return list.size();
            }
            @Override
            public Fragment getItem(int arg0) {
                return list.get(arg0);
            }
        };
        mVp.setAdapter(adapter);
    }

    /**
     * 初始化
     */
    private void init() {
        tv1= (TextView) findViewById(R.id.tv_ser_1);
        tv2= (TextView) findViewById(R.id.tv_ser_2);
        mVp= (ViewPager) findViewById(R.id.vp);
        ServerActivity server=new ServerActivity();
        YsgjActivity ysgj=new YsgjActivity();
        list.add(server);
        list.add(ysgj);
    }
}
