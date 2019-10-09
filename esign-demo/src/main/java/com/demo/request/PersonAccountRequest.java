package com.demo.request;

import com.demo.enums.PersonAreaEnum;

public class PersonAccountRequest {

    private String idNo;
    /**
     * 0-大陆，
     * 1-香港，
     * 2-澳门，
     * 3-台湾，
     * 4-外籍
     */
    private int personArea;
    private String name;

    public PersonAccountRequest() {
    }
    public PersonAccountRequest(String idNo, int personArea, String name) {
        this.idNo = idNo;
        this.personArea = personArea;
        this.name = name;
    }

    public PersonAccountRequest(String idNo, String name) {
        this.idNo = idNo;
        this.personArea = PersonAreaEnum.MAINLAND.getCode();
        this.name = name;
    }
    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public int getPersonArea() {
        return personArea;
    }

    public void setPersonArea(int personArea) {
        this.personArea = personArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
