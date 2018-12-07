package com.chanshiguan365.util;

/**
 * Created by 15082188 on 2018/12/7.
 */
public class StringUtil {
    public static boolean isNullOrEmpty(Object o) {
        return o == null || String.valueOf(o).trim().length() == 0;
    }
}
