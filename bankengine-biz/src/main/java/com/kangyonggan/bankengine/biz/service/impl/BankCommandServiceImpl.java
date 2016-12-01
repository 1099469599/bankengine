package com.kangyonggan.bankengine.biz.service.impl;

import com.kangyonggan.bankengine.biz.service.BankCommandService;
import com.kangyonggan.bankengine.model.app.vo.BankCommand;
import com.kangyonggan.bankengine.model.constants.AppConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Service
@Log4j2
public class BankCommandServiceImpl extends BaseService<BankCommand> implements BankCommandService {

    @Override
    public BankCommand findBankCommandBySerialNo(String serialNo) {
        BankCommand bankCommand = new BankCommand();
        bankCommand.setSerialNo(serialNo);
        bankCommand.setIsDelete(AppConstants.IS_DELETED_NO);

        try {
            return super.selectOne(bankCommand);
        } catch (Exception e) {
            log.error("查询银行指令出错：" + e);
            return null;
        }
    }
}
