package com.kangyonggan.bankengine.model.app.vo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Table(name = "be_command")
@Data
public class BankCommand {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 交易流水号
     */
    @Column(name = "serial_no")
    private String serialNo;

    /**
     * 银行代码
     */
    @Column(name = "bnk_no")
    private String bnkNo;

    /**
     * 商户原始交易流水号
     */
    @Column(name = "mer_org_serial_no")
    private String merOrgSerialNo;

    /**
     * 银行原始交易流水
     */
    @Column(name = "bnk_org_serial_no")
    private String bnkOrgSerialNo;

    /**
     * 商户交易日期
     */
    @Column(name = "mer_date")
    private String merDate;

    /**
     * 商户交易时间
     */
    @Column(name = "mer_time")
    private String merTime;

    /**
     * 商户原始交易日期
     */
    @Column(name = "mer_org_date")
    private String merOrgDate;

    /**
     * 商户原始交易时间
     */
    @Column(name = "mer_org_time")
    private String merOrgTime;

    /**
     * 银行原始交易日期
     */
    @Column(name = "bnk_org_date")
    private String bnkOrgDate;

    /**
     * 银行原始交易时间
     */
    @Column(name = "bnk_org_time")
    private String bnkOrgTime;

    /**
     * 上次尝试日期
     */
    @Column(name = "last_try_date")
    private String lastTryDate;

    /**
     * 上次尝试时间
     */
    @Column(name = "last_try_time")
    private String lastTryTime;

    /**
     * 上次发送日期
     */
    @Column(name = "last_snd_date")
    private String lastSndDate;

    /**
     * 上次发送时间
     */
    @Column(name = "last_snd_time")
    private String lastSndTime;

    /**
     * 上次查询流水号
     */
    @Column(name = "last_qry_serial_no")
    private String lastQrySerialNo;

    /**
     * 上次查询日期
     */
    @Column(name = "last_qry_date")
    private String lastQryDate;

    /**
     * 上次查询时间
     */
    @Column(name = "last_qry_time")
    private String lastQryTime;

    /**
     * 指令生成日期
     */
    @Column(name = "input_date")
    private String inputDate;

    /**
     * 指令生成时间
     */
    @Column(name = "input_time")
    private String inputTime;

    /**
     * 商户交易代码
     */
    @Column(name = "mer_tran_co")
    private String merTranCo;

    /**
     * 银行交易代码
     */
    @Column(name = "bnk_tran_co")
    private String bnkTranCo;

    /**
     * 商户原始交易代码
     */
    @Column(name = "mer_org_tran_co")
    private String merOrgTranCo;

    /**
     * 银行原始交易代码
     */
    @Column(name = "bnk_org_tran_co")
    private String bnkOrgTranCo;

    /**
     * 交易类型
     */
    @Column(name = "tran_tp")
    private String tranTp;

    /**
     * 同步标记，01-同步，02-异步
     */
    @Column(name = "syn_flg")
    private String synFlg;

    /**
     * 批量标记，01-批量，02-单笔，03-汇总
     */
    @Column(name = "bat_flg")
    private String batFlg;

    /**
     * 批量笔数
     */
    private Long acount;

    /**
     * 重试标记，01-可重试，02-不可重试
     */
    @Column(name = "retry_flg")
    private String retryFlg;

    /**
     * 重试最大次数
     */
    @Column(name = "retry_max_time")
    private Integer retryMaxTime;

    /**
     * 重试间隔
     */
    @Column(name = "retry_interval")
    private Integer retryInterval;

    /**
     * 重试次数
     */
    @Column(name = "retry_counter")
    private Integer retryCounter;

    /**
     * 重发标记，01-可重发，02-不可重发
     */
    @Column(name = "resnd_flg")
    private String resndFlg;

    /**
     * 重发最大次数
     */
    @Column(name = "resnd_max_time")
    private Integer resndMaxTime;

    /**
     * 重发间隔
     */
    @Column(name = "resnd_interval")
    private Integer resndInterval;

    /**
     * 重发次数
     */
    @Column(name = "resnd_counter")
    private Integer resndCounter;

    /**
     * 查询标记，01-可查询，02-不可查询
     */
    @Column(name = "qry_flg")
    private String qryFlg;

