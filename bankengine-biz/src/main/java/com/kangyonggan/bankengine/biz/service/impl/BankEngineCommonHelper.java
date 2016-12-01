package com.kangyonggan.bankengine.biz.service.impl;

import com.kangyonggan.bankengine.biz.service.BankCommandService;
import com.kangyonggan.bankengine.biz.util.DateUtils;
import com.kangyonggan.bankengine.biz.util.SpringUtils;
import com.kangyonggan.bankengine.biz.util.StringUtil;
import com.kangyonggan.bankengine.model.app.dto.BankExecuteParaDto;
import com.kangyonggan.bankengine.model.app.dto.CommandDto;
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

    private static final String error = "0000";
    private static final String errmsg = "读银行指令成功";

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

    /**
     * 产生银行指令执行的输入参数
     *
     * @param serialNo 业务流水号
     * @param bankNo   银行编号
     * @param appKind  业务代号
     * @return
     */
    public static BankExecuteParaDto generateInputParameter(String serialNo, String bankNo, String appKind) {
        BankExecuteParaDto inputParameter = new BankExecuteParaDto();
        inputParameter.setSerialNo(serialNo);
        inputParameter.setBnkNo(bankNo);
        inputParameter.setApKind(appKind);
        return inputParameter;
    }

    /**
     * 把bankCommand转换为commonDto
     *
     * @param bankCommand
     * @return
     */
    public static CommandDto bankCommand2CommonDto(BankCommand bankCommand) {
        if (bankCommand != null) {
            CommandDto commandDto = new CommandDto();
            commandDto.setSerialNo(bankCommand.getSerialNo());
            commandDto.setBnkNo(bankCommand.getBnkNo());
            commandDto.setMerOrgSerialNo(bankCommand.getMerOrgSerialNo());
            commandDto.setBnkOrgSerialNo(bankCommand.getBnkOrgSerialNo());
            commandDto.setMerDate(bankCommand.getMerDate());
            commandDto.setMerTime(bankCommand.getMerTime());
            commandDto.setMerOrgDate(bankCommand.getMerOrgDate());
            commandDto.setMerOrgTime(bankCommand.getMerOrgTime());
            commandDto.setBnkOrgDate(bankCommand.getBnkOrgDate());
            commandDto.setBnkOrgTime(bankCommand.getBnkOrgTime());
            commandDto.setLastTryDate(bankCommand.getLastTryDate());
            commandDto.setLastTryTime(bankCommand.getLastTryTime());
            commandDto.setLastSndDate(bankCommand.getLastSndDate());
            commandDto.setLastSndTime(bankCommand.getLastSndTime());
            commandDto.setLastQrySerialNo(bankCommand.getLastQrySerialNo());
            commandDto.setLastQryDate(bankCommand.getLastQryDate());
            commandDto.setLastQryTime(bankCommand.getLastQryTime());
            commandDto.setInputDate(bankCommand.getInputDate());
            commandDto.setInputTime(bankCommand.getInputTime());
            commandDto.setMerTranCo(bankCommand.getMerTranCo());
            commandDto.setBnkTranCo(bankCommand.getBnkTranCo());
            commandDto.setMerOrgTranCo(bankCommand.getMerOrgTranCo());
            commandDto.setBnkOrgTranCo(bankCommand.getBnkOrgTranCo());
            commandDto.setTranTp(bankCommand.getTranTp());
            commandDto.setSynFlg(bankCommand.getSynFlg());
            commandDto.setBatFlg(bankCommand.getBatFlg());
            commandDto.setAcount(bankCommand.getAcount().toString());
            commandDto.setRetryFlg(bankCommand.getRetryFlg());
            commandDto.setRetryMaxTime(StringUtil.integerToString(bankCommand.getRetryMaxTime()));
            commandDto.setRetryInterval(StringUtil.integerToString(bankCommand.getRetryInterval()));
            commandDto.setRetryCounter(StringUtil.integerToString(bankCommand.getRetryCounter()));
            commandDto.setResndFlg(bankCommand.getResndFlg());
            commandDto.setResndMaxTime(StringUtil.integerToString(bankCommand.getResndMaxTime()));
            commandDto.setResndInterval(StringUtil.integerToString(bankCommand.getResndInterval()));
            commandDto.setResndCounter(StringUtil.integerToString(bankCommand.getResndCounter()));
            commandDto.setQryFlg(bankCommand.getQryFlg());
            commandDto.setQryTranCo(bankCommand.getQryTranCo());
            commandDto.setQryMaxTime(StringUtil.integerToString(bankCommand.getQryMaxTime()));
            commandDto.setQryInterval(StringUtil.integerToString(bankCommand.getQryInterval()));
            commandDto.setQryCounter(StringUtil.integerToString(bankCommand.getQryCounter()));
            commandDto.setPriority(StringUtil.integerToString(bankCommand.getPriority()));
            commandDto.setModel(bankCommand.getModel());
            commandDto.setProductId(bankCommand.getProductId());
            commandDto.setProductTp(bankCommand.getProductTp());
            commandDto.setProductNm(bankCommand.getProductNm());
            commandDto.setCurCo(bankCommand.getCurCo());
            commandDto.setAmount(StringUtil.bigDecimalToString(bankCommand.getAmount()));
            commandDto.setFeeAmt(StringUtil.bigDecimalToString(bankCommand.getFeeAmt()));
            commandDto.setTranPurpose(bankCommand.getTranPurpose());
            commandDto.setTranRemark(bankCommand.getTranRemark());
            commandDto.setRefAppNo(bankCommand.getRefAppNo());
            commandDto.setRefAppKind(bankCommand.getRefAppKind());
            commandDto.setRcvrBnkNo(bankCommand.getRcvrBnkNo());
            commandDto.setRcvrBnkBranchname(bankCommand.getRcvrBnkBranchName());
            commandDto.setRcvrAcctNo(bankCommand.getRcvrAcctNo());
            commandDto.setRcvrAcctNm(bankCommand.getRcvrAcctNm());
            commandDto.setRcvrIdTp(bankCommand.getRcvrIdTp());
            commandDto.setRcvrIdNo(bankCommand.getRcvrIdNo());
            commandDto.setRcvrProvince(bankCommand.getRcvrProvince());
            commandDto.setRcvrCity(bankCommand.getRcvrCity());
            commandDto.setRcvrAreaCo(bankCommand.getRcvrAreaCo());
            commandDto.setRcvrAreaNm(bankCommand.getRcvrAreaNm());
            commandDto.setRcvrMerId(bankCommand.getRcvrMerId());
            commandDto.setRcvrMerCertId(bankCommand.getRcvrMerCertId());
            commandDto.setRcvrPostId(bankCommand.getRcvrPostId());
            commandDto.setRcvrContractNo(bankCommand.getRcvrContractNo());
            commandDto.setRcvrContractDt(bankCommand.getRcvrContractDt());
            commandDto.setRcvrProtoNo(bankCommand.getRcvrProtoNo());
            // commandDto.setAsciiName(bankCommand.getString("SNDR_UNAME"));
            commandDto.setRcvrMerUserTp(bankCommand.getRcvrMerUserTp());
            commandDto.setRcvrMerUserId(bankCommand.getRcvrMerUserId());
            commandDto.setRcvrBnkUserTp(bankCommand.getRcvrBnkUserTp());
            commandDto.setRcvrBnkUserId(bankCommand.getRcvrBnkUserId());
            commandDto.setRcvrResv1(bankCommand.getRcvrResv1());
            commandDto.setRcvrResv2(bankCommand.getRcvrResv2());
            commandDto.setSndrBnkNo(bankCommand.getSndrBnkNo());
            commandDto.setSndrAcctNo(bankCommand.getSndrAcctNo());
            commandDto.setSndrAcctNm(bankCommand.getSndrAcctNm());
            commandDto.setSndrIdTp(bankCommand.getSndrIdTp());
            commandDto.setSndrIdNo(bankCommand.getSndrIdNo());
            commandDto.setSndrProvince(bankCommand.getSndrProvince());
            commandDto.setSndrCity(bankCommand.getSndrCity());
            commandDto.setSndrAreaCo(bankCommand.getSndrAreaCo());
            commandDto.setSndrAreaNm(bankCommand.getSndrAreaNm());
            commandDto.setSndrMerId(bankCommand.getSndrMerId());
            commandDto.setSndrMerCertId(bankCommand.getSndrMerCertId());
            commandDto.setSndrPostId(bankCommand.getSndrPostId());
            commandDto.setSndrContractNo(bankCommand.getSndrContractNo());
            commandDto.setSndrContractDt(bankCommand.getSndrContractDt());
            commandDto.setSndrProtoNo(bankCommand.getSndrProtoNo());
            commandDto.setSndrMerUserTp(bankCommand.getSndrMerUserTp());
            commandDto.setSndrMerUserId(bankCommand.getSndrMerUserId());
            commandDto.setSndrBnkUserTp(bankCommand.getSndrBnkUserTp());
            commandDto.setSndrBnkUserId(bankCommand.getSndrBnkUserId());
            commandDto.setSndrResv1(bankCommand.getSndrResv1());
            commandDto.setSndrResv2(bankCommand.getSndrResv2());
            commandDto.setLockSt(bankCommand.getLockSt());
            commandDto.setTranSt(bankCommand.getTranSt());
            commandDto.setRvrsSt(bankCommand.getRvrsSt());
            commandDto.setAppSource(bankCommand.getAppSource());
            commandDto.setAppVersion(bankCommand.getAppVersion());
            commandDto.setInsertTimeStamp(DateUtils.toMailDateDtPartString(bankCommand.getCreatedAt()));
            commandDto.setUpdateTimeStamp(DateUtils.toMailDateDtPartString(bankCommand.getUpdatedAt()));
            commandDto.setSndrBnkBranchName(bankCommand.getSndrBnkBranchName());
            commandDto.setResultCode(error);
            commandDto.setResultMessage(errmsg);
            return commandDto;
        }
        return null;
    }
}
