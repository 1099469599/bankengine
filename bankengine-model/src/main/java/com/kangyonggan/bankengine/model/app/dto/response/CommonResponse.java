package com.kangyonggan.bankengine.model.app.dto.response;

import com.kangyonggan.bankengine.model.BaseObject;
import com.kangyonggan.bankengine.model.app.dto.exception.BankEngineException;
import com.kangyonggan.bankengine.model.constants.TransactionStatus;
import lombok.Data;

/**
 * @author kangyonggan
 * @since 2016/11/30
 */
@Data
public class CommonResponse extends BaseObject {

    protected BankEngineException bankEngineException;

    protected String serialNo;

    protected TransactionStatus transactionStatus;

    /**
     * 短信流水
     */
    protected String msgSerialNo;

}
