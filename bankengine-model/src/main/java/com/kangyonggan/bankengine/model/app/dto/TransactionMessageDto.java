package com.kangyonggan.bankengine.model.app.dto;

import com.kangyonggan.bankengine.model.BaseObject;
import lombok.Data;

import java.util.HashMap;
import java.util.SortedMap;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public class TransactionMessageDto extends BaseObject {

    public static final String STATE_SUCCESS = "S";
    public static final String STATE_FAIL = "F";
    public static final String STATE_IN_HAND = "I";// 银联手机申购使用

    //交易报文全文
    private String allMsg;
    //交易报文原文
    private String plainMsg;
    //交易报文加密
    private String encMsg;
    //交易报文签名
    private String sigMsg;
    //商户、银行重定位URL
    private String redUrl;
    //状态
    private String state;
    //表单内容
    private HashMap formBean;

    //财付通排序
    private SortedMap sortedMap;

    //错误代码
    private String resultCode;
    //错误信息
    private String resultMessage;

}
