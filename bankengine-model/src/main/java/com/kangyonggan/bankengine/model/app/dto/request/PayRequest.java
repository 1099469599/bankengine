package com.kangyonggan.bankengine.model.app.dto.request;

import com.kangyonggan.bankengine.model.BaseObject;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 申购请求
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
@Data
public class PayRequest extends BaseObject {

    private String bankNo;
    private String merTranCode;
    private String routeCode;
    private String capitalMode;
    private String productId;
    private String productName;
    private String currency;
    private BigDecimal amount;
    private String refAppNo;
    private String appKind;
    private String senderBankNo;
    private String senderAccountNo;
    private String senderAccountName;
    private String senderIdType;
    private String senderIdNo;
    private String senderProtocolNo;
    private String mobileNo;
    private Date currWorkingDate;
    private Date nextWorkingDate;
    private String accpTmd;
    private String authCode;

}
