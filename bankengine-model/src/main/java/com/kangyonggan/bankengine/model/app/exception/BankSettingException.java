package com.kangyonggan.bankengine.model.app.exception;

import lombok.Data;

/**
 * 有关银行设定相关的异常。这应该不提供给外部系统
 *
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public class BankSettingException extends Exception {

    private final String exceptionCode;

    private final String exceptionMessage;

    public BankSettingException(final String exceptionCode, final String exceptionMessage){
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }
}
