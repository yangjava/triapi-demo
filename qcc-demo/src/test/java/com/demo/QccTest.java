package com.demo;

import com.common.result.ResultT;
import com.demo.request.CompanyVerifyRequest;
import com.demo.response.CompanyVerifyResponse;
import com.demo.service.QccVerifyCompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QccTest {
    private static Logger LOG= LoggerFactory.getLogger(QccVerifyCompanyService.class);
    @Autowired
    QccVerifyCompanyService qccVerifyCompanyService;

    @Test
    public void test(){
        CompanyVerifyRequest company=new CompanyVerifyRequest();
        company.setCompanyName("小米科技有限责任公司");
        company.setRegNo("110108012660422");
        company.setFrName("雷军");
        ResultT<CompanyVerifyResponse> companyReponseResultT = qccVerifyCompanyService.verifyCompany(company);
        LOG.info("companyReponseResultT:{}",companyReponseResultT);
    }

}
