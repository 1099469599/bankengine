package com.kangyonggan.bankengine.biz.service.impl;

import com.kangyonggan.bankengine.biz.service.BankMerchantService;
import com.kangyonggan.bankengine.biz.service.BankTranService;
import com.kangyonggan.bankengine.model.app.BankSetting;
import com.kangyonggan.bankengine.model.app.exception.BankSettingException;
import com.kangyonggan.bankengine.model.app.vo.BankMerchant;
import com.kangyonggan.bankengine.model.app.vo.BankTran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Service
public class SettingInDbHelper {

    @Autowired
    private BankMerchantService bankMerchantService;

    @Autowired
    private BankTranService bankTranService;

    /**
     * 为BE对外接口服务抓取必要的银行设定
     * <p>
     * 该方法一定程度上代替了存储过程IBP_GET_BANKPAYMENT_PRE
     *
     * @param bankNo      银行编号
     * @param routeCode   通道代码
     * @param merTranCode 商户交易代号
     * @param protocolNo  客户协议号
     * @return
     * @throws BankSettingException 如果对应的银行设定没有配置，会抛出异常
     */
    public BankSetting getBankSetting(final String bankNo, final String routeCode, final String capitalMode,
                                      final String merTranCode, final String protocolNo) throws BankSettingException {
        BankSetting bankSetting = new BankSetting();

        // 设定商户信息
        BankMerchant bankMerchant = bankMerchantService.findBankMerchantByBankNo(bankNo);
        if (bankMerchant == null) {
            throw new BankSettingException("801", "BANK_MERBASE没有设定银行信息,bankNo:" + bankNo);
        } else {
            bankSetting.setBankMerchant(bankMerchant);
        }

        // 设定交易代码对应关系
        BankTran bankTran = bankTranService.findBankTranByBankNoAndMerTranCode(bankNo, merTranCode);
        if (bankTran == null) {
            throw new BankSettingException("802", "BANK_TRAN没有设定银行信息,bankNo:" + bankNo);
        } else {
            bankSetting.setBankTran(bankTran);
        }

        return bankSetting;
    }

}
