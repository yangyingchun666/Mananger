package com.yyc.testredis.mapper;

import com.yyc.testredis.pojo.GoodsLocation;
import com.yyc.testredis.pojo.GoodsLocationExample;
import java.util.List;

import com.yyc.testredis.utils.Page;
import org.apache.ibatis.annotations.Param;

public interface GoodsLocationMapper {
    int countByExample(GoodsLocationExample example);

    int deleteByExample(GoodsLocationExample example);

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(GoodsLocation record);

    int insertSelective(GoodsLocation record);

    List<GoodsLocation> selectByExample(GoodsLocationExample example);

    GoodsLocation selectByPrimaryKey(@Param("id") String id);

    int updateByExampleSelective(@Param("record") GoodsLocation record, @Param("example") GoodsLocationExample example);

    int updateByExample(@Param("record") GoodsLocation record, @Param("example") GoodsLocationExample example);

    int updateByPrimaryKeySelective(GoodsLocation record);

    int updateByPrimaryKey(GoodsLocation record);

    List<GoodsLocation> selectPageList(Page page);

    int selectPageCount(Page page);

    List<GoodsLocation> selectAll();
}