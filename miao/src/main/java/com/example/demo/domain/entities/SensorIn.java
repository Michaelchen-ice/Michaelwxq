package com.example.demo.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SensorIn {


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date time;
    private double humi_in;
    private double temp_in;
    private int id;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getHumi_in() {
        return humi_in;
    }

    public void setHumi_in(double humi_in) {
        this.humi_in = humi_in;
    }

    public double getTemp_in() {
        return temp_in;
    }

    public void setTemp_in(double temp_in) {
        this.temp_in = temp_in;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
