package com.demo.client;

import com.alibaba.fastjson.JSON;
import com.demo.config.QccConfig;
import com.demo.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Map;
@Service
public class QccClient {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    QccConfig qccConfig;

    public <T> ResponseEntity<T> get(String url,
                                     Class<T> responseType, Map<String, String> uriVariables){
        HttpHeaders headers = new HttpHeaders();
        String timeSpan= String.valueOf(Instant.now().getEpochSecond());
        String token= MD5Utils.encryptWithCapital(qccConfig.getKey() + timeSpan + qccConfig.getSecret());
        headers.set("Timespan",timeSpan);
        headers.set("Token",token);
        uriVariables.put("key",qccConfig.getKey());
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<String>(headers),
                responseType,
                uriVariables);
    }

    public <T> T getResponse(String url,
                                     Class<T> responseType, Map<String, String> uriVariables){
        HttpHeaders headers = new HttpHeaders();
        String timeSpan= String.valueOf(Instant.now().getEpochSecond());
        String token= MD5Utils.encryptWithCapital(qccConfig.getKey() + timeSpan + qccConfig.getSecret());
        headers.set("Timespan",timeSpan);
        headers.set("Token",token);
        uriVariables.put("key",qccConfig.getKey());
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<String>(headers),
                String.class,
                uriVariables);
        return JSON.parseObject(response.getBody(), responseType);
    }
}
