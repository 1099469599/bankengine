package com.kangyonggan.bankengine.model.app.dto.request;

import com.kangyonggan.bankengine.model.BaseObject;
import lombok.Data;

/**
 * 签约请求
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
@Data
public class SignRequest extends BaseObject {

    /**
     * 银行编码
     */
    private String bankNo;

    /**
     * 验证码
     */
    private String authCode;

    /**
     * 卡号
     */
    private String accountNo;

    /**
     * 姓名
     */
    private String accountName;

    /**
     * 证件类型
     */
    private String idType;

    /**
     * 证件号
     */
    private String idNo;

    /**
     * 鉴权流水号
     */
    private String verifySerialNo;

    /**
     * 协议号
     */
    private String protocolNo;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 交易帐号
     */
    private String tradeAcco;
}
