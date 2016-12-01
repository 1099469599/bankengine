package com.kangyonggan.bankengine.model.app;

import com.kangyonggan.bankengine.model.BaseObject;
import com.kangyonggan.bankengine.model.app.vo.BankBnkBase;
import com.kangyonggan.bankengine.model.app.vo.BankMerchant;
import com.kangyonggan.bankengine.model.app.vo.BankTran;
import lombok.Data;

/**
 * 用于包含交易所需的银行设定
 *
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public class BankSetting extends BaseObject {

    private BankTran bankTran;

    private BankMerchant bankMerchant;

    private BankBnkBase bankBnkBase;

}
