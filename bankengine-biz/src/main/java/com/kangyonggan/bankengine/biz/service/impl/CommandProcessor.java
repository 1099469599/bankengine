package com.kangyonggan.bankengine.biz.service.impl;

import com.kangyonggan.bankengine.model.app.dto.CommandDto;
import com.kangyonggan.bankengine.model.app.dto.ReturnDto;
import lombok.extern.log4j.Log4j2;

/**
 * @author kangyonggan
 * @since 2016/12/1
 */
@Log4j2
public class CommandProcessor {

    /**
     * 执行同步指令 通过指令流水号
     *
     * @param commandDto
     * @param bankNo
     * @param serialNo
     * @return
     */
    public static ReturnDto executeSyn(CommandDto commandDto, String bankNo, String serialNo) {



        return null;
    }
}
