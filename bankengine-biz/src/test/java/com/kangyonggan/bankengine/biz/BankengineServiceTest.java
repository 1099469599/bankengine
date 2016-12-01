package com.kangyonggan.bankengine.biz;

import com.kangyonggan.bankengine.biz.util.DateUtils;
import com.kangyonggan.bankengine.model.app.dto.request.PayRequest;
import com.kangyonggan.bankengine.model.constants.Accptmd;
import com.kangyonggan.bankengine.service.BankEngineService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author kangyonggan
 * @since 2016/11/30
 */
public class BankengineServiceTest extends AbstractServiceTest {

    @Autowired
    private BankEngineService bankEngineService;

    @Test
    public void testBankEngineService() {
        log.debug(bankEngineService);
    }

    /**
     * 测试申购
     */
    @Test
    public void testPay() {
        PayRequest payRequest = new PayRequest();
        payRequest.setBankNo("618");

        payRequest.setSenderAccountName("测试客户3006186035");
        payRequest.setSenderAccountNo("620522201000017606");

        payRequest.setSenderIdType("0");//身份证
        payRequest.setSenderIdNo("320681198511254646");
        payRequest.setMobileNo("13851903765");
        payRequest.setAmount(BigDecimal.valueOf(0.23));
        payRequest.setSenderProtocolNo("20161111100004229413");

        payRequest.setAccpTmd(Accptmd.Mobile.getValue());
        payRequest.setRefAppNo(DateUtils.getCurrentFullDateTime());
        payRequest.setMerTranCode("01");
        payRequest.setCurrWorkingDate(new Date());
        payRequest.setAppKind("022");

        bankEngineService.pay(payRequest);
    }

}
