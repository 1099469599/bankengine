package com.kangyonggan.bankengine.model.app.dto;

import com.kangyonggan.bankengine.model.BaseObject;
import com.kangyonggan.bankengine.model.app.vo.BankCardBin;
import lombok.Data;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public class ResponsionDto extends BaseObject {

    private String responsionNo;  //应答编号
    private String sequenceNo;    //序列号
    private String serialNo;      //流水号
    private String bnkNo;         //银行编号
    private String bnkSerialNo;   //银行序列号
    private String bnkDate;       //银行操作日期
    private String bnkTime;       //银行操作时间
    private String inputDate;     //录入日期
    private String inputTime;     //录入时间
    private String acount;        //编号
    private String sucAcount;     //成功编号
    private String curCo;         //币种
    private String amount;        //数量
    private String sucAmount;     //成功数量
    private String feeAmt;        //手续费
    private String respCo;        //响应码
    private String respMsg;       //响应信息
    private String merRespCo;     //商户响应码
    private String merRespMsg;    //商户响应信息
    private String tranSt;        //操作状态
    private String rvrsSt;        //返回状态
    private String resultCode; //返回代码
    private String resultMessage; //返回信息
    private String refAppNo;    //参考业务号
    private String merTranCode; //商户交易代码
    private String orderCode; //订单特征码
    private boolean needTranslate = true;//默认需要翻译响应码，响应信息，操作状态
    private boolean needSign;//默认不需要调签约
    private BankCardBin bankCardBin;//卡Bin对象

}
