package com.kangyonggan.bankengine.model.constants;

import lombok.Getter;

import java.io.Serializable;

/**
 * 银行受理方式
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
public enum Accptmd implements Serializable {

    /**
     * 手机
     */
    Mobile("M"),

    /**
     * PC
     */
    PC("2"),

    /**
     * HOP
     */
    HOP("H"),

    /**
     * 柜台
     */
    C("C"),

    /**
     * 企业版
     */
    E("E"),

    /**
     * 信用卡
     */
    LA("L");

    @Getter
    private final String value;

    Accptmd(String value) {
        this.value = value;
    }

}
