package com.demo.response;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.Serializable;

public class CompanyVerifyResponse implements Serializable {

    @JsonAlias("Status")
    private String status;
    @JsonAlias("Result")
    private String result;
    @JsonAlias("Message")
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CompanyReponse{" +
                "status='" + status + '\'' +
                ", result='" + result + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
