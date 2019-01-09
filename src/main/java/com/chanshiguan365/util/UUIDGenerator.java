/*
 * Copyright (C), 2002-2012, 苏宁易购电子商务有限公司
 * FileName: //文件名
 * Author:   10075910
 * Date:     2012-6-27 上午9:02:48
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
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