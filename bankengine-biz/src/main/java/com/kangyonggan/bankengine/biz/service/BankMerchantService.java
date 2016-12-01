package com.kangyonggan.bankengine.biz.service;

import com.kangyonggan.bankengine.model.app.vo.BankMerchant;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
public interface BankMerchantService {

    /**
     * 获取商户基本信息
     *
     * @param bankNo
     * @return
     */
    BankMerchant findBankMerchantByBankNo(String bankNo);

}
