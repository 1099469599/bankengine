package com.kangyonggan.bankengine.model.app.exception;

import lombok.Data;

/**
 * 仅提供银行引擎在产生、执行、回写银行指令的时候产生的程序异常。
 *
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public final class BankEngineServiceException extends Exception {

    private final String exceptionCode;

    private final String exceptionMessage;

    public BankEngineServiceException(final String exceptionCode, final String exceptionMessage) {
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }
}
