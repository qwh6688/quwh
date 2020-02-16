package com.citydo.quwh.dao;

import com.citydo.quwh.domain.EvtOverview;

public interface EvtOverviewMapper {
    int insert(EvtOverview record);

    int insertSelective(EvtOverview record);
}