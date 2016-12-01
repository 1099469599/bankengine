package com.kangyonggan.bankengine.biz.service.impl;

import com.kangyonggan.bankengine.biz.service.BankCommandService;
import com.kangyonggan.bankengine.biz.service.RedisService;
import com.kangyonggan.bankengine.biz.util.CommonFunc;
import com.kangyonggan.bankengine.biz.util.DateUtils;
import com.kangyonggan.bankengine.mapper.BankCommandMapper;
import com.kangyonggan.bankengine.model.app.dto.SerialNoParaDto;
import com.kangyonggan.bankengine.model.app.vo.BankCommand;
import com.kangyonggan.bankengine.model.constants.AppConstants;
import com.kangyonggan.bankengine.model.constants.RedisKeyConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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

    @Autowired
    private BankCommandMapper bankCommandMapper;

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

    /**
     * 根据serialNo更新并获取银行指令
     *
     * @param serialNo
     * @return
     */
    @Override
    public BankCommand getBankCommandAfterUpdate(String serialNo) {
        try {
            // 锁序列
            String sn = genGeneralSerialNo("Q");

            // 更新银行指令并返回
            return this.updateBankCommandSync(serialNo, sn);
        } catch (Exception e) {
            log.error("查询数据库出错!", e);
        }

        return null;
    }

    /**
     * 更新银行指令
     *
     * @param serialNo
     * @param sn
     * @return
     */
    private BankCommand updateBankCommandSync(String serialNo, String sn) {
        // 先查询
        BankCommand bankCommand = findBankCommandBySerialNo(serialNo);

        // 设置要更新的字段
        bankCommand.setLockSt(sn);
        bankCommand.setRetryCounter(bankCommand.getRetryCounter() + 1);
        bankCommand.setMerDate(DateUtils.getCurrentDate());
        bankCommand.setMerTime(DateUtils.getCurrentTime());
        bankCommand.setLastTryDate(DateUtils.getCurrentDate());
        bankCommand.setLastTryTime(DateUtils.getCurrentTime());

        // 设置更新的条件
        Example example = new Example(BankCommand.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("serialNo", serialNo);
        criteria.andEqualTo("tranSt", "N");
        criteria.andEqualTo("lockSt", "N");

        // 执行更新
        bankCommandMapper.updateByExampleSelective(bankCommand, example);

        return bankCommand;
    }

    /**
     * 获取加锁编号
     *
     * @param prefix
     * @return
     */
    private String genGeneralSerialNo(String prefix) {
        return prefix + redisService.incr(RedisKeyConstants.KEY_BE_SN_LOCK);
    }
}
