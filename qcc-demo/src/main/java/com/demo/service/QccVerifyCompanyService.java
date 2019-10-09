package com.demo.service;

import com.common.result.ResultHelper;
import com.common.result.ResultT;
import com.demo.client.QccClient;
import com.demo.request.CompanyVerifyRequest;
import com.demo.response.CompanyVerifyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QccVerifyCompanyService {

    private static Logger LOG= LoggerFactory.getLogger(QccVerifyCompanyService.class);

    @Autowired
    QccClient qccClient;

    public ResultT<CompanyVerifyResponse> verifyCompany(CompanyVerifyRequest company){
        LOG.info("企业实名认证接口company:{}",company);
        String url = "http://api.qichacha.com/ECIMatch/CompanyVerify?key={key}&regNo={regNo}&companyName={companyName}&frName={frName}";
        Map<String, String> params = new HashMap<>();
        params.put("regNo", company.getRegNo());
        params.put("companyName",company.getCompanyName());
        params.put("frName", company.getFrName());
        CompanyVerifyResponse companyReponse = qccClient.getResponse(url, CompanyVerifyResponse.class, params);
        Boolean flag="200".equals(companyReponse.getStatus())&&"查询成功".equals(companyReponse.getMessage())&&"一致".equals(companyReponse.getResult());
        if(flag){
            return ResultHelper.success(companyReponse);
        }else{
            return ResultHelper.fail(companyReponse.getStatus(),companyReponse.getResult());
        }

    }
}
