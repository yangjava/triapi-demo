package com.demo;

import com.common.result.ResultT;
import com.demo.client.EsignClient;
import com.demo.config.EsignConfig;
import com.demo.request.OrganizeAccountRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EsignTest {

    private static Logger LOG = LoggerFactory.getLogger(EsignTest.class);

    @Autowired
    EsignConfig esignConfig;

    @Test
    public void testConfig() {
        String projectId = esignConfig.getProjectId();
        String projectSecret = esignConfig.getProjectSecret();
        LOG.info("esignConfig:{},{}", projectId, projectSecret);
    }

    @Test
    public void testAccount() {
        OrganizeAccountRequest organizeAccount1 = new OrganizeAccountRequest("天之云信息科技有限公司", "52227058XT51M4AL62", "艾利", "220301198705170035");
        ResultT<String> stringResultT = EsignClient.addOrganizeAccount(organizeAccount1);
        LOG.info("stringResultT:{}",stringResultT);
        OrganizeAccountRequest organizeAccount2 = new OrganizeAccountRequest("天之云信息科技有限公司", "52227058XT51M4AL62", "天云", "220301198705170019", 0);
        ResultT<String> stringResultT1 = EsignClient.addOrganizeAccount(organizeAccount2);
        LOG.info("stringResultT1:{}",stringResultT1);
    }
    @Test
    public void testSeal() {

    }
    @Test
    public void testSign(){

    }
}
