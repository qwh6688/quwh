package com.citydo.quwh.dao;

import com.citydo.quwh.domain.EvtAnalysis;

public interface EvtAnalysisMapper {
    int insert(EvtAnalysis record);

    int insertSelective(EvtAnalysis record);
}