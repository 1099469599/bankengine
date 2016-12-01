package com.kangyonggan.bankengine.model.app.dto.exception;

import com.kangyonggan.bankengine.model.BaseObject;
import lombok.Data;

/**
 * 记录银行指令执行异常和银行返回的异常信息
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
@Data
public class BankEngineException extends BaseObject {

    /**
     * 银行指令执行异常
     */
    private String exceptionCode;
    private String exceptionMessage;

    /**
     * 银行返回的错误代码
     */
    private String bankErrorCode;
    private String bankErrorMessage;

    /**
     * 商户返回的错误代码
     */
    private String merchantErrorCode;
    private String merchantErrorMessage;

}
