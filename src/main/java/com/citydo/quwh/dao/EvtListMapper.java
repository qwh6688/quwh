package com.citydo.quwh.dao;

import com.citydo.quwh.domain.EvtList;

public interface EvtListMapper {
    int insert(EvtList record);

    int insertSelective(EvtList record);
}