package com.citydo.quwh.controller;


import com.alibaba.fastjson.JSONObject;
import com.citydo.quwh.dao.EvtOverviewMapper;

import com.citydo.quwh.domain.EvtOverview;
import com.citydo.quwh.util.GetUrlPostResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Date;


@Component
public class EvtOverviewController {
    @Autowired
    EvtOverviewMapper evtOverviewMapper;
    private static  String addr="http://172.21.188.223:19208/event/api/appCall";
    private String param="jsonParam={opeType: 'getEventCount',map: {}}";
    @Scheduled(cron = "0 0/30 * * * ? ")
    public void sendPostRequest(){
        String resultJson = GetUrlPostResult.requestPostResult(addr, param);
        JSONObject parse = JSONObject.parseObject(resultJson);
        JSONObject data = parse.getJSONObject("data");
        EvtOverview evtOverview = new EvtOverview();
        evtOverview.setEventnum(data.getString("eventnum"));
        evtOverview.setInProcessing(data.getString("wbl"));
        evtOverview.setComplete(data.getString("ybl"));
        evtOverview.setYzf(data.getString("yzf"));
        //计算办结率
        double a= Double.parseDouble(data.getString("eventnum"));
        double b= Double.parseDouble(data.getString("ybl"));
        DecimalFormat df = new DecimalFormat("0.0");
        String format = df.format(b / a * 100);
        evtOverview.setClosingRate(format);
        evtOverview.setEtlTime(new Date());
        //System.out.println("++++++++++++++++++++++++++++"+evtOverview.toString());
        saveEvtOverview(evtOverview);
    }

    private void saveEvtOverview(EvtOverview evtOverview) {
        evtOverviewMapper.insert(evtOverview);
    }







}
