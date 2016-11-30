package com.kangyonggan.bankengine.model.app.vo;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Table(name = "be_bank_group")
@Data
public class BeBankGroup {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 所属银行
     */
    @Column(name = "group_id")
    private String groupId;

    /**
     * 所属银行名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 银行排序
     */
    @Column(name = "group_order")
    private Byte groupOrder;

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