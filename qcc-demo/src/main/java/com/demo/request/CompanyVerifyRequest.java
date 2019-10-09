package com.demo.request;

import java.io.Serializable;

public class CompanyVerifyRequest implements Serializable {
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 工商注册号
     */
    private String regNo;
    /**
     * 法人姓名
     */
    private String frName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getFrName() {
        return frName;
    }

    public void setFrName(String frName) {
        this.frName = frName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", regNo='" + regNo + '\'' +
                ", frName='" + frName + '\'' +
                '}';
    }
}