    /**
     * 查询交易代码
     */
    @Column(name = "qry_tran_co")
    private String qryTranCo;

    /**
     * 查询最大次数
     */
    @Column(name = "qry_max_time")
    private Integer qryMaxTime;

    /**
     * 查询间隔
     */
    @Column(name = "qry_interval")
    private Integer qryInterval;

    /**
     * 查询次数
     */
    @Column(name = "qry_counter")
    private Integer qryCounter;

    /**
     * 优先级，1，2，3，4，5
     */
    private Short priority;

    /**
     * 处理模式，01-b2b，02-b2c，03-网银
     */
    private String model;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private String productId;

    /**
     * 产品类型
     */
    @Column(name = "product_tp")
    private String productTp;

    /**
     * 币种
     */
    @Column(name = "cur_co")
    private String curCo;

    /**
     * 转账金额
     */
    private BigDecimal amount;

    /**
     * 手续费
     */
    @Column(name = "fee_amt")
    private BigDecimal feeAmt;

    /**
     * 转账用途
     */
    @Column(name = "tran_purpose")
    private String tranPurpose;

    /**
     * 转账附言
     */
    @Column(name = "tran_remark")
    private String tranRemark;

    /**
     * 业务申请编号
     */
    @Column(name = "ref_app_no")
    private String refAppNo;

    /**
     * 业务申请类型
     */
    @Column(name = "ref_app_kind")
    private String refAppKind;

    /**
     * 收款方银行代码
     */
    @Column(name = "rcvr_bnk_no")
    private String rcvrBnkNo;

    /**
     * 收款方账号
     */
    @Column(name = "rcvr_acct_no")
    private String rcvrAcctNo;

    /**
     * 收款方账号名称
     */
    @Column(name = "rcvr_acct_nm")
    private String rcvrAcctNm;

    /**
     * 收款方证件类型
     */
    @Column(name = "rcvr_id_tp")
    private String rcvrIdTp;

    /**
     * 收款方证件号码
     */
    @Column(name = "rcvr_id_no")
    private String rcvrIdNo;

    /**
     * 收款方银行省份
     */
    @Column(name = "rcvr_province")
    private String rcvrProvince;

    /**
     * 收款方银行城市
     */
    @Column(name = "rcvr_city")
    private String rcvrCity;

    /**
     * 收款方地区代码
     */
    @Column(name = "rcvr_area_co")
    private String rcvrAreaCo;

    /**
     * 收款方地区名称
     */
    @Column(name = "rcvr_area_nm")
    private String rcvrAreaNm;

    /**
     * 收款方商户代码
     */
    @Column(name = "rcvr_mer_id")
    private String rcvrMerId;

    /**
     * 收款方商户证书代码
     */
    @Column(name = "rcvr_mer_cert_id")
    private String rcvrMerCertId;

    /**
     * 收款方柜台代码
     */
    @Column(name = "rcvr_post_id")
    private String rcvrPostId;

    /**
     * 收款方企业协议编号
     */
    @Column(name = "rcvr_contract_no")
    private String rcvrContractNo;

    /**
     * 收款方企业协议日期
     */
    @Column(name = "rcvr_contract_dt")
    private String rcvrContractDt;

    /**
     * 收款方个人缴费编号
     */
    @Column(name = "rcvr_proto_no")
    private String rcvrProtoNo;

    /**
     * 收款方商户用户类型
     */
    @Column(name = "rcvr_mer_user_tp")
    private String rcvrMerUserTp;

    /**
     * 收款方商户用户id
     */
    @Column(name = "rcvr_mer_user_id")
    private String rcvrMerUserId;

    /**
     * 收款方银行用户类型 (目前不用)
     */
    @Column(name = "rcvr_bnk_user_tp")
    private String rcvrBnkUserTp;

    /**
     * 收款方银行用户id (目前不用)
     */
    @Column(name = "rcvr_bnk_user_id")
    private String rcvrBnkUserId;

    /**
     * 收款方保留字段
     */
    @Column(name = "rcvr_resv1")
    private String rcvrResv1;

    /**
     * 收款方保留字段
     */
    @Column(name = "rcvr_resv2")
    private String rcvrResv2;

