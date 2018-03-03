package gjp.com.wzmanager.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import gjp.com.wzmanager.R;
import gjp.com.wzmanager.bean.ModuleBean;

public class MoreAdapter extends BaseAdapter {

	private Context context;
	private int position = 0;
	Holder hold;
	private List<ModuleBean.MBean> lists;

	public MoreAdapter(Context context, List<ModuleBean.MBean> lists) {
		this.context = context;
		this.lists = lists;
	}

	public int getCount() {
		return lists.size();
	}

	public ModuleBean.MBean getItem(int position) {
		return lists.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int arg0, View view, ViewGroup viewGroup) {

		if (view == null) {
			view = View.inflate(context, R.layout.item_classify_morelist, null);
			hold = new Holder(view);
			view.setTag(hold);
		} else {
			hold = (Holder) view.getTag();
		}
		hold.txt.setText(lists.get(arg0).getModulec());
		hold.txt.setTextColor(0xFF666666);
		/*if (arg0 == position) {
			hold.txt.setTextColor(0xFFFF8C00);
		}*/
		return view;
	}

	public void setSelectItem(int position) {
		this.position = position;
	}

	private static class Holder {
		TextView txt;

		public Holder(View view) {
			txt = (TextView) view.findViewById(R.id.moreitem_txt);
		}
	}
}
