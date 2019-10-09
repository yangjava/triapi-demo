package com.demo.utils;

import com.common.result.ResultHelper;
import com.common.result.ResultT;
import com.demo.request.Seal;
import com.timevale.esign.sdk.tech.bean.result.AddSealResult;
import com.timevale.esign.sdk.tech.bean.seal.OrganizeTemplateType;
import com.timevale.esign.sdk.tech.bean.seal.PersonTemplateType;
import com.timevale.esign.sdk.tech.bean.seal.SealColor;
import com.timevale.esign.sdk.tech.service.SealService;
import com.timevale.esign.sdk.tech.service.factory.SealServiceFactory;

public class EsignSealUtils {
    /**
     * 创建个人账户印章
     * @param seal
     * @return
     */
    public static ResultT<String> addPersonTemplateSeal(Seal seal){
        // 印章模板类型：矩形印章
        PersonTemplateType personTemplateType = PersonTemplateType.RECTANGLE;
        // 印章颜色：红色
        SealColor sealColor = SealColor.RED;
        SealService sealService = SealServiceFactory.instance();
        AddSealResult addSealResult = sealService.addTemplateSeal(seal.getAccountId(), personTemplateType, sealColor);
        if (0 != addSealResult.getErrCode()) {
            return
            ResultHelper.fail("xxx", "创建个人模板印章失败");
        }
        return ResultHelper.success(addSealResult.getSealData());
    }

    /***
     * 创建企业账户的印章
     */
    public static ResultT<String> addOrganizeTemplateSeal(Seal seal) {
        // 印章模板类型：矩形印章
        OrganizeTemplateType organizeTemplateType = OrganizeTemplateType.STAR;
        // 印章颜色：红色
        SealColor sealColor = SealColor.RED;
        SealService sealService = SealServiceFactory.instance();
        AddSealResult addSealResult = sealService.addTemplateSeal(seal.getAccountId(), organizeTemplateType, sealColor, seal.gethText(),
                seal.getqText());
        if (0 != addSealResult.getErrCode()) {
            return  ResultHelper.fail("xxx", "创建个人模板印章失败");
        }
        return ResultHelper.success(addSealResult.getSealData());
    }
}
