package com.demo.utils;

import com.demo.config.EsignConfig;
import com.timevale.esign.sdk.tech.bean.result.Result;
import com.timevale.esign.sdk.tech.service.EsignsdkService;
import com.timevale.esign.sdk.tech.service.factory.EsignsdkServiceFactory;
import com.timevale.tech.sdk.bean.HttpConnectionConfig;
import com.timevale.tech.sdk.bean.ProjectConfig;
import com.timevale.tech.sdk.bean.SignatureConfig;
import com.timevale.tech.sdk.constants.AlgorithmType;
import com.timevale.tech.sdk.constants.HttpType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * esign项目初始化
 */
public class EsignInitUtils {

    private static final Logger LOG = LoggerFactory.getLogger(EsignInitUtils.class);

    public static void init(){
        ProjectConfig proCfg = new ProjectConfig();
        proCfg.setProjectId(EsignConfig.projectId);
        proCfg.setProjectSecret(EsignConfig.projectSecret);

        proCfg.setItsmApiUrl(EsignConfig.url);
        HttpConnectionConfig httpConCfg = new HttpConnectionConfig();
        httpConCfg.setHttpType(HttpType.HTTPS);
        httpConCfg.setRetry(5);
        SignatureConfig sCfg = new SignatureConfig();
        sCfg.setAlgorithm(AlgorithmType.HMACSHA256);
        sCfg.setEsignPublicKey("");
        sCfg.setPrivateKey("");
        EsignsdkService sdk = EsignsdkServiceFactory.instance();
        Result result = sdk.init(proCfg, httpConCfg, sCfg);
        if (0 != result.getErrCode()) {
            LOG.info("--项目初始化失败：errCode=" + result.getErrCode() + " msg=" + result.getMsg());
        } else {
            LOG.info("--项目初始化成功！errCode=" + result.getErrCode() + " msg=" + result.getMsg());
        }
    }
}
