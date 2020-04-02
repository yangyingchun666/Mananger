package com.yyc.testredis.utils;

/**
 * DESUtils测试类
 */
public class DESUtilsTest {

    public static void main(String[] args) throws Exception {
        DESUtil des = new DESUtil();
        // DES 加密文件
        // des.encryptFile("G:/test.doc", "G:/ 加密 test.doc");
        // DES 解密文件
        // des.decryptFile("G:/ 加密 test.doc", "G:/ 解密 test.doc");
//        String str1 = "taskId=68&correctDate=2015-04-13&flag=1" ;
        String str1 = "yyc123456" ;
        // DES 加密字符串
        String str2 = des.encryptStr(str1);
        // DES 解密字符串
        String deStr = des.decryptStr(str2);
        System. out .println( " 加密前： " + str1);
        System. out .println( " 加密后： " + str2);
        System. out .println( " 解密后： " + deStr);
    }
}
