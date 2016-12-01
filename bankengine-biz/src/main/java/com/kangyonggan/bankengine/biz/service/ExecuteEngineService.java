package com.kangyonggan.bankengine.biz.service;

import com.kangyonggan.bankengine.model.app.Result;
import com.kangyonggan.bankengine.model.app.dto.BankExecuteParaDto;
import com.kangyonggan.bankengine.model.app.dto.BankExecuteReturnDto;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
public interface ExecuteEngineService {

    /**
     * 银行指令执行服务
     *
     * @param para
     * @return
     */
    Result<BankExecuteReturnDto> executeSync(BankExecuteParaDto para);

}
