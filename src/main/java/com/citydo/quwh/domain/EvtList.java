package com.citydo.quwh.domain;

import java.util.Date;

public class EvtList {
    private String id;

    private String beforeimage;

    private String categoryname;

    private String categoryname2;

    private String createdate;

    private String createid;

    private String createuser;

    private String donedate;

    private String eventcontent;

    private String gridname;

    private String latlng;

    private String opinion;

    private Date etlTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBeforeimage() {
        return beforeimage;
    }

    public void setBeforeimage(String beforeimage) {
        this.beforeimage = beforeimage == null ? null : beforeimage.trim();
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public String getCategoryname2() {
        return categoryname2;
    }

    public void setCategoryname2(String categoryname2) {
        this.categoryname2 = categoryname2 == null ? null : categoryname2.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getCreateid() {
        return createid;
    }

    public void setCreateid(String createid) {
        this.createid = createid == null ? null : createid.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public String getDonedate() {
        return donedate;
    }

    public void setDonedate(String donedate) {
        this.donedate = donedate == null ? null : donedate.trim();
    }

    public String getEventcontent() {
        return eventcontent;
    }

    public void setEventcontent(String eventcontent) {
        this.eventcontent = eventcontent == null ? null : eventcontent.trim();
    }

    public String getGridname() {
        return gridname;
    }

    public void setGridname(String gridname) {
        this.gridname = gridname == null ? null : gridname.trim();
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng == null ? null : latlng.trim();
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }

    public Date getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(Date etlTime) {
        this.etlTime = etlTime;
    }

    @Override
    public String toString() {
        return "EvtList{" +
                "id='" + id + '\'' +
                ", beforeimage='" + beforeimage + '\'' +
                ", categoryname='" + categoryname + '\'' +
                ", categoryname2='" + categoryname2 + '\'' +
                ", createdate='" + createdate + '\'' +
                ", createid='" + createid + '\'' +
                ", createuser='" + createuser + '\'' +
                ", donedate='" + donedate + '\'' +
                ", eventcontent='" + eventcontent + '\'' +
                ", gridname='" + gridname + '\'' +
                ", latlng='" + latlng + '\'' +
                ", opinion='" + opinion + '\'' +
                ", etlTime=" + etlTime +
                '}';
    }
}