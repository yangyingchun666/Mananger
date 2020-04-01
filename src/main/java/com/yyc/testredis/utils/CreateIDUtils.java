package com.yyc.testredis.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
@Slf4j
public class CreateIDUtils {

    private static Random random ;

    static {
        try{
            random = SecureRandom.getInstanceStrong();
        }catch (Exception e){
            log.info("Exception:",e);
        }
    }

    /**
     * 提供生成cardId方法
     *
     * @return
     */
    public static String  generateCardId(){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf1.format(new Date());
        Random r = new Random();
        int k = r.nextInt(999);
        return  "C" + time + String.format("%03d", k);
    }

    //生成库存信息表id
    public static String  createCarStockId(){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf1.format(new Date());
        Random r = new Random();
        int k = r.nextInt(999);
        return  "S" + time + String.format("%03d", k);
    }

    //生成商务政策表id
    public static String  createBusinessPolicyId(){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf1.format(new Date());
        Random r = new Random();
        int k = r.nextInt(999);
        return  "B" + time + String.format("%03d", k);
    }

    //生成库存详细信息表id
    public static String  createCarStockDetailId(){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf1.format(new Date());
        Random r = new Random();
        int k = r.nextInt(999);
        return  "SD" + time + String.format("%03d", k);
    }

    /**
     *  id生成
     */
    public static long genItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //加上两位随机数
        int end2 = random.nextInt(999);
        //如果不足两位前面补0
        String str = millis + String.format("%03d", end2);
        long id = new Long(str);
        return id;
    }
    /**
     *  id生成
     */
    public static String genUsualId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //加上两位随机数
        int end2 = random.nextInt(999);
        //如果不足两位前面补0
        String str = millis + String.format("%03d", end2);
        return str;
    }

    public static String genPrimaryKeyId(String type) {
        String time = DateUtils.formatDate(DateUtils.YYYYMMDDHHMMSS,new Date());
        Random r = new Random();
        int k = r.nextInt(999);
        return  type + time + String.format("%03d", k);
    }
}
