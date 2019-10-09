package com.demo.utils;

import com.common.result.ResultHelper;
import com.common.result.ResultT;
import com.demo.request.OrganizeAccountRequest;
import com.demo.request.PersonAccountRequest;
import com.timevale.esign.sdk.tech.bean.OrganizeBean;
import com.timevale.esign.sdk.tech.bean.PersonBean;
import com.timevale.esign.sdk.tech.bean.result.AddAccountResult;
import com.timevale.esign.sdk.tech.impl.constants.OrganRegType;
import com.timevale.esign.sdk.tech.service.AccountService;
import com.timevale.esign.sdk.tech.service.factory.AccountServiceFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EsignAccountUtils {

    private static final Logger LOG = LoggerFactory.getLogger(EsignAccountUtils.class);

    public static ResultT<String> addPersonAccount(PersonAccountRequest personAccountRequest) {
        LOG.info("addPersonAccount personAccount name:{},idCardNo:{}", personAccountRequest.getName(), personAccountRequest.getIdNo());
        PersonBean personBean = new PersonBean();
        personBean.setName(personAccountRequest.getName());
        personBean.setIdNo(personAccountRequest.getIdNo());
        personBean.setPersonArea(personAccountRequest.getPersonArea());
        AccountService accountService = AccountServiceFactory.instance();
        AddAccountResult addAccountResult = accountService.addAccount(personBean);
        if (0 != addAccountResult.getErrCode()) {
            return
                    ResultHelper.fail("xxx", "创建个人账户失败");
        }
        return ResultHelper.success(addAccountResult.getAccountId());
    }

    public static ResultT<String> addOrganizeAccount(OrganizeAccountRequest organizeAccountRequest) {
        OrganizeBean organizeBean = new OrganizeBean();
        organizeBean.setName(organizeAccountRequest.getName());
        organizeBean.setOrganType(organizeAccountRequest.getOrganType());
        organizeBean.setOrganCode(organizeAccountRequest.getOrganCode());
        organizeBean.setUserType(organizeAccountRequest.getUserType());
        organizeBean.setAgentName(organizeAccountRequest.getAgentName());
        organizeBean.setAgentIdNo(organizeAccountRequest.getAgentIdNo());
        organizeBean.setLegalName(organizeAccountRequest.getLegalName());
        organizeBean.setLegalIdNo(organizeAccountRequest.getLegalIdNo());
        organizeBean.setLegalArea(organizeAccountRequest.getLegalArea());
        if (StringUtils.isNotBlank(organizeAccountRequest.getOrganCode())) {
            if (organizeAccountRequest.getOrganCode().length() == 9) {
                organizeBean.setRegType(OrganRegType.NORMAL);
            }
            if (organizeAccountRequest.getOrganCode().length() == 15) {
                organizeBean.setRegType(OrganRegType.REGCODE);
            }
            if (organizeAccountRequest.getOrganCode().length() == 18) {
                organizeBean.setRegType(OrganRegType.MERGE);
            }
        }
        AccountService accountService = AccountServiceFactory.instance();
        AddAccountResult addAccountResult = accountService.addAccount(organizeBean);
        if (0 != addAccountResult.getErrCode()) {
            return ResultHelper.fail("xxx", "创建个人账户失败");
        }
        return ResultHelper.success(addAccountResult.getAccountId());
    }
}
