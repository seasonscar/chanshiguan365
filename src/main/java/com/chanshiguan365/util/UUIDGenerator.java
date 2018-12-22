package com.chanshiguan365.util;

import java.util.UUID;

public class UUIDGenerator {

    public static String getUUID() {
        // 取两组UUID拼接字符串
        String s = UUID.randomUUID().toString() + UUID.randomUUID().toString();
        // 去除UUID中的'-',并截取成48位
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24, 44)
                + s.substring(45, 49) + s.substring(50, 54);
    }

}