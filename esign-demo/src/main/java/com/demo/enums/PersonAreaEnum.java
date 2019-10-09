package com.demo.enums;

/**
 * 0-大陆，
 * 1-香港，
 * 2-澳门，
 * 3-台湾，
 * 4-外籍
 */
public enum PersonAreaEnum {

    MAINLAND(0),
    HONG_KONG(1),
    MACAU(2),
    TAIWAN(3),
    FOREIG (4);
    private int code;

    PersonAreaEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }}
