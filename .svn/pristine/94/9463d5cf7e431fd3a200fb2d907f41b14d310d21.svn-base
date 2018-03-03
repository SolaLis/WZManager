package gjp.com.wzmanager.util;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/8/3.
 */

public class NumUtil {
    /**
     * 提供精確的加法運算
     *
     * @param
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 去掉小数点后面无用的0
     *
     * @param num
     * @return
     */
    public static String doubleTrans(double num) {
        if (num % 1.0 == 0) {
            return String.valueOf((long) num);
        }
        return String.valueOf(num);
    }

}
