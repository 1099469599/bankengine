package com.kangyonggan.bankengine.biz.impl;

import com.kangyonggan.bankengine.biz.service.BankEnginePayService;
import com.kangyonggan.bankengine.biz.service.impl.BankEngineCommonService;
import com.kangyonggan.bankengine.biz.service.impl.OperationChecker;
import com.kangyonggan.bankengine.model.app.dto.request.*;
import com.kangyonggan.bankengine.model.app.dto.response.*;
import com.kangyonggan.bankengine.model.constants.CommonErrors;
import com.kangyonggan.bankengine.model.constants.TransactionStatus;
import com.kangyonggan.bankengine.service.BankEngineService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private OperationChecker operationChecker;

    @Autowired
    private BankEngineCommonService bankEngineCommonService;

    @Autowired
    private BankEnginePayService bankEnginePayService;

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
        PayResponse response = new PayResponse();

        // 校验银行是否支持付款操作
        boolean checkIfCanPay = operationChecker.checkIfCanPay(payRequest.getBankNo(), payRequest.getAccpTmd());
        if (!checkIfCanPay) {
            BankEnginecommonHelper.generateSimpleResponse(response, TransactionStatus.F, CommonErrors.NotSupportTran.getCode(), "该银行通道目前暂停支付!");
            log.info("通道暂停支付！");
            return response;
        }

        // 交易是否是重复交易(根据业务流水，判断当前交易之前是否曾经发起过)
        boolean isRepeatedTrade = bankEngineCommonService.isRepeatedTrade(payRequest.getRefAppNo());
        if (isRepeatedTrade) {
            BankEnginecommonHelper.generateSimpleResponse(response, TransactionStatus.F, CommonErrors.NotSupportTran.getCode(), "不可发起重复交易!");
            log.info("重复支付交易！");
            return response;
        }

        Map<String, String> result = new HashMap();
        try {
            // 充值逻辑
            response = bankEnginePayService.payWithException(payRequest);
        } catch (Exception e) {
            // 捕获异常
            result = BankEnginecommonHelper.handleException(payRequest, e, log);
        }

        BankEnginecommonHelper.generateServiceResponse(response, result.get("errCode"), result.get("errMsg"));

        return response;
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
