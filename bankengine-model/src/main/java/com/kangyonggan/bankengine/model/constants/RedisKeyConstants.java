package com.kangyonggan.bankengine.model.constants;

/**
 * redis键常量
 *
 * @author kangyonggan
 * @since 2016/12/1
 */
public interface RedisKeyConstants {

    /**
     * 银行指令序列(包含各种交易：鉴权，签约，充值，取现，对账单下载)
     */
    String KEY_BE_SN_COMMAND = "BE:SN:COMMAND";

}
