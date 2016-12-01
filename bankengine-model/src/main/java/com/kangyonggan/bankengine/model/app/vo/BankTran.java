package com.kangyonggan.bankengine.model.app.vo;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Table(name = "be_tran")
@Data
public class BankTran {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 银行代码
     */
    @Column(name = "bnk_no")
    private String bnkNo;

    /**
     * 商户交易代码
     */
    @Column(name = "mer_tran_co")
    private String merTranCo;

    /**
     * 商户交易名称
     */
    @Column(name = "mer_tran_nm")
    private String merTranNm;

    /**
     * 银行交易代码
     */
    @Column(name = "bnk_tran_co")
    private String bnkTranCo;

    /**
     * 银行交易名称
     */
    @Column(name = "bnk_tran_nm")
    private String bnkTranNm;

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
     * 重试间隔（时间单位：分钟）
     */
    @Column(name = "retry_interval")
    private Integer retryInterval;

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
     * 重发间隔（时间单位：分钟）
     */
    @Column(name = "resnd_interval")
    private Integer resndInterval;

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
     * 查询交易名称
     */
    @Column(name = "qry_tran_nm")
    private String qryTranNm;

    /**
     * 查询最大次数
     */
    @Column(name = "qry_max_time")
    private Integer qryMaxTime;

    /**
     * 查询间隔（时间单位：分钟）
     */
    @Column(name = "qry_interval")
    private Integer qryInterval;

    /**
     * 优先级 1，2，3，4，5
     */
    private String priority;

    /**
     * 处理模式，01-b2b，02-b2c，03-网银
     */
    private String model;

    /**
     * 创建人
     */
    @Column(name = "c_man")
    private String cMan;

    /**
     * 编辑人
     */
    @Column(name = "e_man")
    private String eMan;

    /**
     * 状态，y-正常，n-禁用
     */
    @Column(name = "STATUS")
    private String status;

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