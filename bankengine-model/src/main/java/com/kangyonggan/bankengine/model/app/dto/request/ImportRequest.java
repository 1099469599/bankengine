package com.kangyonggan.bankengine.model.app.dto.request;

import com.kangyonggan.bankengine.model.BaseObject;
import lombok.Data;

/**
 * 对账导入请求
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
@Data
public class ImportRequest extends BaseObject {

    /**
     * 银行对账文件导入日志id
     */
    private String bankFileUploadLogId;

    private String bankNo;

    private String importDate;

}
