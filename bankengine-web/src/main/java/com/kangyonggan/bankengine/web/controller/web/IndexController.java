package com.kangyonggan.bankengine.web.controller.web;

import com.kangyonggan.bankengine.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kangyonggan
 * @since 2016/11/30
 */
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    private static final String PATH_ROOT = "web/";
    private static final String PATH_INDEX = PATH_ROOT + "index";

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return PATH_INDEX;
    }

}
