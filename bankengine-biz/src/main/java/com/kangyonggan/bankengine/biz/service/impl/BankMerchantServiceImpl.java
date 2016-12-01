package com.kangyonggan.bankengine.biz.service.impl;

import com.kangyonggan.bankengine.biz.service.BankMerchantService;
import com.kangyonggan.bankengine.model.app.vo.BankMerchant;
import com.kangyonggan.bankengine.model.constants.AppConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Service
@Log4j2
public class BankMerchantServiceImpl extends BaseService<BankMerchant> implements BankMerchantService {

    @Override
    public BankMerchant findBankMerchantByBankNo(String bankNo) {
        BankMerchant bankMerchant = new BankMerchant();
        bankMerchant.setBnkNo(bankNo);
        bankMerchant.setIsDelete(AppConstants.IS_DELETED_NO);

        try {
            return super.selectOne(bankMerchant);
        } catch (Exception e) {
            log.error("查询商户基本信息出错：" + e);
            return null;
        }

    }
}
