package gjp.com.wzmanager.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import gjp.com.wzmanager.MyApplication;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.activity.QueryActivity;
import gjp.com.wzmanager.activity.SqbActivity;
import gjp.com.wzmanager.ui.SearchView;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.GlideImageLoader;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class IndexFragment extends BaseFragment {

    @BindView(R.id.header_title)
    TextView headerTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.sv_index)
    SearchView svIndex;
    @BindView(R.id.btn_cgsq)
    Button btnCgsq;
    @BindView(R.id.btn_lysq)
    Button btnLysq;
    @BindView(R.id.btn_jysq)
    Button btnJysq;
    @BindView(R.id.btn_xssq)
    Button btnXssq;
    @BindView(R.id.btn_zysq)
    Button btnZysq;
    @BindView(R.id.btn_drsq)
    Button btnDrsq;
    @BindView(R.id.btn_dcsq)
    Button btnDcsq;
    Unbinder unbinder;
    @BindView(R.id.banner)
    Banner banner;

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_index, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        //本地图片数据（资源文件）
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.banner1);
        list.add(R.drawable.banner2);
        list.add(R.drawable.banner3);
        banner.setImages(list).setImageLoader(new GlideImageLoader()).start();
        svIndex.setSearchViewListener(new SearchView.SearchViewListener() {
            @Override
            public void onRefreshAutoComplete(String text) {

            }

            @Override
            public void onSearch(String text) {
                if (text.length()==0||"".equals(text)){
                    BaseUtil.myToast("请输入需要搜索的关键字");
                }
                else {
                    Intent intent=new Intent(MyApplication.getContext(), SqbActivity.class);
                    intent.putExtra("search",text);
                    intent.putExtra("flag",1);
                    startActivity(intent);
                }

            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();//结束轮播
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_cgsq, R.id.btn_lysq, R.id.btn_jysq, R.id.btn_xssq, R.id.btn_zysq, R.id.btn_drsq, R.id.btn_dcsq})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_cgsq:
                startQueryActivity("001");
                break;
            case R.id.btn_lysq:
                startQueryActivity("002");
                break;
            case R.id.btn_jysq:
                startQueryActivity("003");
                break;
            case R.id.btn_xssq:
                startQueryActivity("004");
                break;
            case R.id.btn_zysq:
                startQueryActivity("005");
                break;
            case R.id.btn_drsq:
                startQueryActivity("006");
                break;
            case R.id.btn_dcsq:
                startQueryActivity("007");
                break;
        }
    }

    private void startQueryActivity(String sqmsbm) {
        Log.e("LOG", "startQueryActivity(IndexFragment.java:107)===" + sqmsbm);
        Intent intent = new Intent(MyApplication.getContext(), QueryActivity.class);
        intent.putExtra("sqmsbm", sqmsbm);
        startActivity(intent);
    }


}
