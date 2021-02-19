package com.decEP.utils;


public class EncDecTest {
    public static void main(String[] args) {
       try{
           String type = args[0];
           String data = args[1];
           EncDecDataUtil encDecDataUtil = new EncDecDataUtil();
           if("1".equals(type)){
               System.out.println("将要加密的数据" + data);
               System.out.println("加密后的数据：" + encDecDataUtil.encryptionData(data));
           }
           if("2".equals(type)){
               System.out.println("将要解密的数据" + data);
               System.out.println("解密后的数据：" + encDecDataUtil.decryptData(data));
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
}
