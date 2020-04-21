package com.yyc.testredis.service;

import com.yyc.testredis.pojo.Classify;
import com.yyc.testredis.utils.Page;
import com.yyc.testredis.vo.ClassifyVO;

import java.util.List;

public interface ClassifyService {
    List<Classify> selectPageList(Page page);

    int selectPageCount(Page page);

    List<Classify> selectClassifyByLevel(Integer level);

    String selectParentIdById(String getgClassfyId);

    List<ClassifyVO> getClassify();

    List<ClassifyVO> getClassifyChildren(String parentId);
}
