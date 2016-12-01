package com.kangyonggan.bankengine.biz.service.impl;

import com.kangyonggan.bankengine.biz.service.BankCommandService;
import com.kangyonggan.bankengine.biz.service.ExecuteEngineService;
import com.kangyonggan.bankengine.model.app.Result;
import com.kangyonggan.bankengine.model.app.dto.BankExecuteParaDto;
import com.kangyonggan.bankengine.model.app.dto.BankExecuteReturnDto;
import com.kangyonggan.bankengine.model.app.dto.CommandDto;
import com.kangyonggan.bankengine.model.app.dto.ReturnDto;
import com.kangyonggan.bankengine.model.app.vo.BankCommand;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Service
@Log4j2
public class ExecuteEngineServiceImpl implements ExecuteEngineService {

    @Autowired
    private BankCommandService bankCommandService;

    @Override
    public Result<BankExecuteReturnDto> executeSync(BankExecuteParaDto para) {
        Result<BankExecuteReturnDto> result = new Result();
        log.info("银行同步指令执行:serialNo=" + para.getSerialNo());

        // 根据serialNo更新并获取银行指令
        CommandDto commandDto = getBankCommandAfterUpdate(para.getSerialNo());

        // 执行同步指令
        ReturnDto ret = CommandProcessor.executeSyn(commandDto, para.getBnkNo(), para.getSerialNo());

        // 获取银行返回对象
        BankExecuteReturnDto exeRet = getBankExecuteReturnDto(para.getBnkNo(), para.getApKind(), ret);

        // set BankEngineServiceException
        exeRet.setBankEngineServiceException(ret.getBankEngineServiceException());

        exeRet.setRespDto(ret.getResp());

        exeRet.setProtocolNo(ret.getProtocolNo());//协议号

        result.setModel(exeRet);
        result.setErrorCode(0); //新BE并没有使用这个栏位。

        return result;
    }

    /**
     * 获取银行返回对象
     *
     * @param bnkNo
     * @param apKind
     * @param ret
     * @return
     */
    private BankExecuteReturnDto getBankExecuteReturnDto(String bnkNo, String apKind, ReturnDto ret) {
        return null;
    }

    /**
     * 根据serialNo更新并获取银行指令
     * LOCK_ST从N改成Q+序列，重试次数＋1
     *
     * @param serialNo
     * @return
     */
    private CommandDto getBankCommandAfterUpdate(String serialNo) {
        CommandDto commandDto = null;

        try {
            BankCommand bankCommand = bankCommandService.getBankCommandAfterUpdate(serialNo);

            commandDto = BankEngineCommonHelper.bankCommand2CommonDto(bankCommand);
        } catch (Exception e) {
            log.error("（同步指令）读取指令异常", e);
        }
        log.info("（同步指令）读取指令完毕！");

        // 过滤空数据
        if (commandDto == null) {
            log.debug("（同步指令）指令为NULL，返回NULL。");
        }

        return commandDto;
    }

}
