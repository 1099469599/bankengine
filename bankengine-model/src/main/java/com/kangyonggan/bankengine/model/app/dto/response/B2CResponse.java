package com.kangyonggan.bankengine.model.app.dto.response;

import com.kangyonggan.bankengine.model.app.CommandHttpType;
import lombok.Data;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public class B2CResponse extends CommonResponse {

    private String returnUrl;
    private String formBean;
    private CommandHttpType commandHttpType;

}
