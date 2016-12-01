package com.kangyonggan.bankengine.model.app.vo;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Table(name = "be_card_bin")
@Data
public class BankCardBin {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 所属银行
     */
    @Column(name = "bank_group")
    private String bankGroup;

    /**
     * 卡号长度
     */
    @Column(name = "card_length")
    private Short cardLength;

    /**
     * 卡bin
     */
    @Column(name = "bin_code")
    private String binCode;

    /**
     * 卡bin长度
     */
    @Column(name = "bin_length")
    private Short binLength;

    /**
     * 卡类型
     */
    @Column(name = "card_type")
    private String cardType;

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