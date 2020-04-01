package com.yyc.testredis.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.yyc.testredis.mapper.Test1Mapper;
import com.yyc.testredis.pojo.Test1;
import com.yyc.testredis.service.Test1Service;
import com.yyc.testredis.utils.DateUtils;
import com.yyc.testredis.utils.JsonResult;
import com.yyc.testredis.utils.Page;
import com.yyc.testredis.utils.PropsUtil;
import com.yyc.testredis.vo.SrcPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class Test1ServiceImpl implements Test1Service {

    @Autowired
    Test1Mapper test1Mapper;

    @Override
    public List<Test1> selectPageList(Page page) {
        List<Test1> list = test1Mapper.selectPageList(page);
        return list;
    }

    @Override
    public int selectPageCount(Page page) {
        return test1Mapper.selectPageCount(page);
    }

    @Override
    public List<Test1> selectAll() {
        return test1Mapper.selectAll();
    }

    @Override
    public Integer selectCount() {
        return test1Mapper.selectCount();
    }

    @Override
    public Test1 selectTest1ById(String id) {
        return test1Mapper.selectByPrimaryKey(id);
    }

    @Override
    public String selectPwdByUsername(String username) {
        return test1Mapper.selectPwdByUsername(username);
    }

    @Override
    public Test1 selectByUsernameAndPwd(String username) {
        return test1Mapper.selectByUsernameAndPwd(username);
    }

    @Override
    public JsonResult uploadHeaderImg(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        // 输出流
        DataOutputStream out = null;
        // 二进制读取
        DataInputStream dis = null;

        if (fileName == "" || fileName == null) {
            return new JsonResult(1, "上传失败");
        }

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf1.format(new Date());
        Random r = new Random();
        int k = r.nextInt(9999);
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        String date = DateUtils.formatDate(new Date());
        try {
            String basePath = PropsUtil.getProperty("headerImgPath") + "/" + date + "/";
            File path = new File(basePath);
            if (!path.exists()) {
                path.mkdirs();
            }
            String uploadPath = basePath + time + k + fileType;
            //uploadPath=request.getServletContext().getRealPath("/")+time+k+ fileType;
            // 获取输出流
            OutputStream os = new FileOutputStream(uploadPath);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            // 获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is = file.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            int temp;
            // 一个一个字节的读取并写入
            while ((temp = bis.read()) != (-1)) {
                bos.write(temp);
            }
            bos.flush();
            bos.close();
            bis.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block

        }
        JsonResult result = new JsonResult();
        SrcPath srcPath = new SrcPath();
        result.setState(0);
        result.setMessage("上传成功");
        srcPath.setFilePath(PropsUtil.getProperty("headerImgPath") + "/" + date + "/" + time + k + fileType);
        result.setData(srcPath);
        return result;
    }
}
