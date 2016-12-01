package com.kangyonggan.bankengine.biz.service;

import com.kangyonggan.bankengine.model.app.vo.BankCommand;

/**
 * 对BANKCOMMAND表的操作方法
 *
 * @author kangyonggan
 * @since 2016/12/1
 */
public interface BankCommandService {

    /**
     * 根据流水号获取银行指令
     *
     * @param serialNo 流水号
     * @return 银行指令实体
     */
    BankCommand findBankCommandBySerialNo(String serialNo);

}
