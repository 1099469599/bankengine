package com.kangyonggan.bankengine.model.app.vo;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Table(name = "be_merbase")
@Data
public class BankMerchant {
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
     * 商户代码
     */
    @Column(name = "mer_id")
    private String merId;

    /**
     * 商户证书代码
     */
    @Column(name = "cert_id")
    private String certId;

    /**
     * 柜台代码
     */
    @Column(name = "post_id")
    private String postId;

    /**
     * 分行代码
     */
    @Column(name = "bran_id")
    private String branId;

    /**
     * 企业协议编号
     */
    @Column(name = "contract_no")
    private String contractNo;

    /**
     * 企业协议日期
     */
    @Column(name = "contract_dt")
    private String contractDt;

    /**
     * 收款账户号
     */
    @Column(name = "acct_no")
    private String acctNo;

    /**
     * 收款账户密码
     */
    @Column(name = "acct_pwd")
    private String acctPwd;

    /**
     * 回款账户号
     */
    @Column(name = "c_acct_no")
    private String cAcctNo;

    /**
     * 回款账户密码
     */
    @Column(name = "c_acct_pwd")
    private String cAcctPwd;

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
     * 状态 y-正常，n-禁用
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 商户所在分行区域代码
     */
    @Column(name = "area_id")
    private String areaId;

    /**
     * 收款账户名称
     */
    @Column(name = "acct_nm")
    private String acctNm;

    /**
     * 回款账户名称
     */
    @Column(name = "c_acct_nm")
    private String cAcctNm;

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