    /**
     * 付款方银行代码
     */
    @Column(name = "sndr_bnk_no")
    private String sndrBnkNo;

    /**
     * 付款方商户用户名(建行定投使用)
     */
    @Column(name = "sndr_name")
    private String sndrName;

    /**
     * 付款方账号
     */
    @Column(name = "sndr_acct_no")
    private String sndrAcctNo;

    /**
     * 付款方账号名称
     */
    @Column(name = "sndr_acct_nm")
    private String sndrAcctNm;

    /**
     * 付款方证件类型
     */
    @Column(name = "sndr_id_tp")
    private String sndrIdTp;

    /**
     * 付款方证件号码
     */
    @Column(name = "sndr_id_no")
    private String sndrIdNo;

    /**
     * 付款方银行省份
     */
    @Column(name = "sndr_province")
    private String sndrProvince;

    /**
     * 付款方银行城市
     */
    @Column(name = "sndr_city")
    private String sndrCity;

    /**
     * 付款方地区代码
     */
    @Column(name = "sndr_area_co")
    private String sndrAreaCo;

    /**
     * 付款方地区名称
     */
    @Column(name = "sndr_area_nm")
    private String sndrAreaNm;

    /**
     * 付款方商户代码
     */
    @Column(name = "sndr_mer_id")
    private String sndrMerId;

    /**
     * 付款方商户证书代码
     */
    @Column(name = "sndr_mer_cert_id")
    private String sndrMerCertId;

    /**
     * 付款方收款方柜台代码
     */
    @Column(name = "sndr_post_id")
    private String sndrPostId;

    /**
     * 付款方企业协议编号
     */
    @Column(name = "sndr_contract_no")
    private String sndrContractNo;

    /**
     * 付款方企业协议日期
     */
    @Column(name = "sndr_contract_dt")
    private String sndrContractDt;

    /**
     * 付款方个人缴费编号
     */
    @Column(name = "sndr_proto_no")
    private String sndrProtoNo;

    /**
     * 付款方商户用户类型
     */
    @Column(name = "sndr_mer_user_tp")
    private String sndrMerUserTp;

    /**
     * 付款方商户用户id
     */
    @Column(name = "sndr_mer_user_id")
    private String sndrMerUserId;

    /**
     * 付款方银行用户类型
     */
    @Column(name = "sndr_bnk_user_tp")
    private String sndrBnkUserTp;

    /**
     * 付款方银行用户id
     */
    @Column(name = "sndr_bnk_user_id")
    private String sndrBnkUserId;

    /**
     * 付款方保留字段
     */
    @Column(name = "sndr_resv1")
    private String sndrResv1;

    /**
     * 付款方保留字段
     */
    @Column(name = "sndr_resv2")
    private String sndrResv2;

    /**
     * 锁状态 n-未上锁，t-尝试发送锁，r-重新发送锁，q-查询锁
     */
    @Column(name = "lock_st")
    private String lockSt;

    /**
     * 交易状态 n-待处理，y-成功，f-失败，i-处理中，e-异常
     */
    @Column(name = "tran_st")
    private String tranSt;

    /**
     * 冲正状态 y-未冲正，r-已冲正
     */
    @Column(name = "rvrs_st")
    private String rvrsSt;

    /**
     * 产品名称
     */
    @Column(name = "product_nm")
    private String productNm;

    /**
     * 应用程序版本号
     */
    @Column(name = "app_version")
    private String appVersion;

    /**
     * 付款方分行号
     */
    @Column(name = "sndr_bnk_branch_name")
    private String sndrBnkBranchName;

    /**
     * 收款方分行号
     */
    @Column(name = "rcvr_bnk_branch_name")
    private String rcvrBnkBranchName;

    /**
     * 应用来源。1:直销  2：信用卡还款体验 3：代表cif 4：手机 5：代表开放平台
     */
    @Column(name = "app_source")
    private String appSource;

    /**
     * 是否有效,0:有效，1:无效
     */
    @Column(name = "is_delete")
    private Byte isDelete;

    /**
     * 数据创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 数据更新时间
     */
    @Column(name = "updated_at")
    private Date updatedAt;
}