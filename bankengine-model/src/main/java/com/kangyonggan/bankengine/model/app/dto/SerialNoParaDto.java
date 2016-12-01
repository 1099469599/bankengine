package com.kangyonggan.bankengine.model.app.dto;

import com.kangyonggan.bankengine.model.BaseObject;
import lombok.Data;

/**
 * 生成银行指令流水号参数
 *
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public class SerialNoParaDto extends BaseObject {

    private String capitalType;

    private String bankNo;

    private String fundId;
}
