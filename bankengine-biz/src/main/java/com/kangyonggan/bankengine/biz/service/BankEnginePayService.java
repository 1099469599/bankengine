package com.kangyonggan.bankengine.biz.service;

import com.kangyonggan.bankengine.model.app.exception.BankEngineServiceException;
import com.kangyonggan.bankengine.model.app.dto.request.PayRequest;
import com.kangyonggan.bankengine.model.app.dto.response.PayResponse;

/**
 * 提供支付相关的服务。
 *
 * @author kangyonggan
 * @since 2016/12/1
 */
public interface BankEnginePayService {

    /**
     * 支付接口, 有可能抛出异常。
     *
     * @param payRequest 付款接口的请求参数
     * @return 包含银行指令的流水号和银行指令执行的返回结果。
     * @throws IllegalArgumentException payRequest不符合要求时会抛出异常
     * @throws BankEngineServiceException BE在写入/操作/执行银行指令错误时会抛出该异常
     */
    PayResponse payWithException(final PayRequest payRequest) throws IllegalArgumentException, BankEngineServiceException;

}
