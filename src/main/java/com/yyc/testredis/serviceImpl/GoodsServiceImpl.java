package com.yyc.testredis.serviceImpl;

import com.yyc.testredis.mapper.GoodsMapper;
import com.yyc.testredis.pojo.Goods;
import com.yyc.testredis.service.GoodsService;
import com.yyc.testredis.utils.Page;
import com.yyc.testredis.vo.GoodsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectPageList(Page page) {
        return goodsMapper.selectPageList(page);
    }

    @Override
    public int selectPageCount(Page page) {
        return goodsMapper.selectPageCount(page);
    }
}
