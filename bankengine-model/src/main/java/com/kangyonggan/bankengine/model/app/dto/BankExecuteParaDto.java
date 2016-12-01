package com.kangyonggan.bankengine.model.app.dto;

import com.kangyonggan.bankengine.model.BaseObject;
import lombok.Data;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public class BankExecuteParaDto extends BaseObject {

    private String exeType;
    private String apKind;
    private String bnkNo;
    private String serialNo;
    private String capitalNo;

}
