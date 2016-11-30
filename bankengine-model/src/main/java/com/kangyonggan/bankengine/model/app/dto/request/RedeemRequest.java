package com.kangyonggan.bankengine.model.app.dto.request;

import com.kangyonggan.bankengine.model.BaseObject;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 赎回请求
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
@Data
public class RedeemRequest extends BaseObject {

    private String bankNo;
    private String merTranCode;
    private String productId;
    private String productName;
    private String productType;
    private String currency;
    private BigDecimal amount;
    private String refAppNo;
    private String appKind;
    private String receiverBankNo;
    private String receiverAccountNo;
    private String receiverAccountName;
    private String receiverIdType;
    private String receiverIdNo;
    private String receiverCity;
    private String receiverProtocolNo;
    private String accountId;
    private String routeCode;
    private String capitalMode;
    private String huiLu;//汇路
    private String appSource;//参考BankCommand.appSource
    private Date currWorkingDate;
    private Date nextWorkingDate;
}
