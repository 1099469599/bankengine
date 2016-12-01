package com.kangyonggan.bankengine.model.app.vo;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Table(name = "be_bank_belong")
@Data
public class BankBelong {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 银行编号
     */
    @Column(name = "bank_no")
    private String bankNo;

    /**
     * 所属银行
     */
    @Column(name = "bank_group_id")
    private String bankGroupId;

    /**
     * 是否支持借记卡
     */
    @Column(name = "deposit_bank")
    private String depositBank;

    /**
     * 是否支持信用卡
     */
    @Column(name = "credit_bank")
    private String creditBank;

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