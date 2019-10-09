package com.common.result;

public class ResultHelper {

    public static <T> ResultT success(T data){
        return new ResultT(data);
    }

    public  static <T> ResultT fail(String code,String message){
        return new ResultT(code,message);
    }
}
