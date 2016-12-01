package com.kangyonggan.bankengine.model.app.dto;

import com.kangyonggan.bankengine.model.BaseObject;
import com.kangyonggan.bankengine.model.app.exception.BankEngineServiceException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public class ReturnDto extends BaseObject {

    //银行执行指令
    private CommandDto cmd;
    //商户交易报文(B2C返回给WEB端用)
    private TransactionMessageDto tranMsg;
    //银行应答，多笔
    private ResponsionDto[] resps;
    //银行应答，单笔
    private ResponsionDto resp;
    //指令、资金状态，多笔
    private TransactionStatusDto[] tranSts;
    //指令、资金状态，单笔
    private TransactionStatusDto tranSt;
    /**
     * 需要解锁的指令，多笔
     * 数据格式为：serialNo,bnkNo
     * 以，为分隔符
     */
    private String[] unlockCmds;
    /**
     * 需要解锁的指令，单笔
     * 数据格式为：serialNo,bnkNo
     * 以，为分隔符
     */
    private String unlockCmd;
    //指令日志
    private List cmdLogs = new ArrayList();

    //错误代码
    private String resultCode;
    //错误信息
    private String resultMessage;

    //协议号
    private String protocolNo;

    private BankEngineServiceException bankEngineServiceException;

}
