package com.demo.utils;


import com.common.result.ResultHelper;
import com.common.result.ResultT;
import com.demo.request.SealPos;
import com.timevale.esign.sdk.tech.bean.PosBean;
import com.timevale.esign.sdk.tech.bean.SignPDFStreamBean;
import com.timevale.esign.sdk.tech.bean.result.FileDigestSignResult;
import com.timevale.esign.sdk.tech.impl.constants.SignType;
import com.timevale.esign.sdk.tech.service.UserSignService;
import com.timevale.esign.sdk.tech.service.factory.UserSignServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EsignUtils {

    private static final Logger LOG = LoggerFactory.getLogger(EsignUtils.class);


    /**
     *  平台自身 PDF 摘要签署（文件流&印章图片）
     * @param pdfFileStream
     * @param accountId
     * @param sealData
     * @param sealPos
     * @return
     */
    public static ResultT<FileDigestSignResult> localSignPDF(byte[] pdfFileStream, String accountId,
                                                             String sealData, SealPos sealPos){
        SignPDFStreamBean signPDFStreamBean = new SignPDFStreamBean();
        signPDFStreamBean.setStream(pdfFileStream);
        PosBean posBean = new PosBean();
        posBean.setPosType(1);
        posBean.setKey(sealPos.getKey());
        posBean.setPosX(sealPos.getPosX());
        posBean.setPosY(sealPos.getPosY());
        posBean.setWidth(sealPos.getWidth());
        SignType signType = SignType.Key;
        UserSignService userSignService = UserSignServiceFactory.instance();
        FileDigestSignResult fileDigestSignResult = userSignService.localSignPDF(accountId, sealData, signPDFStreamBean,
                posBean, signType);

        if (0 != fileDigestSignResult.getErrCode()) {
            return ResultHelper.fail("xxx", "创建个人模板印章失败");
        }
        return ResultHelper.success(fileDigestSignResult);
    }

}
