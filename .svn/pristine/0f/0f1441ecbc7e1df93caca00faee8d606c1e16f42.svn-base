package gjp.com.wzmanager.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import gjp.com.wzmanager.bean.SqbmxBean;
import gjp.com.wzmanager.ui.CHScrollView1;
import gjp.com.wzmanager.ui.CHScrollView2;

/**
 * Created by Administrator on 2017/8/24.
 */

public class MyBaseAdapter extends BaseQuickAdapter<SqbmxBean,BaseViewHolder> {
    private List<CHScrollView2> mHScrollViews;
    private List<CHScrollView1> mHScrollViews1;
    private RecyclerView rv;
    private int flag;

    public MyBaseAdapter(@LayoutRes int layoutResId, @Nullable List<SqbmxBean> data, List<CHScrollView2> mHScrollViews, List<CHScrollView1> mHScrollViews1, RecyclerView rv, int flag) {
        super(layoutResId, data);
        this.mHScrollViews = mHScrollViews;
        this.mHScrollViews1 = mHScrollViews1;
        this.rv = rv;
        this.flag = flag;
    }

    @Override
    protected void convert(BaseViewHolder helper, SqbmxBean item) {

    }


    public void addHViews(final CHScrollView2 hScrollView) {
        Log.e("LOG","addHViews(SqcgAdapter.java:137)==="+1);
        if (!mHScrollViews.isEmpty()) {
            int size = mHScrollViews.size();
            CHScrollView2 scrollView = mHScrollViews.get(size - 1);
            final int scrollY = scrollView.getScrollY();
            Log.e("LOG","addHViews(SqcgAdapter.java:141)==size="+size+"==="+scrollY);
            if (scrollY != 0) {
                rv.post(new Runnable() {
                    @Override
                    public void run() {
                        //当listView刷新完成之后，把该条移动到最终位置
                        hScrollView.scrollTo(0, scrollY);
                    }
                });
            }
        }
        mHScrollViews.add(hScrollView);
    }

    public void addHViews1(final CHScrollView1 hScrollView) {
        Log.e("LOG","addHViews1(SqcgAdapter.java:154)==="+1);
        if (!mHScrollViews1.isEmpty()) {
            int size = mHScrollViews1.size();
            CHScrollView1 scrollView = mHScrollViews1.get(size - 1);
            final int scrollX = scrollView.getScrollX();
            Log.e("LOG","addHViews1(SqcgAdapter.java:162)=size=="+size+"==="+scrollX);
            if (scrollX != 0) {
                rv.post(new Runnable() {
                    @Override
                    public void run() {
                        //当listView刷新完成之后，把该条移动到最终位置
                        hScrollView.scrollTo(scrollX, 0);
                    }
                });
            }
        }
        mHScrollViews1.add(hScrollView);
    }
}
