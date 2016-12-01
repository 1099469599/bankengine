package com.kangyonggan.bankengine.biz.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 校验银行是否支持操作
 *
 * @author kangyonggan
 * @since 2016/12/1
 */
@Service
@Log4j2
public class OperationChecker {

    /**
     * 校验银行是否支持付款操作
     *
     * @param bankNo
     * @param accptmd
     * @return
     */
//    @Cacheable(value = "checkIfCanPay", key = "'bankNo_' + #bankNo + 'accptmd_' + #accptmd")
    public boolean checkIfCanPay(String bankNo, String accptmd) {
        log.info("校验银行是否支持付款操作:bankNo={}, accptmd={}", bankNo, accptmd);
        // TODO
        return true;
    }

}
