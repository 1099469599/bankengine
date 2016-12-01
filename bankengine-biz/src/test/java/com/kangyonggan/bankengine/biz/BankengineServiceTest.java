package com.kangyonggan.bankengine.biz;

import com.kangyonggan.bankengine.biz.util.DateUtils;
import com.kangyonggan.bankengine.model.app.dto.request.PayRequest;
import com.kangyonggan.bankengine.model.constants.Accptmd;
import com.kangyonggan.bankengine.service.BankEngineService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        PayRequest request = new PayRequest();
        request.setAccpTmd(Accptmd.Mobile.getValue());
        request.setBankNo("605");
//        request.setRefAppNo(DateUtils.getCurrentFullDateTime());

        bankEngineService.pay(request);
    }

}
