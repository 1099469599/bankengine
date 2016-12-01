package com.kangyonggan.bankengine.model.app.dto;

import com.kangyonggan.bankengine.model.BaseObject;
import lombok.Data;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public class TransactionStatusDto extends BaseObject {
    private String serialNo;     //序列号
    private String bnkNo;        //银行编号
    private String tranSt;       //操作状态
    private String merRespCo;    //商户响应编码
    private String merRespMsg;   //商户响应信息

    private String resultCode; //返回代码
    private String resultMessage; //返回信息
}
