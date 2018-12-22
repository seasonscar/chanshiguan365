package com.chanshiguan365.util;

import sun.misc.BASE64Decoder;

/**
 * Created by 15082188 on 2018/12/19.
 */
public class Base64Util {
    public static byte[] GenerateImage(String imgStr,String path){   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i){
                if(b[i]<0){//调整异常数据
                    b[i]+=256;
                }
            }

            return b;
        }  catch (Exception e) {
            return null;
        }
    }
}
