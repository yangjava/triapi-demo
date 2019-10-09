package com.demo.client;

import com.common.result.ResultT;
import com.demo.request.OrganizeAccountRequest;
import com.demo.request.PersonAccountRequest;
import com.demo.utils.EsignAccountUtils;
import com.demo.utils.EsignInitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * esign客户端
 */
public class EsignClient {

    private static final Logger LOG = LoggerFactory.getLogger(EsignClient.class);

    /**
     * 初始化
     */
    static {
        EsignInitUtils.init();
    }

    public static  ResultT<String> addPersonAccount(PersonAccountRequest personAccountRequest){
        return EsignAccountUtils.addPersonAccount(personAccountRequest);
    }

    public static  ResultT<String> addOrganizeAccount(OrganizeAccountRequest organizeAccountRequest){
        return EsignAccountUtils.addOrganizeAccount(organizeAccountRequest);
    }

}
