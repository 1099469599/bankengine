package com.kangyonggan.bankengine.biz.impl;

import com.kangyonggan.bankengine.model.app.dto.request.*;
import com.kangyonggan.bankengine.model.app.dto.response.*;
import com.kangyonggan.bankengine.service.BankEngineService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * 银行引擎对外服务接口的实现
 * 包括：
 * 1. 发短信
 * 2. 鉴权
 * 3. 签约
 * 4. 解约
 * 5. 申购
 * 6. 赎回
 * 7. 对账下载
 * 8. 对账导入
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
@Service("bankEngineService")
@Log4j2
public class BankEngineServiceImpl implements BankEngineService {

    /**
     * 发短信
     *
     * @param sendSmsRequest
     * @return
     */
    @Override
    public SendSmsResponse sendSms(SendSmsRequest sendSmsRequest) {
        return null;
    }

    /**
     * 鉴权
     *
     * @param verifyRequest
     * @return
     */
    @Override
    public VerifyResponse verify(VerifyRequest verifyRequest) {
        return null;
    }

    /**
     * 签约
     *
     * @param signRequest
     * @return
     */
    @Override
    public SignResponse sign(SignRequest signRequest) {
        return null;
    }

    /**
     * 申购
     *
     * @param payRequest
     * @return
     */
    @Override
    public PayResponse pay(PayRequest payRequest) {

        log.info("进入充值：" + payRequest);

        // 校验银行是否支持付款操作

        // 交易是否是重复交易(根据业务流水，判断当前交易之前是否曾经发起过)

        try {
            // 充值逻辑

        } catch (Exception e) {
            // 充值异常

        }

        // 监控埋点

        return null;
    }

    /**
     * 赎回
     *
     * @param redeemRequest
     * @return
     */
    @Override
    public RedeemResponse redeem(RedeemRequest redeemRequest) {
        return null;
    }

    /**
     * 对账下载
     *
     * @param dzRequest
     * @return
     */
    @Override
    public DzResponse downloadDZ(DzRequest dzRequest) {
        return null;
    }

    /**
     * 对账导入
     *
     * @param importRequest
     * @return
     */
    @Override
    public ImportResponse importEBankData(ImportRequest importRequest) {
        return null;
    }
}
