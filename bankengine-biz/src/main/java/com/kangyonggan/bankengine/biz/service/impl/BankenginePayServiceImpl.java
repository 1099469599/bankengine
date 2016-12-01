package com.kangyonggan.bankengine.biz.service.impl;

import com.kangyonggan.bankengine.biz.service.BankCommandService;
import com.kangyonggan.bankengine.biz.service.BankEnginePayService;
import com.kangyonggan.bankengine.mapper.BankIdtpMapper;
import com.kangyonggan.bankengine.model.app.BankSetting;
import com.kangyonggan.bankengine.model.app.dto.SerialNoParaDto;
import com.kangyonggan.bankengine.model.app.dto.request.PayRequest;
import com.kangyonggan.bankengine.model.app.dto.response.PayResponse;
import com.kangyonggan.bankengine.model.app.exception.BankEngineServiceException;
import com.kangyonggan.bankengine.model.app.exception.BankSettingException;
import com.kangyonggan.bankengine.model.app.vo.BankCommand;
import com.kangyonggan.bankengine.model.app.vo.BankIdtp;
import com.kangyonggan.bankengine.model.app.vo.BankMerchant;
import com.kangyonggan.bankengine.model.app.vo.BankTran;
import com.kangyonggan.bankengine.model.constants.AppConstants;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Service
@Log4j2
public class BankenginePayServiceImpl implements BankEnginePayService {

    @Autowired
    private BankCommandService bankCommandService;

    @Autowired
    private SettingInDbHelper settingInDbHelper;

    @Autowired
    private BankIdtpMapper bankIdtpMapper;

    /**
     * 支付接口, 有可能抛出异常。
     *
     * @param payRequest 付款接口的请求参数
     * @return 包含银行指令的流水号和银行指令执行的返回结果。
     * @throws IllegalArgumentException   payRequest不符合要求时会抛出异常
     * @throws BankEngineServiceException BE在写入/操作/执行银行指令错误时会抛出该异常
     */
    @Override
    public PayResponse payWithException(PayRequest payRequest) throws IllegalArgumentException, BankEngineServiceException {
        log.info("充值开始, {}", payRequest);

        // 基础数据校验
        validatePayRequest(payRequest);

        // 写入银行指令
        BankCommand bankCommand = writePayBankCommand(payRequest);

        String serialNo = bankCommand.getSerialNo();
        log.info("写入银行支付指令成功, accountNo:{}, serialNo:{}", payRequest.getSenderAccountNo(), serialNo);

        // 执行同步指令


        // 生成支付结果

        return new PayResponse();
    }

