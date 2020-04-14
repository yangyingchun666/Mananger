package com.yyc.testredis.serviceImpl;

import com.yyc.testredis.mapper.BannerMapper;
import com.yyc.testredis.pojo.Banner;
import com.yyc.testredis.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<Banner> selectAll() {
        return bannerMapper.selectAll();
    }
}
