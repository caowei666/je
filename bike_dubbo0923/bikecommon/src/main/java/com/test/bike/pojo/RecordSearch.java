package com.test.bike.pojo;

import java.util.Date;

public class RecordSearch extends Record {
    private Date start;
    private Date end;
    private Integer platId;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getPlatId() {
        return platId;
    }

    public void setPlatId(Integer platId) {
        this.platId = platId;
    }
}
