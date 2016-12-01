package com.kangyonggan.bankengine.model.app;

import com.kangyonggan.bankengine.model.BaseObject;
import lombok.Data;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Data
public class Result<M> extends BaseObject {

    private int errorCode;

    private String errorMessage = "操作成功";

    private M model;

    public Result() {
    }

    public Result(int errorCode, String errorMessage, M model) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.model = model;
    }
}
