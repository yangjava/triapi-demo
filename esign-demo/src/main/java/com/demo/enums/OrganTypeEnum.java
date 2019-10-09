package com.demo.enums;

/**
 * 单位类型，0-普通企业，1-社会团体，2-事业单位，3-民办非企业单位，4-党政及国家机构，默认0
 */
public enum OrganTypeEnum {

    MAINLAND(0),
    HONG_KONG(1),
    MACAU(2),
    TAIWAN(3),
    FOREIG (4);
    private int code;

    OrganTypeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
