package com.kangyonggan.bankengine.model.app.vo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Table(name = "be_channel_conf")
@Data
public class BankChannelConf {
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
     * 银行通道
     */
    @Column(name = "route_name")
    private String routeName;

    /**
     * 所属银行
     */
    @Column(name = "bank_group_id")
    private String bankGroupId;

    /**
     * pc充值/基金/理财产品        01-支持   02-不支持  03-屏蔽
     */
    @Column(name = "pc_recharge")
    private String pcRecharge;

    /**
     * app充值/基金/理财       01-支持   02-不支持
     */
    @Column(name = "app_recharge")
    private String appRecharge;

    /**
     * 光大平台充值           01-支持   02-不支持
     */
    @Column(name = "ceb_recharge")
    private String cebRecharge;

    /**
     * 单笔限额
     */
    @Column(name = "singel_threashhold")
    private BigDecimal singelThreashhold;

    /**
     * 日累计限额
     */
    @Column(name = "day_threashhold")
    private BigDecimal dayThreashhold;

    /**
     * 限额备注
     */
    private String remarks;

    /**
     * 定期定额/定期不定额                01-支持   02-不支持
     */
    @Column(name = "regular_norm")
    private String regularNorm;

    /**
     * 自动充值             01-支持   02-不支持
     */
    @Column(name = "auto_recharge")
    private String autoRecharge;

    /**
     * 保底归集 01-支持   02-不支持
     */
    @Column(name = "guara_collection")
    private String guaraCollection;

    /**
     * 快速取现             01-支持   02-不支持
     */
    @Column(name = "fast_cash")
    private String fastCash;

    /**
     * 取现/定期取现/预约取现              01-支持   02-不支持
     */
    @Column(name = "pre_cash")
    private String preCash;

    /**
     * 修改手机号码                     01-支持   02-不支持
     */
    @Column(name = "modify_mobile")
    private String modifyMobile;

    /**
     * 找回交易密码                      01-支持   02-不支持
     */
    @Column(name = "find_pwd")
    private String findPwd;

    /**
     * pc开户              01-支持      02-不支持
     */
    @Column(name = "pc_open_account")
    private String pcOpenAccount;

    /**
     * pc绑卡              01-支持      02-不支持
     */
    @Column(name = "pc_add_card")
    private String pcAddCard;

    /**
     * 手机开户              01-支持      02-不支持
     */
    @Column(name = "m_open_account")
    private String mOpenAccount;

    /**
     * 手机绑卡              01-支持      02-不支持
     */
    @Column(name = "m_add_card")
    private String mAddCard;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 更新人
     */
    private String changer;

    /**
     * 01-网银 02-通联 03-快捷 04-银联 05-第三方网银 06-赛维卡 07-证通 99-其他
     */
    @Column(name = "sign_type")
    private String signType;

    /**
     * 开户demo的url地址
     */
    @Column(name = "auth_demo_url")
    private String authDemoUrl;

    /**
     * 开户提示信息
     */
    @Column(name = "auth_tip")
    private String authTip;

    /**
     * 重复签约    01-支持   02-不支持
     */
    @Column(name = "re_sign")
    private String reSign;

    /**
     * 解约模式    01-b2b   02-b2c    03-不支持
     */
    @Column(name = "terminate_model")
    private String terminateModel;

    /**
     * 是否支持身份验证    Y-支持 N-不支持
     */
    @Column(name = "is_support_verify")
    private String isSupportVerify;

    /**
     * 短信发送方式 Y－银行引擎触发银行发送  N－业务系统发送
     */
    @Column(name = "sms_mode")
    private String smsMode;

    /**
     * 对账文件方式, I:接口方式，U: 网银下载
     */
    @Column(name = "chk_file_mode")
    private String chkFileMode;

    /**
     * 是否内测环境，默认为 是
     */
    @Column(name = "is_beta")
    private String isBeta;

    /**
     * 绑卡状态 Y:可用， N:关闭
     */
    @Column(name = "add_card_state")
    private String addCardState;

    /**
     * 绑卡关闭提示
     */
    @Column(name = "add_card_tip")
    private String addCardTip;

    /**
     * 充值状态 Y:可用， N:关闭
     */
    @Column(name = "recharge_state")
    private String rechargeState;

    /**
     * 充值关闭提示
     */
    @Column(name = "recharge_tip")
    private String rechargeTip;

    /**
     * 取现状态 Y:可用， N:关闭
     */
    @Column(name = "withdraw_state")
    private String withdrawState;

    /**
     * 取现关闭提示
     */
    @Column(name = "withdraw_tip")
    private String withdrawTip;

    /**
     * 快速取现状态 Y:可用， N:关闭
     */
    @Column(name = "fast_cash_state")
    private String fastCashState;

    /**
     * 快速取现关闭提示
     */
    @Column(name = "fast_cash_tip")
    private String fastCashTip;

    /**
     * 删卡状态 Y:可用， N:关闭
     */
    @Column(name = "del_card_state")
    private String delCardState;

    /**
     * 删卡关闭提示
     */
    @Column(name = "del_card_tip")
    private String delCardTip;

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