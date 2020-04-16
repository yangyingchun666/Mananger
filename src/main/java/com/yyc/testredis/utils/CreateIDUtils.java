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
     * @Description: GoodsId生成
     * 
     * @author Anakin Yang
     * @date 2020/4/15 13:42
     * @param 
     * @return  String
     */
    public static String  genGoodsId(){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf1.format(new Date());
        Random r = new Random();
        int k = r.nextInt(999);
        return  "G" + time + String.format("%03d", k);
    }

    /**
     * @Description: UserId生成
     *
     * @author Anakin Yang
     * @date 2020/4/15 13:41
     * @param
     * @return String
     */
    public static String  genUserId(){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf1.format(new Date());
        Random r = new Random();
        int k = r.nextInt(999);
        return  "U" + time + String.format("%03d", k);
    }

    /**
     * @Description: GoodLocationId 生成
     *
     * @author Anakin Yang
     * @date 2020/4/15 13:43
     * @param
     * @return String
     */
    public static String  genGoodLocationId(){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf1.format(new Date());
        Random r = new Random();
        int k = r.nextInt(999);
        return  "L" + time + String.format("%03d", k);
    }

    /**
     * @Description: Long类型id生成
     *
     * @author Anakin Yang
     * @date 2020/4/15 13:45
     * @param
     * @return Long
     */
    public static long genLongId() {
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
     * @Description: String类型id生成
     *
     * @author Anakin Yang
     * @date 2020/4/15 13:46
     * @param
     * @return String
     */
    public static String genStringId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //加上两位随机数
        int end2 = random.nextInt(999);
        //如果不足两位前面补0
        String str = millis + String.format("%03d", end2);
        return str;
    }

    /**
     * @Description: 自定义前缀 ID生成
     *
     * @author Anakin Yang
     * @date 2020/4/15 13:47
     * @param string
     * @return String
     */
    public static String genUserWriteId(String string) {
        String time = DateUtils.formatDate(DateUtils.YYYYMMDDHHMMSS,new Date());
        Random r = new Random();
        int k = r.nextInt(999);
        return  string + time + String.format("%03d", k);
    }
}
