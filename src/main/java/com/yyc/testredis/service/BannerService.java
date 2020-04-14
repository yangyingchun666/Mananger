package com.yyc.testredis.service;

import com.yyc.testredis.pojo.Banner;

import java.util.List;

public interface BannerService {
    List<Banner> selectAll();
}
