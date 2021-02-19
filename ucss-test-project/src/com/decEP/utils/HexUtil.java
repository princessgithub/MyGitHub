package com.decEP.utils;
import org.apache.commons.codec.binary.Hex;

public class HexUtil {

    /**
     * 将data转为hex编码
     * */
    public static String encodeHex(String data) {

        String result = new String(Hex.encodeHex(data.getBytes()));

        //判断长度是否为32的倍数 计算方法 result的长度 & 0x11111 当不为0时说明不是32的倍数需要补充位数
        int a = result.length() & 31;
        if (a != 0) {
            int b = 32 - a;
            for (int i = 0; i < b / 2; i++) {
                result = result + "00";
            }
        }

        return result;

    }

    /**
     * 解码de
     * */
    public static String decodeHex(String data) throws Exception{
        String result = new String(Hex.decodeHex(data.toCharArray()));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String Str = new String("m.runoob.com");

        System.out.print("返回值 :" );
        System.out.println(Str.substring(4) );

        System.out.print("返回值 :" );
        System.out.println(Str.substring(4, 10) );

    }

}
