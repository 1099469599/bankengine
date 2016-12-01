package com.kangyonggan.bankengine.biz.service.impl;

import com.kangyonggan.bankengine.biz.service.BankCommandService;
import com.kangyonggan.bankengine.biz.service.RedisService;
import com.kangyonggan.bankengine.biz.util.CommonFunc;
import com.kangyonggan.bankengine.biz.util.DateUtils;
import com.kangyonggan.bankengine.model.app.dto.SerialNoParaDto;
import com.kangyonggan.bankengine.model.app.vo.BankCommand;
import com.kangyonggan.bankengine.model.constants.AppConstants;
import com.kangyonggan.bankengine.model.constants.RedisKeyConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 对BANKCOMMAND表的操作方法
 *
 * @author kangyonggan
 * @since 2016/12/1
 */
@Service
@Log4j2
public class BankCommandServiceImpl extends BaseService<BankCommand> implements BankCommandService {

    @Autowired
    private RedisService redisService;

    @Override
    public void saveBankCommand(BankCommand bankCommand) {
        try {
            super.insertSelective(bankCommand);
        } catch (Exception e) {
            log.error("银行指令落库异常", e);
        }
    }

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

    /**
     * 生成付款的序列号
     *
     * @param serialNoParaDto
     * @return
     */
    public String genPaySerialNoByNextVal(SerialNoParaDto serialNoParaDto) {
        String nextVal = String.valueOf(redisService.incr(RedisKeyConstants.KEY_BE_SN_COMMAND));
        String currentTime = DateUtils.getCurrentDate();

        return currentTime + CommonFunc.lpad(nextVal, 8, "0");
    }
}
