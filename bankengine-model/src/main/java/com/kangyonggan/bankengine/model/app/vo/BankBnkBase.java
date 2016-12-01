package com.kangyonggan.bankengine.model.app.vo;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Table(name = "be_bnkbase")
@Data
public class BankBnkBase {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 银行代码
     */
    @Column(name = "bnk_no")
    private String bnkNo;

    /**
     * 银行名称
     */
    @Column(name = "bnk_nm")
    private String bnkNm;

    /**
     * 网址
     */
    @Column(name = "web_site")
    private String webSite;

    /**
     * 网上银行地址
     */
    @Column(name = "ebnk_url")
    private String ebnkUrl;

    /**
     * 余额查询地址
     */
    @Column(name = "balance_url")
    private String balanceUrl;

    /**
     * 电话银行
     */
    @Column(name = "tel_bnk")
    private String telBnk;

    /**
     * 联系人
     */
    @Column(name = "link_man")
    private String linkMan;

    /**
     * 联系人电话
     */
    @Column(name = "link_man_tel")
    private String linkManTel;

    /**
     * 联系人传真
     */
    @Column(name = "link_man_fax")
    private String linkManFax;

    /**
     * 联系人电子邮件
     */
    @Column(name = "link_man_email")
    private String linkManEmail;

    /**
     * 展示顺序
     */
    @Column(name = "dis_order")
    private Integer disOrder;

    /**
     * 展示标志 y-展示，n-不展示
     */
    @Column(name = "dis_flg")
    private String disFlg;

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
     * 传输密钥（cmb）
     */
    @Column(name = "cmb_cmdk")
    private String cmbCmdk;

    /**
     * 数据密钥（cmb）
     */
    @Column(name = "cmb_cmdm")
    private String cmbCmdm;

    /**
     * 数据密钥更新时间
     */
    @Column(name = "cmdm_date")
    private String cmdmDate;

    /**
     * 银行开通定期定额时否需
     */
    private String protocol;

    /**
     * 网点编号
     */
    @Column(name = "net_point")
    private String netPoint;

    /**
     * 资金模式
     */
    @Column(name = "capital_mode")
    private String capitalMode;

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