package com.example.demo.domain.entities;


import java.util.Date;

public class Information {

    private int id;
    private String sort;
    private int judge;
    private String infos;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getJudge() {
        return judge;
    }

    public void setJudge(int judge) {
        this.judge = judge;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", sort='" + sort + '\'' +
                ", judge=" + judge +
                ", infos='" + infos + '\'' +
                ", time=" + time +
                '}';
    }
}
