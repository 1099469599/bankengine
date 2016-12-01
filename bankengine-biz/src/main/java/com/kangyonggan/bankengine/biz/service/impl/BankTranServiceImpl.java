package com.kangyonggan.bankengine.biz.service.impl;

import com.kangyonggan.bankengine.biz.service.BankTranService;
import com.kangyonggan.bankengine.model.app.vo.BankTran;
import com.kangyonggan.bankengine.model.constants.AppConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Service
@Log4j2
public class BankTranServiceImpl extends BaseService<BankTran> implements BankTranService {

    @Override
    public BankTran findBankTranByBankNoAndMerTranCode(String bankNo, String merTranCode) {
        BankTran bankTran = new BankTran();
        bankTran.setBnkNo(bankNo);
        bankTran.setMerTranCo(merTranCode);
        bankTran.setIsDelete(AppConstants.IS_DELETED_NO);

        try {
            return super.selectOne(bankTran);
        } catch (Exception e) {
            log.error("查询交易代码异常", e);
            return null;
        }

    }
}
