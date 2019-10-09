package com.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EsignConfig {

    public static String projectId="";

    public static String projectSecret="";

    public static String url="";

    public  String getProjectId() {
        return projectId;
    }

    @Value("${esign.projectId}")
    public  void setProjectId(String projectId) {
        EsignConfig.projectId = projectId;
    }

    public  String getProjectSecret() {
        return projectSecret;
    }

    @Value("${esign.projectSecret}")
    public  void setProjectSecret(String projectSecret) {
        EsignConfig.projectSecret = projectSecret;
    }

    public  String getUrl() {
        return url;
    }

    @Value("${esign.url}")
    public  void setUrl(String url) {
        EsignConfig.url = url;
    }
}
