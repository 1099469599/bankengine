CREATE DATABASE be
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

USE be;

DROP TABLE
IF EXISTS be_bnkbase;

CREATE TABLE be_bnkbase (
  id             BIGINT     NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  bnk_no         VARCHAR(3) NOT NULL
  COMMENT '银行代码',
  bnk_nm         VARCHAR(60) COMMENT '银行名称',
  web_site       VARCHAR(80) COMMENT '网址',
  ebnk_url       VARCHAR(80) COMMENT '网上银行地址',
  balance_url    VARCHAR(80) COMMENT '余额查询地址',
  tel_bnk        VARCHAR(20) COMMENT '电话银行',
  link_man       VARCHAR(30) COMMENT '联系人',
  link_man_tel   VARCHAR(20) COMMENT '联系人电话',
  link_man_fax   VARCHAR(20) COMMENT '联系人传真',
  link_man_email VARCHAR(50) COMMENT '联系人电子邮件',
  dis_order      NUMERIC(8, 0) COMMENT '展示顺序',
  dis_flg        VARCHAR(1) COMMENT '展示标志 y-展示，n-不展示',
  c_man          VARCHAR(30) COMMENT '创建人',
  e_man          VARCHAR(30) COMMENT '编辑人',
  STATUS         VARCHAR(1) COMMENT '状态 y-正常，n-禁用',
  cmb_cmdk       VARCHAR(32) COMMENT '传输密钥（cmb）',
  cmb_cmdm       VARCHAR(32) COMMENT '数据密钥（cmb）',
  cmdm_date      VARCHAR(20) COMMENT '数据密钥更新时间',
  protocol       CHAR(1) COMMENT '银行开通定期定额时否需',
  net_point      VARCHAR(9) COMMENT '网点编号',
  capital_mode   VARCHAR(2) COMMENT '资金模式',
  is_delete      TINYINT(4) NOT NULL DEFAULT '0'
  COMMENT '是否有效,0:有效，1:无效',
  created_at     TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '数据创建时间',
  updated_at     TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '数据更新时间',
  UNIQUE KEY be_bnkbase_unique (bnk_no),
  PRIMARY KEY (id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '银行基本信息表';

CREATE INDEX ix_bnk_no
  ON be_bnkbase (bnk_no);

CREATE INDEX ix_created_at
  ON be_bnkbase (created_at);

CREATE INDEX ix_updated_at
  ON be_bnkbase (updated_at);

DROP TABLE
IF EXISTS be_bank_group;

CREATE TABLE be_bank_group (
  id          INT         NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  group_id    VARCHAR(4)  NOT NULL
  COMMENT '所属银行',
  group_name  VARCHAR(32) NOT NULL
  COMMENT '所属银行名称',
  group_order TINYINT(4)  NOT NULL
  COMMENT '银行排序',
  is_delete   TINYINT(4)  NOT NULL DEFAULT '0'
  COMMENT '是否有效,0:有效，1:无效',
  created_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '数据创建时间',
  updated_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '数据更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY be_bank_group (group_id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '银行信息表';

CREATE INDEX ix_created_at
  ON be_bank_group (created_at);

CREATE INDEX ix_updated_at
  ON be_bank_group (updated_at);

CREATE UNIQUE INDEX ix_group_order
  ON be_bank_group (group_order);

DROP TABLE
IF EXISTS be_bank_belong;

CREATE TABLE be_bank_belong (
  id            INT        NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  bank_no       VARCHAR(3) NOT NULL
  COMMENT '银行编号',
  bank_group_id VARCHAR(4) NOT NULL
  COMMENT '所属银行',
  deposit_bank  VARCHAR(1) NOT NULL
  COMMENT '是否支持借记卡',
  credit_bank   VARCHAR(1) NOT NULL
  COMMENT '是否支持信用卡',
  is_delete     TINYINT(4) NOT NULL DEFAULT '0'
  COMMENT '是否有效,0:有效，1:无效',
  created_at    TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '数据创建时间',
  updated_at    TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '数据更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY be_bank_belong (bank_no)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '银行编号属性表';

CREATE INDEX ix_created_at
  ON be_bank_belong (created_at);

CREATE INDEX ix_updated_at
  ON be_bank_belong (updated_at);

DROP TABLE
IF EXISTS be_channel_conf;

CREATE TABLE be_channel_conf (
  id                 INT          NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  bank_no            VARCHAR(3)   NOT NULL
  COMMENT '银行编号',
  route_name         VARCHAR(36) COMMENT '银行通道',
  bank_group_id      VARCHAR(60) COMMENT '所属银行',
  pc_recharge        VARCHAR(2) COMMENT 'pc充值/基金/理财产品        01-支持   02-不支持  03-屏蔽',
  app_recharge       VARCHAR(2) COMMENT 'app充值/基金/理财       01-支持   02-不支持',
  ceb_recharge       VARCHAR(2) COMMENT '光大平台充值           01-支持   02-不支持',
  singel_threashhold DECIMAL(16, 2) COMMENT '单笔限额',
  day_threashhold    DECIMAL(16, 2) COMMENT '日累计限额',
  remarks            VARCHAR(300) COMMENT '限额备注',
  regular_norm       VARCHAR(2) COMMENT '定期定额/定期不定额                01-支持   02-不支持',
  auto_recharge      VARCHAR(2) COMMENT '自动充值             01-支持   02-不支持',
  guara_collection   VARCHAR(2) COMMENT '保底归集 01-支持   02-不支持',
  fast_cash          VARCHAR(2) COMMENT '快速取现             01-支持   02-不支持',
  pre_cash           VARCHAR(2) COMMENT '取现/定期取现/预约取现              01-支持   02-不支持',
  modify_mobile      VARCHAR(2) COMMENT '修改手机号码                     01-支持   02-不支持',
  find_pwd           VARCHAR(2) COMMENT '找回交易密码                      01-支持   02-不支持',
  pc_open_account    VARCHAR(2) COMMENT 'pc开户              01-支持      02-不支持',
  pc_add_card        VARCHAR(2) COMMENT 'pc绑卡              01-支持      02-不支持',
  m_open_account     VARCHAR(2) COMMENT '手机开户              01-支持      02-不支持',
  m_add_card         VARCHAR(2) COMMENT '手机绑卡              01-支持      02-不支持',
  creator            VARCHAR(30) COMMENT '创建人',
  changer            VARCHAR(30) COMMENT '更新人',
  sign_type          VARCHAR(2) COMMENT '01-网银 02-通联 03-快捷 04-银联 05-第三方网银 06-赛维卡 07-证通 99-其他',
  auth_demo_url      VARCHAR(300) COMMENT '开户demo的url地址',
  auth_tip           VARCHAR(300) COMMENT '开户提示信息',
  re_sign            VARCHAR(2) COMMENT '重复签约    01-支持   02-不支持',
  terminate_model    VARCHAR(2) COMMENT '解约模式    01-b2b   02-b2c    03-不支持',
  is_support_verify  VARCHAR(2)            DEFAULT 'N'
  COMMENT '是否支持身份验证    Y-支持 	N-不支持',
  sms_mode           CHAR(1)               DEFAULT 'N'
  COMMENT '短信发送方式 Y－银行引擎触发银行发送  N－业务系统发送',
  chk_file_mode      CHAR(1)               DEFAULT 'I'
  COMMENT '对账文件方式, I:接口方式，U: 网银下载',
  is_beta            CHAR(1)      NOT NULL DEFAULT 'Y'
  COMMENT '是否内测环境，默认为 是',
  add_card_state     CHAR(1)               DEFAULT 'Y'
  COMMENT '绑卡状态 Y:可用， N:关闭',
  add_card_tip       VARCHAR(200) NOT NULL DEFAULT ''
  COMMENT '绑卡关闭提示',
  recharge_state     CHAR(1)               DEFAULT 'Y'
  COMMENT '充值状态 Y:可用， N:关闭',
  recharge_tip       VARCHAR(200) NOT NULL DEFAULT ''
  COMMENT '充值关闭提示',
  withdraw_state     CHAR(1)               DEFAULT 'Y'
  COMMENT '取现状态 Y:可用， N:关闭',
  withdraw_tip       VARCHAR(200) NOT NULL DEFAULT ''
  COMMENT '取现关闭提示',
  fast_cash_state    CHAR(1)               DEFAULT 'Y'
  COMMENT '快速取现状态 Y:可用， N:关闭',
  fast_cash_tip      VARCHAR(200) NOT NULL DEFAULT ''
  COMMENT '快速取现关闭提示',
  del_card_state     CHAR(1)               DEFAULT 'Y'
  COMMENT '删卡状态 Y:可用， N:关闭',
  del_card_tip       VARCHAR(200) NOT NULL DEFAULT ''
  COMMENT '删卡关闭提示',
  is_delete          TINYINT(4)   NOT NULL DEFAULT '0'
  COMMENT '是否有效,0:有效，1:无效',
  created_at         TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '数据创建时间',
  updated_at         TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '数据更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY be_channel_conf_unique (bank_no)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '银行通道配置表';

CREATE INDEX ix_bank_no
  ON be_channel_conf (bank_no);

CREATE INDEX ix_created_at
  ON be_channel_conf (created_at);

CREATE INDEX ix_updated_at
  ON be_channel_conf (updated_at);

DROP TABLE
IF EXISTS be_command;

CREATE TABLE be_command (
  id                   BIGINT(20)  NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  serial_no            VARCHAR(24) NOT NULL
  COMMENT '交易流水号',
  bnk_no               VARCHAR(3)  NOT NULL
  COMMENT '银行代码',
  mer_org_serial_no    VARCHAR(24) COMMENT '商户原始交易流水号',
  bnk_org_serial_no    VARCHAR(24) COMMENT '银行原始交易流水',
  mer_date             VARCHAR(8) COMMENT '商户交易日期',
  mer_time             VARCHAR(6) COMMENT '商户交易时间',
  mer_org_date         VARCHAR(8) COMMENT '商户原始交易日期',
  mer_org_time         VARCHAR(6) COMMENT '商户原始交易时间',
  bnk_org_date         VARCHAR(8) COMMENT '银行原始交易日期',
  bnk_org_time         VARCHAR(6) COMMENT '银行原始交易时间',
  last_try_date        VARCHAR(8) COMMENT '上次尝试日期',
  last_try_time        VARCHAR(6) COMMENT '上次尝试时间',
  last_snd_date        VARCHAR(8) COMMENT '上次发送日期',
  last_snd_time        VARCHAR(6) COMMENT '上次发送时间',
  last_qry_serial_no   VARCHAR(24) COMMENT '上次查询流水号',
  last_qry_date        VARCHAR(8) COMMENT '上次查询日期',
  last_qry_time        VARCHAR(6) COMMENT '上次查询时间',
  input_date           VARCHAR(8) COMMENT '指令生成日期',
  input_time           VARCHAR(6) COMMENT '指令生成时间',
  mer_tran_co          VARCHAR(10) COMMENT '商户交易代码',
  bnk_tran_co          VARCHAR(20) COMMENT '银行交易代码',
  mer_org_tran_co      VARCHAR(10) COMMENT '商户原始交易代码',
  bnk_org_tran_co      VARCHAR(20) COMMENT '银行原始交易代码',
  tran_tp              VARCHAR(2) COMMENT '交易类型',
  syn_flg              VARCHAR(2) COMMENT '同步标记，01-同步，02-异步',
  bat_flg              VARCHAR(2) COMMENT '批量标记，01-批量，02-单笔，03-汇总',
  acount               NUMERIC(16, 0) COMMENT '批量笔数',
  retry_flg            VARCHAR(2) COMMENT '重试标记，01-可重试，02-不可重试',
  retry_max_time       NUMERIC(5, 0) COMMENT '重试最大次数',
  retry_interval       NUMERIC(5, 0) COMMENT '重试间隔',
  retry_counter        NUMERIC(5, 0) COMMENT '重试次数',
  resnd_flg            VARCHAR(2) COMMENT '重发标记，01-可重发，02-不可重发',
  resnd_max_time       NUMERIC(5, 0) COMMENT '重发最大次数',
  resnd_interval       NUMERIC(5, 0) COMMENT '重发间隔',
  resnd_counter        NUMERIC(5, 0) COMMENT '重发次数',
  qry_flg              VARCHAR(2) COMMENT '查询标记，01-可查询，02-不可查询',
  qry_tran_co          VARCHAR(20) COMMENT '查询交易代码',
  qry_max_time         NUMERIC(5, 0) COMMENT '查询最大次数',
  qry_interval         NUMERIC(5, 0) COMMENT '查询间隔',
  qry_counter          NUMERIC(5, 0) COMMENT '查询次数',
  priority             NUMERIC(2, 0) COMMENT '优先级，1，2，3，4，5',
  model                VARCHAR(2) COMMENT '处理模式，01-b2b，02-b2c，03-网银',
  product_id           VARCHAR(20) COMMENT '产品id',
  product_tp           VARCHAR(20) COMMENT '产品类型',
  cur_co               VARCHAR(3) COMMENT '币种',
  amount               DECIMAL(16, 2) COMMENT '转账金额',
  fee_amt              DECIMAL(16, 2) COMMENT '手续费',
  tran_purpose         VARCHAR(320) COMMENT '转账用途',
  tran_remark          VARCHAR(320) COMMENT '转账附言',
  ref_app_no           VARCHAR(24) COMMENT '业务申请编号',
  ref_app_kind         VARCHAR(3) COMMENT '业务申请类型',
  rcvr_bnk_no          VARCHAR(3) COMMENT '收款方银行代码',
  rcvr_acct_no         VARCHAR(64) COMMENT '收款方账号',
  rcvr_acct_nm         VARCHAR(64) COMMENT '收款方账号名称',
  rcvr_id_tp           VARCHAR(10) COMMENT '收款方证件类型',
  rcvr_id_no           VARCHAR(35) COMMENT '收款方证件号码',
  rcvr_province        VARCHAR(32) COMMENT '收款方银行省份',
  rcvr_city            VARCHAR(32) COMMENT '收款方银行城市',
  rcvr_area_co         VARCHAR(10) COMMENT '收款方地区代码',
  rcvr_area_nm         VARCHAR(32) COMMENT '收款方地区名称',
  rcvr_mer_id          VARCHAR(15) COMMENT '收款方商户代码',
  rcvr_mer_cert_id     VARCHAR(15) COMMENT '收款方商户证书代码',
  rcvr_post_id         VARCHAR(30) COMMENT '收款方柜台代码',
  rcvr_contract_no     VARCHAR(24) COMMENT '收款方企业协议编号',
  rcvr_contract_dt     VARCHAR(8) COMMENT '收款方企业协议日期',
  rcvr_proto_no        VARCHAR(30) COMMENT '收款方个人缴费编号',
  rcvr_mer_user_tp     VARCHAR(30) COMMENT '收款方商户用户类型',
  rcvr_mer_user_id     VARCHAR(30) COMMENT '收款方商户用户id',
  rcvr_bnk_user_tp     VARCHAR(30) COMMENT '收款方银行用户类型 (目前不用)',
  rcvr_bnk_user_id     VARCHAR(30) COMMENT '收款方银行用户id (目前不用)',
  rcvr_resv1           VARCHAR(30) COMMENT '收款方保留字段',
  rcvr_resv2           VARCHAR(100) COMMENT '收款方保留字段',
  sndr_bnk_no          VARCHAR(3) COMMENT '付款方银行代码',
  sndr_name            VARCHAR(64) COMMENT '付款方商户用户名(建行定投使用)',
  sndr_acct_no         VARCHAR(64) COMMENT '付款方账号',
  sndr_acct_nm         VARCHAR(64) COMMENT '付款方账号名称',
  sndr_id_tp           VARCHAR(10) COMMENT '付款方证件类型',
  sndr_id_no           VARCHAR(35) COMMENT '付款方证件号码',
  sndr_province        VARCHAR(32) COMMENT '付款方银行省份',
  sndr_city            VARCHAR(32) COMMENT '付款方银行城市',
  sndr_area_co         VARCHAR(10) COMMENT '付款方地区代码',
  sndr_area_nm         VARCHAR(32) COMMENT '付款方地区名称',
  sndr_mer_id          VARCHAR(15) COMMENT '付款方商户代码',
  sndr_mer_cert_id     VARCHAR(15) COMMENT '付款方商户证书代码',
  sndr_post_id         VARCHAR(30) COMMENT '付款方收款方柜台代码',
  sndr_contract_no     VARCHAR(24) COMMENT '付款方企业协议编号',
  sndr_contract_dt     VARCHAR(8) COMMENT '付款方企业协议日期',
  sndr_proto_no        VARCHAR(100) COMMENT '付款方个人缴费编号',
  sndr_mer_user_tp     VARCHAR(30) COMMENT '付款方商户用户类型',
  sndr_mer_user_id     VARCHAR(30) COMMENT '付款方商户用户id',
  sndr_bnk_user_tp     VARCHAR(30) COMMENT '付款方银行用户类型',
  sndr_bnk_user_id     VARCHAR(30) COMMENT '付款方银行用户id',
  sndr_resv1           VARCHAR(100) COMMENT '付款方保留字段',
  sndr_resv2           VARCHAR(100) COMMENT '付款方保留字段',
  lock_st              VARCHAR(24) COMMENT '锁状态 n-未上锁，t-尝试发送锁，r-重新发送锁，q-查询锁',
  tran_st              VARCHAR(1) COMMENT '交易状态 n-待处理，y-成功，f-失败，i-处理中，e-异常',
  rvrs_st              VARCHAR(1) COMMENT '冲正状态 y-未冲正，r-已冲正',
  product_nm           VARCHAR(40) COMMENT '产品名称',
  app_version          VARCHAR(20) NOT NULL DEFAULT '5.0'
  COMMENT '应用程序版本号',
  sndr_bnk_branch_name VARCHAR(240) COMMENT '付款方分行号',
  rcvr_bnk_branch_name VARCHAR(240) COMMENT '收款方分行号',
  app_source           VARCHAR(3)           DEFAULT NULL
  COMMENT '应用来源。1:直销  2：信用卡还款体验 3：代表cif 4：手机 5：代表开放平台',
  is_delete            TINYINT(4)  NOT NULL DEFAULT '0'
  COMMENT '是否有效,0:有效，1:无效',
  created_at           TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '数据创建时间',
  updated_at           TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '数据更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY be_command_unique (serial_no)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '银行指令表';

CREATE INDEX ix_created_at
  ON be_command (created_at);

CREATE INDEX ix_updated_at
  ON be_command (updated_at);

CREATE UNIQUE INDEX ix_ref_app_no
  ON be_command (ref_app_no);

CREATE INDEX ix_tran_tp
  ON be_command (tran_tp);

CREATE INDEX ix_mer_date
  ON be_command (mer_date);