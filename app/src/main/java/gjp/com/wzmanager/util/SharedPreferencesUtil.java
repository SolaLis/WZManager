package gjp.com.wzmanager.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {
	public static String CONFIG = "config";
	private static SharedPreferences sharedPreferences;

	// 存储string方法
	public static void saveStringData(Context context, String key, String value) {
		if (sharedPreferences == null) {
			sharedPreferences = context.getSharedPreferences(CONFIG,
					Context.MODE_PRIVATE);
		}
		sharedPreferences.edit().putString(key, value).commit();
	}

	// 定点清除缓存
	public static void removeStringData(Context context, String key) {
		if (sharedPreferences == null) {
			sharedPreferences = context.getSharedPreferences(CONFIG,
					Context.MODE_PRIVATE);
		}
		sharedPreferences.edit().remove(key).commit();
	}

	// 清除所有缓存
	public static void remove() {
		if (sharedPreferences != null) {
			sharedPreferences.edit().clear().commit();
		}
	}

	// 取出String方法
	public static String getStringData(Context context, String key,
                                       String defValue) {
		if (sharedPreferences == null) {
			sharedPreferences = context.getSharedPreferences(CONFIG,
					Context.MODE_PRIVATE);
		}
		return sharedPreferences.getString(key, defValue);
	}

	// 存储int方法
	public static void saveIntData(Context context, String key, int value) {
		if (sharedPreferences == null) {
			sharedPreferences = context.getSharedPreferences(CONFIG,
					Context.MODE_PRIVATE);
		}
		sharedPreferences.edit().putInt(key, value).commit();
	}

	// 取出int方法
	public static int getIntData(Context context, String key, int defValue) {
		if (sharedPreferences == null) {
			sharedPreferences = context.getSharedPreferences(CONFIG,
					Context.MODE_PRIVATE);
		}
		return sharedPreferences.getInt(key, defValue);
	}

	public static void resetStringData(Context context, String key, String value) {
		removeStringData(context, key);
		saveStringData(context, key, value);
	}
}
