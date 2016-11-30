package com.kangyonggan.bankengine.service;

import com.kangyonggan.bankengine.model.app.dto.request.*;
import com.kangyonggan.bankengine.model.app.dto.response.*;

/**
 * 银行引擎对外接口的定义
 * 包括：
 * 1. 发短信
 * 2. 鉴权
 * 3. 签约
 * 4. 解约
 * 5. 申购
 * 6. 赎回
 * 7. 对账下载
 * 8. 对账导入
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
public interface BankEngineService {

    /**
     * 发短信
     *
     * @param sendSmsRequest
     * @return
     */
    SendSmsResponse sendSms(final SendSmsRequest sendSmsRequest);

    /**
     * 鉴权
     *
     * @param verifyRequest
     * @return
     */
    VerifyResponse verify(final VerifyRequest verifyRequest);

    /**
     * 签约
     *
     * @param signRequest
     * @return
     */
    SignResponse sign(final SignRequest signRequest);

    /**
     * 申购
     *
     * @param payRequest
     * @return
     */
    PayResponse pay(final PayRequest payRequest);

    /**
     * 赎回
     *
     * @param redeemRequest
     * @return
     */
    RedeemResponse redeem(final RedeemRequest redeemRequest);

    /**
     * 对账下载
     *
     * @param dzRequest
     * @return
     */
    DzResponse downloadDZ(final DzRequest dzRequest);

    /**
     * 对账导入
     *
     * @param importRequest
     * @return
     */
    ImportResponse importEBankData(final ImportRequest importRequest);
}
