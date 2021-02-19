package com.westone.ucss.test;

import com.westone.pboc.service.HSMApiService;
import com.westone.pboc.service.imp.HSMApiServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class TestEncDecData extends TestCase {
    private HSMApiService csmpApi;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        csmpApi = new HSMApiServiceImpl();
    }

    @Test
    public void testEncDecSm4() throws Exception {
        String keyType = "9";
        String flag = "1";
        String appId = "GDHR";
        String nodeId = "0101";
        String algType = "2";
        String algMode = "1";
        String iv = null;
        String data = "31323334353637383132333435363738";
        System.out.println("加密~~~~");
        List<String> result = csmpApi.HSM_EncryptDecryptData(keyType,flag,appId,nodeId,algType,algMode,iv, String.valueOf(data.length()/2),data);
        for(String s : result){
            System.out.println("加密后的额数据~~~~");
            System.out.println(s);
        }
        String cipher = result.get(1);

        flag = "2";
        List<String> plain = csmpApi.HSM_EncryptDecryptData(keyType,flag,appId,nodeId,algType,algMode,iv, String.valueOf(cipher.length()/2),cipher);

        for(String s : plain){
            System.out.println("解密后的数据~~~");
            System.out.println(s);
        }

    }
    @Test
    public void testHex() throws Exception{
        String test = "中国";
        StringBuffer result1 = new StringBuffer();
        for(char aa : test.toCharArray()){
            result1.append(Integer.toHexString((int)aa));
        }
        System.out.println("结果1:" + result1);

        StringBuffer result2 = new StringBuffer();
        byte[] b = test.getBytes("GBK");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
            result2.append(String.format("%02X", b[i]));
        }

        System.out.println("结果2:" + result1);
    }



}
