package com.demo.request;

public class OrganizeAccountRequest {
    private String name;
    private int organType;
    private int userType;
    private String organCode;
    private String legalName;
    private String legalIdNo;
    private int legalArea;
    private String agentName;
    private String agentIdNo;

    public OrganizeAccountRequest(String name, String organCode, String legalName, String legalIdNo,int legalArea) {
        this.name = name;
        this.organType=0;
        this.userType=2;
        this.organCode = organCode;
        this.legalName = legalName;
        this.legalIdNo = legalIdNo;
        this.legalArea = legalArea;
    }

    public OrganizeAccountRequest(String name, String organCode, String agentName, String agentIdNo) {
        this.name = name;
        this.organType=0;
        this.userType=1;
        this.organCode = organCode;
        this.agentName = agentName;
        this.agentIdNo = agentIdNo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrganType() {
        return organType;
    }

    public void setOrganType(int organType) {
        this.organType = organType;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getLegalIdNo() {
        return legalIdNo;
    }

    public void setLegalIdNo(String legalIdNo) {
        this.legalIdNo = legalIdNo;
    }

    public int getLegalArea() {
        return legalArea;
    }

    public void setLegalArea(int legalArea) {
        this.legalArea = legalArea;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentIdNo() {
        return agentIdNo;
    }

    public void setAgentIdNo(String agentIdNo) {
        this.agentIdNo = agentIdNo;
    }
}
