package com.kangyonggan.bankengine.model.app.vo;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Table(name = "be_idtp")
@Data
public class BankIdtp {
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
     * 银行证件类型
     */
    @Column(name = "bnk_id_tp")
    private String bnkIdTp;

    /**
     * 银行证件类型名称
     */
    @Column(name = "bnk_id_tp_nm")
    private String bnkIdTpNm;

    /**
     * 商户证件类型
     */
    @Column(name = "mer_id_tp")
    private String merIdTp;

    /**
     * 商户证件类型名称
     */
    @Column(name = "mer_id_tp_nm")
    private String merIdTpNm;

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