package com.kangyonggan.bankengine.biz.service;

import com.kangyonggan.bankengine.model.app.vo.BankTran;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
public interface BankTranService {

    /**
     * 获取交易代码对应关系表
     *
     * @param bankNo
     * @param merTranCode
     * @return
     */
    BankTran findBankTranByBankNoAndMerTranCode(String bankNo, String merTranCode);

}
