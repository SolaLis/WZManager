package gjp.com.wzmanager.util;

import android.widget.Toast;

import gjp.com.wzmanager.MyApplication;


/**
 * Created by Administrator on 2017/5/10.
 */

public class BaseUtil {
    private static Toast toast;

    /**
     * Toast的调用封装成一个接口
     *
     * @param content 显示的消息
     */
    public static void myToast(String content) {
        if (toast == null) {
            toast = Toast.makeText(MyApplication.getContext(),
                    content,
                    Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

    /**
     * 去除服务器返回数据的头尾 转化为JSON
     *
     * @param result
     * @return
     */
    public static String processData(String result) {
        // 执行去除字符串操作
        String sub = "";
        sub = result.replace("?", "");
        // 调用方法
        String sxb = "";
        sxb = sub
                .replaceAll(
                        "<xml version=\"1.0\" encoding=\"utf-8\">|<string xmlns=\"http://tempuri.org/\">|</string>",
                        "");

        return sxb;
    }

    public static boolean strIsEmpty(String s) {
        if ("null".equals(s) || "".equals(s) ||  s == ""||s.length()==0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 去除服务器返回数据的头尾 转化为JSON  映射工具专用
     *
     * @param result
     * @return
     */
    public static String processDataYsgj(String result) {
        // 执行去除字符串操作
        String sub = "";
        sub = result.replace("?", "");
        // 调用方法
        String sxb = "";
        sxb = sub
                .replaceAll(
                        "<xml version=\"1.0\" encoding=\"utf-8\">|<string xmlns=\"http://www.hzxsjgxx.com/nattoolWebServices/\">|</string>",
                        "");

        return sxb;
    }
}
