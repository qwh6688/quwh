package com.citydo.quwh.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.citydo.quwh.dao.EvtListMapper;

import com.citydo.quwh.domain.EvtList;
import com.citydo.quwh.util.GetUrlPostResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Iterator;

@Component
public class EvtListController {
    @Autowired
    private EvtListMapper evtListMapper;
    private static  String addr="http://172.21.188.223:19208/event/api/appCall";
    private String param="jsonParam={opeType: 'getAllEventList',map: {}}";
    private  int eventnum;


    @Scheduled(cron = "0 0/30 * * * ? ")
    public void sendPostRequest(){
        //第一次需要查询有多少个事件总数
        String resultJson = GetUrlPostResult.requestPostResult(addr, param);
        JSONObject parse = JSONObject.parseObject(resultJson);
        JSONObject data = parse.getJSONObject("data");
        eventnum = data.getInteger("eventnum");
        //第二次拉去全部数据，参数带上上一次请求获得的总数
        String allList="jsonParam={opeType: 'getAllEventList',map: {pageShow:'"+eventnum+"'}}";
        String resultList = GetUrlPostResult.requestPostResult(addr, allList);
        System.out.println("``````````````````````````````````````````````"+allList);
        JSONObject parseJson = JSONObject.parseObject(resultList);
        JSONObject data1 = parseJson.getJSONObject("data");
        //解析json数组
        JSONArray eventData = data1.getJSONArray("eventData");
        Iterator<Object> iterator = eventData.iterator();
        EvtList evtList=new EvtList();
        while (iterator.hasNext()){
            JSONObject next = (JSONObject)iterator.next();
            evtList.setId(next.getString("ID"));
            evtList.setBeforeimage(next.getString("beforeImage"));
            evtList.setCategoryname(next.getString("categoryName"));
            evtList.setCategoryname2(next.getString("categoryName2"));
            evtList.setCreatedate(next.getString("createDate"));
            evtList.setCreateid(next.getString("createId"));
            evtList.setCreateuser(next.getString("createUser"));
            evtList.setDonedate(next.getString("doneDate"));
            evtList.setEventcontent(next.getString("eventContent"));
            evtList.setGridname(next.getString("gridName"));
            evtList.setLatlng(next.getString("latLng"));
            evtList.setOpinion(next.getString("opinion"));
            evtList.setEtlTime(new Date());
            saveEvtList(evtList);
        }


    }

    private void saveEvtList(EvtList evtList) {
        evtListMapper.insert(evtList);
        System.out.println("_________________________________________________--"+evtList.toString());
    }


}
