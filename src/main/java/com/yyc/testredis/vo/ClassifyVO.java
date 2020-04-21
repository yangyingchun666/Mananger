package com.yyc.testredis.vo;

import lombok.Data;

/**
 * @program: testredis
 * @description:
 * @author: Anakin Yang
 * @create: 2020-04-20 15:05
 **/
@Data
public class ClassifyVO{
    private String id;
    private String name;
    private String parentId;
}