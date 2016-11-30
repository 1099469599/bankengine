package com.kangyonggan.bankengine.model.app.dto.response;

import lombok.Data;

/**
 * 对账导入响应
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
@Data
public class ImportResponse extends CommonResponse {

    /**
     * 导入笔数
     */
    private int importCount;

}
