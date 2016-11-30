package com.kangyonggan.bankengine.model.constants;

import lombok.Getter;

/**
 * @author kangyonggan
 * @since 2016/11/30
 */
public enum CommonErrors {

    Success("0000","成功"),
    NoDataError("8999","未获取到相应数据"),
    DataOverLimitError("8998","查询返回数据量过大"),
    ParamsError("9001","参数不合法"),
    NotSupportTran("9002","暂不支持该交易"),
    UnknowError("9999","通讯异常，请稍后再试"),
    PassagewayExistError("9003","该通道已存在");

    @Getter
    private final String code;

    @Getter
    private final String msg;

    CommonErrors(String code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
