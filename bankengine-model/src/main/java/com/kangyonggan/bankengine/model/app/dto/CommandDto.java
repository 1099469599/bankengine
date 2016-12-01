package com.kangyonggan.bankengine.model.app.dto;

import com.kangyonggan.bankengine.model.BaseObject;
import lombok.Data;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public class CommandDto extends BaseObject {

    private String asciiName;       //建行定投客户姓名ASCII十六进制
    private String serialNo;        //流水号（序列号）
    private String bnkNo;           //银行编号
    private String merOrgSerialNo;  //商户机构序列号
    private String bnkOrgSerialNo;  //银行机构序列号
    private String merDate;         //商户发送日期
    private String merTime;         //商户发送时间
    private String merOrgDate;      //商户机构发送日期
    private String merOrgTime;      //商户机构发送时间
    private String bnkOrgDate;      //银行机构发送日期
    private String bnkOrgTime;      //银行机构发送时间
    private String lastTryDate;     //最后操作日期
    private String lastTryTime;     //最后操作时间
    private String lastSndDate;     //最后发送日期
    private String lastSndTime;     //最好发送时间
    private String lastQrySerialNo; //最后查询序列号
    private String lastQryDate;     //最后查询日期
    private String lastQryTime;     //最后查询时间
    private String inputDate;       //最后录入日期
    private String inputTime;       //最后录入时间
    private String merTranCo;       //商户操作编号
    private String merOrgTranCo;    //商户机构操作编号
    private String bnkTranCo;       //银行操作编号
    private String bnkOrgTranCo;    //银行机构操作编号
    private String tranTp;          //操作类型
    private String synFlg;          //系统标记
    private String respco;          //应答码
    private String respmsg;          //应答信息
    private String imputtime;          //指令生成时间
    private String batFlg;
    private String acount;
    private String retryFlg;
    private String retryMaxTime;
    private String retryInterval;
    private String retryCounter;
    private String resndFlg;
    private String resndMaxTime;
    private String resndInterval;
    private String resndCounter;
    private String qryFlg;
    private String qryTranCo;
    private String qryMaxTime;
    private String qryInterval;
    private String qryCounter;
    private String priority;
    private String model;
    private String productId;
    private String productTp;
    private String productNm;
    private String curCo;
    private String amount;
    private String feeAmt;
    private String tranPurpose;
    private String tranRemark;
    private String refAppNo;
    private String refAppKind;
    private String rcvrBnkNo;
    private String rcvrAcctNo;
    private String rcvrAcctNm;
    private String rcvrIdTp;
    private String rcvrIdNo;
    private String rcvrProvince;
    private String rcvrCity;
    private String rcvrAreaCo;
    private String rcvrAreaNm;
    private String rcvrMerId;
    private String rcvrMerCertId;
    private String rcvrPostId;
    private String rcvrContractNo;
    private String rcvrContractDt;
    private String rcvrProtoNo;
    private String rcvrBnkBranchname;    //add by zhangqian 2014/2/17 分行名称(工行企业版本修改)
    private String rcvrMerUserTp;
    private String rcvrMerUserId;
    private String rcvrBnkUserTp;
    private String rcvrBnkUserId;
    private String rcvrResv1;
    private String rcvrResv2;
    private String sndrBnkNo;
    private String sndrAcctNo;
    private String sndrAcctNm;
    private String sndrName;        //客户名称
    private String sndrIdTp;
    private String sndrIdNo;
    private String sndrProvince;
    private String sndrCity;
    private String sndrAreaCo;
    private String sndrAreaNm;
    private String sndrMerId;
    private String sndrMerCertId;
    private String sndrPostId;
    private String sndrContractNo;
    private String sndrContractDt;
    private String sndrProtoNo;
    private String sndrMerUserTp;
    private String sndrMerUserId;
    private String sndrBnkUserTp;
    private String sndrBnkUserId;
    private String sndrResv1;
    private String sndrResv2;
    private String lockSt;
    private String tranSt;
    private String rvrsSt;
    private String branchNo;   //分行编号
    private String branchName; //分行名称

    //以下交通银行使用
    private String interfaceVersion;
    private String merID;
    private String orderid;
    private String orderDate;
    private String orderTime;
    private String tranType;
    //private String amount;
    private String curType;
    private String orderContent;
    private String orderMono;
    private String phdFlag;
    private String notifyType;
    private String merURL;
    private String goodsURL;
    private String jumpSeconds;
    private String payBatchNo;
    private String proxyMerName;
    private String proxyMerType;
    private String proxyMerCredentials;
    private String netType;
    private String sourceMsg;
    private String appSource;
    private String appVersion;
    private String insertTimeStamp;
    private String updateTimeStamp;
    private String sndrBnkBranchName;

    private String resultCode; //返回代码
    private String resultMessage; //返回信息
    //指令明细
    private CommandDto[] details;

}
