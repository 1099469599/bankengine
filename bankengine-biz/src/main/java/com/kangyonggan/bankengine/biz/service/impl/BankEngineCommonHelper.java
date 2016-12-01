package com.kangyonggan.bankengine.biz.service.impl;

import com.kangyonggan.bankengine.biz.service.BankCommandService;
import com.kangyonggan.bankengine.biz.util.DateUtils;
import com.kangyonggan.bankengine.biz.util.SpringUtils;
import com.kangyonggan.bankengine.model.app.dto.response.CommonResponse;
import com.kangyonggan.bankengine.model.app.exception.BankEngineException;
import com.kangyonggan.bankengine.model.app.exception.BankEngineServiceException;
import com.kangyonggan.bankengine.model.app.vo.BankCommand;
import com.kangyonggan.bankengine.model.app.vo.BankTran;
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
public class BankEngineCommonHelper {

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

    /**
     * 对于BankCommand中一些统一字段做统一设定。NOTE: 每个接口都会写入相同内容，除了最后的LockSt/TranSt/RvrsSt。
     *
     * @param bankCommand
     */
    public static void setBankCommandCommonFields(final BankCommand bankCommand) {
        String date = DateUtils.getCurrentDate();
        String time = DateUtils.getCurrentTime();

        bankCommand.setMerOrgSerialNo(null);
        bankCommand.setBnkOrgTranCo(null);
        bankCommand.setMerDate(date);
        bankCommand.setMerTime(time);
        bankCommand.setMerOrgTime(null);
        bankCommand.setBnkOrgDate(null);
        bankCommand.setBnkOrgTime(null);
        bankCommand.setLastTryDate(null);
        bankCommand.setLastTryTime(null);
        bankCommand.setInputDate(date);
        bankCommand.setInputTime(time);
    }

    /**
     * 设置交易代码对应关系相关字段
     *
     * @param bankCommand
     * @param bankTran
     */
    public static void setBankCommandBankTranRelatedFields(BankCommand bankCommand, BankTran bankTran) {
        bankCommand.setBnkTranCo(bankTran.getBnkTranCo());//银行交易代码
        bankCommand.setSynFlg(bankTran.getSynFlg());//同步标记，01-同步，02-异步
        bankCommand.setBatFlg(bankTran.getBatFlg());//批量标记，01-批量，02-单笔，03-汇总
        bankCommand.setAcount(0l);//批量笔数
        bankCommand.setRetryFlg(bankTran.getRetryFlg());//重试标记，01-可重试，02-不可重试
        bankCommand.setRetryMaxTime(bankTran.getRetryMaxTime());//重试最大次数
        bankCommand.setRetryInterval(bankTran.getRetryInterval());//重试间隔
        bankCommand.setRetryCounter(0);//重试次数
        bankCommand.setResndFlg(bankTran.getResndFlg());//重发标记，01-可重发，02-不可重发
        bankCommand.setResndMaxTime(bankTran.getResndMaxTime());//重发最大次数
        bankCommand.setResndInterval(bankTran.getResndInterval());//重发间隔
        bankCommand.setResndCounter(0);//重发次数
        bankCommand.setQryFlg(bankTran.getQryFlg());//查询标记，01-可查询，02-不可查询
        bankCommand.setQryTranCo(bankTran.getQryTranCo());//查询交易代码
        bankCommand.setQryMaxTime(bankTran.getQryMaxTime());//查询最大次数
        bankCommand.setQryInterval(bankTran.getQryInterval());//查询间隔
        bankCommand.setQryCounter(0);//查询次数
        bankCommand.setPriority(Integer.valueOf(bankTran.getPriority()));//优先级，1，2，3，4，5
        bankCommand.setModel(bankTran.getModel());//处理模式，01-B2B，02-B2C，03-网银
    }
}
