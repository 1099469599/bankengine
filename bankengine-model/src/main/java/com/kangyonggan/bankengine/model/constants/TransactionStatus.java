package com.kangyonggan.bankengine.model.constants;

import java.io.Serializable;

/**
 * 银行指令执行状态
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
public enum TransactionStatus implements Serializable {
    /**
     * 待处理
     */
    N,
    /**
     * 成功
     */
    Y,
    /**
     * BE引擎在执行时错误的（<B>非银行返回错误</B>），返回状态为<B>F</B> <br/>
     */
    F,
    /**
     * 处理中
     */
    I,
    /**
     * BE引擎在执行银行指令时错误的（<B>银行返回错误</B>），返回状态为<B>E</B> <br/>
     */
    E
}
