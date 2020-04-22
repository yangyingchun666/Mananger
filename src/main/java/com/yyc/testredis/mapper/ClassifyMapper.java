package com.yyc.testredis.mapper;

import com.yyc.testredis.pojo.Classify;
import com.yyc.testredis.pojo.ClassifyExample;
import java.util.List;

import com.yyc.testredis.utils.Page;
import com.yyc.testredis.vo.ClassifyVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ClassifyMapper {
    int countByExample(ClassifyExample example);

    int deleteByExample(ClassifyExample example);

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(Classify record);

    int insertSelective(Classify record);

    List<Classify> selectByExample(ClassifyExample example);

    Classify selectByPrimaryKey(@Param("id") String id);

    int updateByExampleSelective(@Param("record") Classify record, @Param("example") ClassifyExample example);

    int updateByExample(@Param("record") Classify record, @Param("example") ClassifyExample example);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);

    List<Classify> selectPageList(Page page);

    int selectPageCount(Page page);

    List<Classify> selectClassifyByLevel(@Param("level") Integer level);

    String selectParentIdById(@Param("id") String id);

    List<ClassifyVO> getClassify();

    List<ClassifyVO> getClassifyChildren(@Param("parentId") String parentId);

    List<Classify> getClassifyAll();

    Integer selectParentLevel(@Param("cParentId") String cParentId);
}