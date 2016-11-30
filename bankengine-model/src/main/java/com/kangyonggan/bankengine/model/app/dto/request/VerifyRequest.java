package com.kangyonggan.bankengine.model.app.dto.request;

import com.kangyonggan.bankengine.model.BaseObject;
import com.kangyonggan.bankengine.model.constants.Accptmd;
import lombok.Data;

/**
 * 鉴权请求
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
@Data
public class VerifyRequest extends BaseObject {

    /**
     * 银行代码
     */
    private String bankNo;

    /**
     * 业务类型
     */
    private String appKind;

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
     * 证件号码
     */
    private String idNo;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 受理方式
     */
    private Accptmd accptmd;

    /**
     * 银行发送短信流水
     */
    private String bankSmsSeq;

    /**
     * 短信验证码
     */
    private String authCode;

}
