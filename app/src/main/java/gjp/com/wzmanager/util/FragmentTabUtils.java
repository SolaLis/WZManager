package gjp.com.wzmanager.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import java.util.List;
import gjp.com.wzmanager.fragment.BaseFragment;

public class FragmentTabUtils implements RadioGroup.OnCheckedChangeListener {
	private List<BaseFragment> fragments;
	private RadioGroup rgs;
	private FragmentManager fragmentManager;
	private int fragmentContentId;
	private int currentTab;
	private OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener;

	public FragmentTabUtils(List<BaseFragment> fragments, RadioGroup rgs,
                            FragmentManager fragmentManager, int fragmentContentId) {
		this.fragments = fragments;
		this.rgs = rgs;
		this.fragmentManager = fragmentManager;
		this.fragmentContentId = fragmentContentId;
		fragmentManager.beginTransaction()
				.add(fragmentContentId, fragments.get(0)).commit();
		rgs.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		for (int i = 0; i < rgs.getChildCount(); i++) {
			if (rgs.getChildAt(i).getId() == checkedId) {
				Fragment fragment = fragments.get(i);
				FragmentTransaction ft = obtainFragmentTransaction(i);
				getCurrentFragment().onStop();
				if (fragment.isAdded())
					fragment.onStart();
				else {
					ft.add(fragmentContentId, fragment);
					ft.commit();
				}
				showTab(i);
				if (null != onRgsExtraCheckedChangedListener) {
					onRgsExtraCheckedChangedListener.OnRgsExtraCheckedChanged(
							group, checkedId, i);
				}
			}
		}
	}

	private void showTab(int idx) {
		for (int i = 0; i < fragments.size(); i++) {
			Fragment fragment = fragments.get(i);
			FragmentTransaction ft = obtainFragmentTransaction(i);
			if (idx == i)
				ft.show(fragment);
			else
				ft.hide(fragment);
			ft.commit();
		}
		currentTab = idx;
	}

	private FragmentTransaction obtainFragmentTransaction(int index) {
		FragmentTransaction ft = fragmentManager.beginTransaction();
		// 设置切换动画
		// if (index > currentTab) {
		// ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
		// } else {
		// ft.setCustomAnimations(R.anim.slide_right_in,
		// R.anim.slide_right_out);
		// }
		return ft;
	}

	public int getCurrentTab() {
		return currentTab;
	}

	public Fragment getCurrentFragment() {
		return fragments.get(currentTab);
	}

	public static interface OnRgsExtraCheckedChangedListener {
		public void OnRgsExtraCheckedChanged(RadioGroup radioGroup,
                                             int checkedId, int index);
	}

	public OnRgsExtraCheckedChangedListener getOnRgsExtraCheckedChangedListener() {
		return onRgsExtraCheckedChangedListener;
	}

	public void setOnRgsExtraCheckedChangedListener(
			OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener) {
		this.onRgsExtraCheckedChangedListener = onRgsExtraCheckedChangedListener;
	}
}
