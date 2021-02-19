package com.decEP.utils;

import com.westone.pboc.service.HSMApiService;
import com.westone.pboc.service.imp.HSMApiServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EncDecDataUtil {

    private HSMApiService csmpApi = new HSMApiServiceImpl();
    public static String ENCRYPT_TYPE = "1";

    public static String DECRYPT_TYPE = "2";

    private String nodeApp = "KJHR";
//    private String nodeApp = "GDHR";
    private String nodeID = "0101";

    public EncDecDataUtil() throws IOException {
    }

    public String encDecSm4(HSM_EncryptDecryptData hsm_encryptDecryptData) throws Exception {

        List<String> result = csmpApi.HSM_EncryptDecryptData(hsm_encryptDecryptData.getKeyType(),hsm_encryptDecryptData.getEncDecFlag(),
                hsm_encryptDecryptData.getNodeApp(),hsm_encryptDecryptData.getNodeID(),
                hsm_encryptDecryptData.getAlgFlag(),hsm_encryptDecryptData.getAlgMode(),
                hsm_encryptDecryptData.getIV(), String.valueOf(hsm_encryptDecryptData.getInDataLen()),hsm_encryptDecryptData.getInData());
        if (CollectionUtils.isNotEmpty(result)) {
            return result.get(1);
        }
        return "";
//        return hsm_encryptDecryptData.getInData();
    }

    /**
     * 加密方法
     * */
    public String encryptionData(String data) throws Exception{
        String hexData = HexUtil.encodeHex(data);
        StringBuilder stringBuilder = new StringBuilder();
        List<String> encryptList = getStrList(hexData,2048);
        HSM_EncryptDecryptData encryptData = new HSM_EncryptDecryptData(ENCRYPT_TYPE,nodeApp,nodeID,hexData);
        for (String encryptStr : encryptList) {
            System.out.println("--------开始进行加密---------");
            encryptData.setInData(encryptStr);
            System.out.println("--------加密数据data:" + data);
            System.out.println("--------编码后的加密数据data:" + encryptData.getInData());
            stringBuilder.append(encDecSm4(encryptData));
        }
        return stringBuilder.toString();
    }

    /**
     * 解密方法
     */
    public String decryptData(String data) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        List<String> decryptList = getStrList(data,2048);
        HSM_EncryptDecryptData encryptData = new HSM_EncryptDecryptData(DECRYPT_TYPE,nodeApp,nodeID,data);
        for (String decryptStr : decryptList) {
            encryptData.setInData(decryptStr);
            stringBuilder.append(encDecSm4(encryptData));
        }
        System.out.println("--------开始进行解密---------");

        System.out.println("--------解密数据data:" + data);
        return HexUtil.decodeHex(stringBuilder.toString()).trim();
    }

    /**
     * 把原始字符串分割成指定长度的字符串列表
     *
     * @param inputString
     *            原始字符串
     * @param length
     *            指定长度
     * @return
     */
    public static List<String> getStrList(String inputString, int length) {
        int size = inputString.length() / length;
        if (inputString.length() % length != 0) {
            size += 1;
        }
        return getStrList(inputString, length, size);
    }

    /**
     * 把原始字符串分割成指定长度的字符串列表
     *
     * @param inputString
     *            原始字符串
     * @param length
     *            指定长度
     * @param size
     *            指定列表大小
     * @return
     */
    public static List<String> getStrList(String inputString, int length,
                                          int size) {
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < size; index++) {
            String childStr = substring(inputString, index * length,
                    (index + 1) * length);
            list.add(childStr);
        }
        return list;
    }

    /**
     * 分割字符串，如果开始位置大于字符串长度，返回空
     *
     * @param str
     *            原始字符串
     * @param f
     *            开始位置
     * @param t
     *            结束位置
     * @return
     */
    public static String substring(String str, int f, int t) {
        if (f > str.length())
            return null;
        if (t > str.length()) {
            return str.substring(f, str.length());
        } else {
            return str.substring(f, t);
        }
    }


}
