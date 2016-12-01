package com.kangyonggan.bankengine.model.app.dto;

import com.kangyonggan.bankengine.model.BaseObject;
import com.kangyonggan.bankengine.model.app.exception.BankEngineServiceException;
import lombok.Data;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public class BankExecuteReturnDto extends BaseObject {

    private String commandType;
    private String commandStatus;
    private String httpType;
    private String B2CRedUrl;
    private String formbean;
    private BankEngineServiceException bankEngineServiceException;
    private String smsMsgId;
    private String bnkTranMsg;
    private String payStatus;
    private String errorMsg;
    private String protocolNo;
    private ResponsionDto respDto;
}
