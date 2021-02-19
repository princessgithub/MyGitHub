package com.decEP.utils;


public class HSM_EncryptDecryptData {
    // 密钥类型 WWK VIPK
    private String keyType = "9";
    //加解密标识 ‘1’-加密 ‘2’-解密
    private String encDecFlag;
    // 应用编号 
    private String nodeApp;
    // 节点编号
    private String nodeID;
    // 密钥算法 ‘1’-3DES ‘2’-SM4
    private String algFlag = "2";
    // ‘1’-ECB ‘2’-CBC
    private String algMode = "1";
    // 初始向量 algMode为CBC模式时存在
    // 3DES：16(16进制字符)
    // SM4：32(16进制字符)
    private String IV = null;
    // 数据明文长度 
    private String inDataLen;
    // 数据明文 长度：inDataLen*2
    private String inData;

    HSM_EncryptDecryptData(String encDecFlag,String nodeApp,String nodeID,String data) {
        this.encDecFlag = encDecFlag;
        this.nodeApp = nodeApp;
        this.nodeID = nodeID;
        this.inData = data;
        this.inDataLen = String.valueOf(data.length() / 2);
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getEncDecFlag() {
        return encDecFlag;
    }

    public void setEncDecFlag(String encDecFlag) {
        this.encDecFlag = encDecFlag;
    }

    public String getNodeApp() {
        return nodeApp;
    }

    public void setNodeApp(String nodeApp) {
        this.nodeApp = nodeApp;
    }

    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public String getAlgFlag() {
        return algFlag;
    }

    public void setAlgFlag(String algFlag) {
        this.algFlag = algFlag;
    }

    public String getAlgMode() {
        return algMode;
    }

    public void setAlgMode(String algMode) {
        this.algMode = algMode;
    }

    public String getIV() {
        return IV;
    }

    public void setIV(String IV) {
        this.IV = IV;
    }

    public String getInDataLen() {
        return inDataLen;
    }

    public void setInDataLen(String inDataLen) {
        this.inDataLen = inDataLen;
    }

    public String getInData() {
        return inData;
    }

    public void setInData(String inData) {
        this.inData = inData;
        setInDataLen(String.valueOf(inData.length() / 2));
    }
}
