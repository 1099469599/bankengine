package com.kangyonggan.bankengine.biz.impl;

import com.kangyonggan.bankengine.model.app.dto.BankEngineException;
import com.kangyonggan.bankengine.model.app.dto.response.CommonResponse;
import com.kangyonggan.bankengine.model.constants.CommonErrors;
import org.apache.commons.lang3.StringUtils;

/**
 * 银行引擎公共帮助类
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
public class BankEnginecommonHelper {

    /**
     * 如果exceptionCode不为空，则将BE银行指令执行错误写入commonResponse。
     *
     * @param commonResponse   BE对外接口调用返回
     * @param exceptionCode    BE银行指令执行错误代号
     * @param exceptionMessage BE银行指令执行错误内容
     */
    public static <T extends CommonResponse> T addBankEngineServiceException(
            final T commonResponse, String exceptionCode, String exceptionMessage) {
        if (commonResponse == null) {
            return commonResponse;
        }

        if (StringUtils.isNotEmpty(exceptionCode)) {
            if (commonResponse.getBankEngineException() == null) {
                commonResponse.setBankEngineException(new BankEngineException());
            }

            BankEngineException bankEngineException = commonResponse.getBankEngineException();

            bankEngineException.setExceptionCode(exceptionCode);
            bankEngineException.setExceptionMessage(exceptionMessage);
            bankEngineException.setMerchantErrorCode(CommonErrors.UnknowError.getCode());
            bankEngineException.setMerchantErrorMessage(CommonErrors.UnknowError.getMsg());
        }

        /**
         * 获取银行指令的正确指令状态
         */
//        commonResponse.setTransactionStatus(getCorrectTransactionStatus(commonResponse));
        return commonResponse;
    }
}
