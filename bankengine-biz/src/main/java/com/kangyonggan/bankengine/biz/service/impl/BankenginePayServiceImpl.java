package com.kangyonggan.bankengine.biz.service.impl;

import com.kangyonggan.bankengine.biz.service.BankEnginePayService;
import com.kangyonggan.bankengine.model.app.dto.exception.BankEngineServiceException;
import com.kangyonggan.bankengine.model.app.dto.request.PayRequest;
import com.kangyonggan.bankengine.model.app.dto.response.PayResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Service
@Log4j2
public class BankenginePayServiceImpl implements BankEnginePayService {

    /**
     * 支付接口, 有可能抛出异常。
     *
     * @param payRequest 付款接口的请求参数
     * @return 包含银行指令的流水号和银行指令执行的返回结果。
     * @throws IllegalArgumentException   payRequest不符合要求时会抛出异常
     * @throws BankEngineServiceException BE在写入/操作/执行银行指令错误时会抛出该异常
     */
    @Override
    public PayResponse payWithException(PayRequest payRequest) throws IllegalArgumentException, BankEngineServiceException {
        // TODO 充值逻辑
        log.info("充值逻辑");
        return new PayResponse();
    }

}
