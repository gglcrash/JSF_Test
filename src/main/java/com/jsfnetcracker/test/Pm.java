package com.jsfnetcracker.test;

import java.sql.Date;

public class Pm {
    private int idPm;
    private String name;
    private String ip;
    private Date date;
    private String description;

    public int getId() {
        return idPm;
    }

    public void setId(int idPm) {
        this.idPm = idPm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
