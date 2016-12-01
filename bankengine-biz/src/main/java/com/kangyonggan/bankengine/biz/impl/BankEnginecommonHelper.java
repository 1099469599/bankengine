package com.kangyonggan.bankengine.biz.impl;

import com.kangyonggan.bankengine.biz.service.BankCommandService;
import com.kangyonggan.bankengine.biz.util.SpringUtils;
import com.kangyonggan.bankengine.model.app.dto.exception.BankEngineException;
import com.kangyonggan.bankengine.model.app.dto.exception.BankEngineServiceException;
import com.kangyonggan.bankengine.model.app.dto.response.CommonResponse;
import com.kangyonggan.bankengine.model.app.vo.BankCommand;
import com.kangyonggan.bankengine.model.constants.CommonErrors;
import com.kangyonggan.bankengine.model.constants.TransactionStatus;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * 银行引擎公共帮助类
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
public class BankEnginecommonHelper {

    /**
     * 回写简单的响应
     *
     * @param response
     * @param transSt
     * @param errCode
     * @param errMsg
     */
    public static void generateSimpleResponse(CommonResponse response, TransactionStatus transSt, String errCode, String errMsg) {
        BankEngineException bankEngineException = new BankEngineException();
        bankEngineException.setBankErrorCode(errCode);
        bankEngineException.setBankErrorMessage(errMsg);
        bankEngineException.setMerchantErrorCode(errCode);
        bankEngineException.setMerchantErrorMessage(errMsg);

        response.setBankEngineException(bankEngineException);
        response.setTransactionStatus(transSt);
    }

    /**
     * 回写带业务的响应
     *
     * @param response
     * @param errCode
     * @param errMsg
     */
    public static void generateServiceResponse(CommonResponse response, String errCode, String errMsg) {
        TransactionStatus transSt = getCorrectTransactionStatus(response);
        generateSimpleResponse(response, transSt, errCode, errMsg);
    }

    /**
     * 获取银行指令的正确指令状态
     *
     * @param commonResponse
     * @return
     */
    private static TransactionStatus getCorrectTransactionStatus(final CommonResponse commonResponse) {
        if (StringUtils.isNotEmpty(commonResponse.getSerialNo())) {
            BankCommandService bankCommandService = SpringUtils.getBean(BankCommandService.class);
            BankCommand bankCommand = bankCommandService.findBankCommandBySerialNo(commonResponse.getSerialNo());
            if (bankCommand != null) {
                return TransactionStatus.valueOf(bankCommand.getTranSt());
            }
        }

        // 没有产生银行指令的情况, 肯定是E的状态。
        return TransactionStatus.E;
    }

    /**
     * 异常处理
     *
     * @param request
     * @param e
     * @param logger
     * @param <T>
     */
    public static <T> Map<String, String> handleException(T request, Exception e, Logger logger) {
        Map<String, String> result = new HashMap();
        if (e instanceof IllegalArgumentException) {
            result.put("errCode", CommonErrors.ParamsError.getCode());
            result.put("errMsg", "输入参数异常。详细原因：" + e.getMessage());
            logger.error("接口执行错误, " + request, e);
        } else if (e instanceof BankEngineServiceException) {
            BankEngineServiceException ex = (BankEngineServiceException) e;
            result.put("errCode", ex.getExceptionCode());
            result.put("errMsg", ex.getExceptionMessage());
            logger.error("接口执行错误, " + request, ex);
        } else {
            result.put("errCode", CommonErrors.UnknowError.getCode());
            result.put("errMsg", "未知异常!");
            logger.error("未知异常, " + request, e);
        }

        return result;
    }
}
