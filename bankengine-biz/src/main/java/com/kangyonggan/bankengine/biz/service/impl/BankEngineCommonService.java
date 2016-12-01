package com.kangyonggan.bankengine.biz.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 为银行引擎接口提供公共的服务
 *
 * @author kangyonggan
 * @since 2016/12/1
 */
@Service
public class BankEngineCommonService {

    /**
     * 根据业务流水(前置系统流水)，判断当前交易之前是否曾经发起过
     *
     * @param refAppNo
     * @return
     */
    public boolean isRepeatedTrade(String refAppNo) {
        // 不允许有空的业务流水
        if (StringUtils.isEmpty(refAppNo)) {
            return true;
        }

        // 根据业务申请编号获取银行指令
        // TODO
        return false;
    }
}