    /**
     * 写入银行指令
     *
     * @param payRequest
     * @return
     * @throws BankEngineServiceException
     */
    private BankCommand writePayBankCommand(PayRequest payRequest) throws BankEngineServiceException {
        BankCommand bankCommand = new BankCommand();

        String bankNo = payRequest.getBankNo();

        bankCommand.setSerialNo(genSerialNo(payRequest));
        bankCommand.setBnkNo(bankNo);
        bankCommand.setTranTp("D"); // 对应PARAMETER表中定义的TRANTP,扣款为D
        bankCommand.setMerTranCo(payRequest.getMerTranCode());

        BankEngineCommonHelper.setBankCommandCommonFields(bankCommand);

        BankSetting bankSetting;
        try {
            bankSetting = settingInDbHelper.getBankSetting(bankNo, StringUtils.EMPTY, payRequest.getCapitalMode(), payRequest.getMerTranCode(), payRequest.getSenderProtocolNo());
        } catch (BankSettingException e) {
            log.error(e.getExceptionMessage(), e);
            throw new BankEngineServiceException("005", "银行设定异常。bankNo : " + bankNo);
        }

        BankTran bankTran = bankSetting.getBankTran();
        BankEngineCommonHelper.setBankCommandBankTranRelatedFields(bankCommand, bankTran);

        bankCommand.setProductId(getProductId(payRequest.getProductId()));
        bankCommand.setProductNm(payRequest.getProductName());
        bankCommand.setProductTp("1");

        bankCommand.setCurCo(payRequest.getCurrency());
        bankCommand.setAmount(payRequest.getAmount());
        bankCommand.setFeeAmt(BigDecimal.ZERO);
        bankCommand.setTranPurpose(StringUtils.EMPTY);
        bankCommand.setTranRemark(null);

        bankCommand.setRefAppNo(payRequest.getRefAppNo());
        bankCommand.setRefAppKind(payRequest.getAppKind());

        BankMerchant bankMerchant = bankSetting.getBankMerchant();
        bankCommand.setRcvrBnkNo(bankMerchant.getBnkNo());
        bankCommand.setRcvrAcctNo(bankMerchant.getAcctNo());
        bankCommand.setRcvrAcctNm(null);
        bankCommand.setRcvrIdTp(null);
        bankCommand.setRcvrIdNo(null);
        bankCommand.setRcvrProvince(null);
        bankCommand.setRcvrCity(null);
        bankCommand.setRcvrAreaCo(null);
        bankCommand.setRcvrAreaNm(null);
        bankCommand.setRcvrMerId(bankMerchant.getMerId());
        bankCommand.setRcvrMerCertId(null);
        bankCommand.setRcvrPostId(bankMerchant.getPostId());
        bankCommand.setRcvrContractNo(null);
        bankCommand.setRcvrContractDt(null);
        bankCommand.setRcvrProtoNo(null);
        bankCommand.setRcvrMerUserTp(null);
        bankCommand.setRcvrMerUserId(null);
        bankCommand.setRcvrBnkUserTp(null);
        bankCommand.setRcvrBnkUserId(null);
        bankCommand.setRcvrResv1(null);
        bankCommand.setRcvrResv2(null);
        bankCommand.setRcvrBnkBranchName(null);

        bankCommand.setSndrBnkNo(payRequest.getBankNo());
        bankCommand.setSndrAcctNo(payRequest.getSenderAccountNo());
        bankCommand.setSndrAcctNm(payRequest.getSenderAccountName());
        bankCommand.setSndrIdTp(getSenderIdTp(bankNo, payRequest));
        bankCommand.setSndrIdNo(payRequest.getSenderIdNo());
        bankCommand.setSndrProvince(null);
        bankCommand.setSndrCity(null);
        bankCommand.setSndrAreaCo(null);
        bankCommand.setSndrAreaNm(null);
        bankCommand.setSndrMerId(null);
        bankCommand.setSndrMerCertId(null);
        bankCommand.setSndrPostId(null);
        bankCommand.setSndrContractNo(null);
        bankCommand.setSndrContractDt(null);
        bankCommand.setSndrProtoNo(payRequest.getSenderProtocolNo());
        bankCommand.setSndrMerUserTp(null);
        bankCommand.setSndrMerUserId(null);
        bankCommand.setSndrBnkUserTp(null);
        bankCommand.setSndrBnkUserId(null);

        bankCommand.setSndrResv1(payRequest.getMobileNo());
        bankCommand.setSndrResv2(StringUtils.EMPTY);
        bankCommand.setSndrBnkBranchName(null);

        bankCommand.setLockSt("N");
        bankCommand.setTranSt("N");

        bankCommand.setRvrsSt(null);

        bankCommandService.saveBankCommand(bankCommand);

        return bankCommand;
    }

    /**
     * 生成流水号
     *
     * @param payRequest
     * @return
     */
    private String genSerialNo(PayRequest payRequest) {
        SerialNoParaDto serialNoParaDto = new SerialNoParaDto();
        serialNoParaDto.setBankNo(payRequest.getBankNo());
        serialNoParaDto.setCapitalType(payRequest.getMerTranCode());
        serialNoParaDto.setFundId(payRequest.getProductId());
        String serialNo = bankCommandService.genPaySerialNoByNextVal(serialNoParaDto);
        return serialNo;
    }

    /**
     * 基础数据校验
     *
     * @param payRequest
     * @throws IllegalArgumentException
     */
    private void validatePayRequest(PayRequest payRequest) throws IllegalArgumentException {
        Assert.notNull(payRequest, "payRequest不能为空");

        Assert.hasText(payRequest.getBankNo(), "payRequest.bankNo不能为空");

        if (("01,02,03,04,05,06,79,80").indexOf(payRequest.getMerTranCode()) <= -1) {
            throw new IllegalArgumentException("payRequest.merTranCode不在所支持的代码中");
        }
    }

    /**
     * 获取产品ID
     * 如果产品ID中包含#，则截取#之前的部分
     * 如：输入05#000730，输出000730
     *
     * @param productId
     * @return
     */
    private String getProductId(String productId) {
        if (StringUtils.isNotBlank(productId) && productId.indexOf("#") > -1) {
            return productId.substring(productId.indexOf("#") + 1);
        }
        return productId;
    }

    /**
     * 从BANK_IDTP中获取证件类型
     *
     * @param payRequest
     * @return
     */
    private String getSenderIdTp(final String bankNo, final PayRequest payRequest) {
        BankIdtp bankIdtp = new BankIdtp();
        bankIdtp.setIsDelete(AppConstants.IS_DELETED_NO);
        bankIdtp.setBnkNo(bankNo);
        bankIdtp.setBnkIdTp(payRequest.getSenderIdType());

        try {
            bankIdtp = bankIdtpMapper.selectOne(bankIdtp);
            if (bankIdtp != null) {
                return bankIdtp.getBnkIdTp();
            }
        } catch (Exception e) {
            log.error("获取证件类型异常,bankNo:" + bankNo + ",idTp:" + payRequest.getSenderIdType() , e);
        }

        return payRequest.getSenderIdType();
    }

}
