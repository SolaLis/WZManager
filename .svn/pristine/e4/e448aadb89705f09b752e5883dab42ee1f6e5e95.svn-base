package gjp.com.wzmanager.util;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import gjp.com.wzmanager.MyApplication;
import gjp.com.wzmanager.R;

public class ShowDatePicker {
	/**
	 * �弹出时间选择框񴰿�
	 * @param et edittext
	 * @param context  �����
	 */
	
	public static void showDatePicker(final TextView et, Context context) {
		Calendar c = Calendar.getInstance();
		new DatePickerDialog(context,
				new DatePickerDialog.OnDateSetListener() {

					@Override
					public void onDateSet(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {
						String month = monthOfYear + 1 + "";
						if (month.length() == 1) {
							month = "0" + month;
						}
						String day = dayOfMonth + "";
						if (day.length() == 1) {
							day = "0" + day;
						}
						et.setText(year + "-" + month + "-" + day);
                        et.setTextColor(MyApplication.getContext().getResources().getColor(R.color.query_text));
					}
				}, c.get(Calendar.YEAR), c.get(Calendar.MONTH),
				c.get(Calendar.DAY_OF_MONTH)).show();
	}
	public static void showDatePicker2(final TextView et, Context context) {
		Calendar c = Calendar.getInstance();
		new DatePickerDialog(context,
				new DatePickerDialog.OnDateSetListener() {

					@Override
					public void onDateSet(DatePicker view, int year,
										  int monthOfYear, int dayOfMonth) {
						String month = monthOfYear + 1 + "";
						if (month.length() == 1) {
							month = "0" + month;
						}
						String day = dayOfMonth + "";
						if (day.length() == 1) {
							day = "0" + day;
						}
						et.setText(year + "-" + month + "-" + day);

					}
				}, c.get(Calendar.YEAR), c.get(Calendar.MONTH),
				c.get(Calendar.DAY_OF_MONTH)).show();
	}
}
