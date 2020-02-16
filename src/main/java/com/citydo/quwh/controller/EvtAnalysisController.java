package com.citydo.quwh.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.citydo.quwh.dao.EvtAnalysisMapper;
import com.citydo.quwh.domain.EvtAnalysis;
import com.citydo.quwh.util.GetUrlPostResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Iterator;

@Component
public class EvtAnalysisController {
    //这个错误不用管，idea本身的错误
    @Autowired
    private EvtAnalysisMapper evtAnalysisMapper;
    private static  String addr="http://172.21.188.223:19208/event/api/appCall";
    private String param="jsonParam={opeType: 'getCountByCate',map: {}}";
    @Scheduled(cron = "0 0/30 * * * ? ")
    public void sendPostRequest(){
        String resultJson = GetUrlPostResult.requestPostResult(addr, param);
        JSONObject parse = JSONObject.parseObject(resultJson);
        JSONArray eventData = parse.getJSONArray("data");
        Iterator<Object> iterator = eventData.iterator();
        EvtAnalysis evtAnalysis=new EvtAnalysis();
        while (iterator.hasNext()){
            JSONObject next = (JSONObject)iterator.next();
            evtAnalysis.setCount(next.getString("count"));
            evtAnalysis.setKey(next.getString("key"));
            evtAnalysis.setEtlTime(new Date());
            saveEvtAnalysis(evtAnalysis);
        }

    }

    private void saveEvtAnalysis(EvtAnalysis evtAnalysis) {
        evtAnalysisMapper.insert(evtAnalysis);
    }






}
