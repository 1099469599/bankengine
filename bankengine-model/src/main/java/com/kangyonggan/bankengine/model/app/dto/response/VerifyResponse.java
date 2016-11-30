package com.kangyonggan.bankengine.model.app.dto.response;

import lombok.Data;

/**
 * 鉴权响应
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
@Data
public class VerifyResponse extends CommonResponse {

    /**
     * 验证码session
     */
    private String authCodeSessionId;

    /**
     * 用于B2C直接成功时设定
     */
    private String protocolNo;

    /**
     * 是否需要签约, 默认不需要调签约
     */
    private boolean needSign;

}
