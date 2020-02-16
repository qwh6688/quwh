package com.citydo.quwh.domain;

import java.util.Date;

public class EvtAnalysis {
    private String count;

    private String key;

    private Date etlTime;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count == null ? null : count.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public Date getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(Date etlTime) {
        this.etlTime = etlTime;
    }

    @Override
    public String toString() {
        return "EvtAnalysis{" +
                "count='" + count + '\'' +
                ", key='" + key + '\'' +
                ", etlTime=" + etlTime +
                '}';
    }
}