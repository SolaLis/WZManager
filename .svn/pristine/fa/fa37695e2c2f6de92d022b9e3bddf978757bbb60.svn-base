package gjp.com.wzmanager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;
import gjp.com.wzmanager.MyApplication;
import gjp.com.wzmanager.ui.CHScrollView1;
import gjp.com.wzmanager.ui.CHScrollView2;
import gjp.com.wzmanager.util.ActivityCollector;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

public class BaseActivity extends AppCompatActivity {
    //方便测试，直接写的public
    // public HorizontalScrollView mTouchView;
    public ScrollView mTouchView;
    //装入所有的HScrollView
    protected List<CHScrollView2> mHScrollViews =new ArrayList<CHScrollView2>();
    public HorizontalScrollView mTouchView1;
    //装入所有的HScrollView
    protected List<CHScrollView1> mHScrollViews1 =new ArrayList<CHScrollView1>();
    private String islistPush;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        islistPush= SharedPreferencesUtil.getStringData(MyApplication.getContext(), "islistPush", null);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    /*public void onScrollChanged(int l, int t, int oldl, int oldt){
        for(CHScrollView2 scrollView : mHScrollViews) {
            //防止重复滑动
            if(mTouchView != scrollView)
                scrollView.smoothScrollTo(l, t);
        }
    }*/
    public void onScrollChanged(int l, int t, int oldl, int oldt){
        if ("1".equals(islistPush)){
            for(CHScrollView2 scrollView : mHScrollViews) {
                //防止重复滑动
                if(mTouchView != scrollView)
                    scrollView.smoothScrollTo(l, t);
            }}else {
            for(CHScrollView1 scrollView : mHScrollViews1) {
                //防止重复滑动
                if(mTouchView1 != scrollView)
                    scrollView.smoothScrollTo(l, t);
            }
        }
    }

}
