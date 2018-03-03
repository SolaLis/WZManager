package gjp.com.wzmanager.ui;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

import gjp.com.wzmanager.activity.BaseActivity;

public class CHScrollView1 extends HorizontalScrollView {

	//SqbJyActivity activity;
	BaseActivity activity;

	public CHScrollView1(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		activity = (BaseActivity) context;
	}


	public CHScrollView1(Context context, AttributeSet attrs) {
		super(context, attrs);
		activity = (BaseActivity) context;
	}

	public CHScrollView1(Context context) {
		super(context);
		activity = (BaseActivity) context;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		//进行触摸赋值
		activity.mTouchView1 = this;
		return super.onTouchEvent(ev);
	}
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		//当当前的CHSCrollView被触摸时，滑动其它
		if(activity.mTouchView1 == this) {
			activity.onScrollChanged(l, t, oldl, oldt);
		}else{
			super.onScrollChanged(l, t, oldl, oldt);
		}
	}
}
