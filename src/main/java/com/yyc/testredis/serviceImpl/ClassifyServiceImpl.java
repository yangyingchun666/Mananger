package com.yyc.testredis.serviceImpl;

import com.yyc.testredis.mapper.ClassifyMapper;
import com.yyc.testredis.pojo.Classify;
import com.yyc.testredis.service.ClassifyService;
import com.yyc.testredis.utils.Page;
import com.yyc.testredis.vo.ClassifyVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    ClassifyMapper classifyMapper;

    @Override
    public List<Classify> selectPageList(Page page) {
        return classifyMapper.selectPageList(page);
    }

    @Override
    public int selectPageCount(Page page) {
        return classifyMapper.selectPageCount(page);
    }

    @Override
    public List<Classify> selectClassifyByLevel(Integer level) {
        return classifyMapper.selectClassifyByLevel(level);
    }

    @Override
    public String selectParentIdById(String id) {
        return classifyMapper.selectParentIdById(id);
    }

    @Override
    public List<ClassifyVO> getClassify() {
        return classifyMapper.getClassify();
    }

    @Override
    public List<ClassifyVO> getClassifyChildren(String parentId) {
        return classifyMapper.getClassifyChildren(parentId);
    }
}
