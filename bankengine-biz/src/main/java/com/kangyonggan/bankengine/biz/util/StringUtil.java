package com.kangyonggan.bankengine.biz.util;

import java.math.BigDecimal;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
public class StringUtil {

    /**
     * 整型转成字符串
     *
     * @param i
     * @return
     */
    public static String integerToString(Integer i) {
        if (i == null) {
            return "0";
        } else {
            return String.valueOf(i.intValue());
        }
    }

    /**
     * 大数转字符串
     *
     * @param b
     * @return
     */
    public static String bigDecimalToString(BigDecimal b) {
        if (b == null) {
            return "";
        } else {
            return b.toString();
        }
    }
}
