package com.kangyonggan.bankengine.biz.service;

import com.kangyonggan.bankengine.model.app.dto.CommandDto;
import com.kangyonggan.bankengine.model.app.dto.SerialNoParaDto;
import com.kangyonggan.bankengine.model.app.vo.BankCommand;

/**
 * 对BANKCOMMAND表的操作方法
 *
 * @author kangyonggan
 * @since 2016/12/1
 */
public interface BankCommandService {

    /**
     * 指令落库
     *
     * @param bankCommand
     */
    void saveBankCommand(BankCommand bankCommand);

    /**
     * 根据流水号获取银行指令
     *
     * @param serialNo 流水号
     * @return 银行指令实体
     */
    BankCommand findBankCommandBySerialNo(String serialNo);

    /**
     * 生成付款的序列号
     *
     * @param serialNoParaDto
     * @return
     */
    String genPaySerialNoByNextVal(SerialNoParaDto serialNoParaDto);

    /**
     * 根据serialNo更新并获取银行指令
     *
     * @param serialNo
     * @return
     */
    BankCommand getBankCommandAfterUpdate(String serialNo);

}
