package gjp.com.wzmanager.util;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

import gjp.com.wzmanager.R;

public class ProgressDialogUtils {
	private static Dialog mLoadingDialog;

	/**
	 * 显示ProgressDialog
	 *
	 * @param context
	 * @param msg
	 */
	public static void showProgressDialog(Context context,String msg) {
		View view = LayoutInflater.from(context).inflate(R.layout.layout_loading_dialog, null);
		TextView loadingText = (TextView) view.findViewById(R.id.id_tv_loading_dialog_text);
		AVLoadingIndicatorView avLoadingIndicatorView = (AVLoadingIndicatorView) view.findViewById(R.id.AVLoadingIndicatorView);
		loadingText.setText(msg);
		if (mLoadingDialog == null) {
			mLoadingDialog = new Dialog(context, R.style.loading_dialog_style);
			mLoadingDialog.setCancelable(false);
			mLoadingDialog.setContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT));

			mLoadingDialog.show();
			avLoadingIndicatorView.smoothToShow();
		}else {
			mLoadingDialog.show();
			avLoadingIndicatorView.smoothToShow();
		}
		mLoadingDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_BACK) {
					//mLoadingDialog.hide();
					return true;
				}
				return false;
			}
		});
	}

	public static void fragProgressDialog(Context context, CharSequence msg) {
		View view = LayoutInflater.from(context).inflate(R.layout.layout_loading_dialog, null);
		TextView loadingText = (TextView) view.findViewById(R.id.id_tv_loading_dialog_text);
		AVLoadingIndicatorView avLoadingIndicatorView = (AVLoadingIndicatorView) view.findViewById(R.id.AVLoadingIndicatorView);
		loadingText.setText(msg);
		if (mLoadingDialog == null) {
			mLoadingDialog = new Dialog(context, R.style.loading_dialog_style);
			mLoadingDialog.setCancelable(false);
			mLoadingDialog.setContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT));

			mLoadingDialog.show();
			avLoadingIndicatorView.smoothToShow();
		}else {
			mLoadingDialog.show();
			avLoadingIndicatorView.smoothToShow();
		}
		mLoadingDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_BACK) {
					//mLoadingDialog.hide();
					return true;
				}
				return false;
			}
		});
	}

	/**
	 * 关闭ProgressDialog
	 */
	public static void dismissProgressDialog() {
		if (mLoadingDialog != null) {
			mLoadingDialog.dismiss();
			mLoadingDialog = null;
		}
	}


}
