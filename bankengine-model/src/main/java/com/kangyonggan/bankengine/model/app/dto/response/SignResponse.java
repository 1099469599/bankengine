package com.kangyonggan.bankengine.model.app.dto.response;

import lombok.Data;

/**
 * 签约响应
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
@Data
public class SignResponse extends CommonResponse {

    /**
     * 协议号
     */
    private String protocolNo;

}
