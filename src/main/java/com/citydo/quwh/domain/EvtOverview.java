package com.citydo.quwh.domain;

import java.util.Date;

public class EvtOverview {
    private String eventnum;

    private String inProcessing;

    private String complete;

    private String yzf;

    private String closingRate;

    private Date etlTime;

    public String getEventnum() {
        return eventnum;
    }

    public void setEventnum(String eventnum) {
        this.eventnum = eventnum == null ? null : eventnum.trim();
    }

    public String getInProcessing() {
        return inProcessing;
    }

    public void setInProcessing(String inProcessing) {
        this.inProcessing = inProcessing == null ? null : inProcessing.trim();
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete == null ? null : complete.trim();
    }

    public String getYzf() {
        return yzf;
    }

    public void setYzf(String yzf) {
        this.yzf = yzf == null ? null : yzf.trim();
    }

    public String getClosingRate() {
        return closingRate;
    }

    public void setClosingRate(String closingRate) {
        this.closingRate = closingRate == null ? null : closingRate.trim();
    }

    public Date getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(Date etlTime) {
        this.etlTime = etlTime;
    }

    @Override
    public String toString() {
        return "EvtOverview{" +
                "eventnum='" + eventnum + '\'' +
                ", inProcessing='" + inProcessing + '\'' +
                ", complete='" + complete + '\'' +
                ", yzf='" + yzf + '\'' +
                ", closingRate='" + closingRate + '\'' +
                ", etlTime=" + etlTime +
                '}';
    }
}