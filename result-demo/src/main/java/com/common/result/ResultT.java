package com.common.result;

public class ResultT<T> {

    private Boolean isSuccess;

    private String code;

    private String message;

    private T data;

    public ResultT(T data) {
        this.isSuccess=true;
        this.data = data;
    }

    public ResultT(String code, String message) {
        this.isSuccess=false;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultT{" +
                "isSuccess=" + isSuccess +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
