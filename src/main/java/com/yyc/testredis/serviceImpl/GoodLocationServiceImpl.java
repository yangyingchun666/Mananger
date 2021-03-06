package com.yyc.testredis.serviceImpl;

import com.yyc.testredis.mapper.GoodsLocationMapper;
import com.yyc.testredis.pojo.GoodsLocation;
import com.yyc.testredis.service.GoodLocationService;
import com.yyc.testredis.utils.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GoodLocationServiceImpl implements GoodLocationService {
    @Autowired
    GoodsLocationMapper goodsLocationMapper;

    @Override
    public List<GoodsLocation> selectPageList(Page page) {
        return goodsLocationMapper.selectPageList(page);
    }

    @Override
    public int selectPageCount(Page page) {
        return goodsLocationMapper.selectPageCount(page);
    }

    @Override
    public List<GoodsLocation> selectAll() {
        return goodsLocationMapper.selectAll();
    }

    @Override
    public Integer insert(GoodsLocation goodsLocation) {
        return goodsLocationMapper.insertSelective(goodsLocation);
    }

    @Override
    public int delete(String id) {
        return goodsLocationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(GoodsLocation goodsLocation) {
        return goodsLocationMapper.updateByPrimaryKeySelective(goodsLocation);
    }

    @Override
    public GoodsLocation selectById(String id) {
        return goodsLocationMapper.selectByPrimaryKey(id);
    }
}
