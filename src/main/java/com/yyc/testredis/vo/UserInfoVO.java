package com.yyc.testredis.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoVO {
    private String id;

    private String username;

    private String password;

    private String sex;

    private String city;

    private String sign;

    private String phone;

    private String birth;

    private String roleId;

    //user_role表
    private String roleName;

    private String roleParentId;

    private String headerImgPath;
    //user_role表


    private Date createTime;

    private Date updateTime;
}
