package com.westone.ucss.test;

import com.westone.pboc.service.HSMApiService;
import com.westone.pboc.service.imp.HSMApiServiceImpl;

import java.util.List;

public class MainTest {

    public static void main(String[] args) throws Exception{
        HSMApiService csmpApi = new HSMApiServiceImpl();

        String keyType = "9";
        String flag = "1";
        String appId = "KJHR";
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
}
