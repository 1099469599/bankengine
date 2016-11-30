package com.kangyonggan.bankengine.web.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 日志拦截器， 打印输入和输出的日志信息
 *
 * @author kangyonggan
 * @since 2016/10/16
 */
@Log4j2
public class LogInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        if (url.indexOf(".") > 0) {
            return true;
        }
        log.info("请求开始：{}", url);

        Map<String, String[]> params = request.getParameterMap();
        log.info("入参：{}", params);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = request.getRequestURL().toString();
        if (url.indexOf(".") > 0) {
            return;
        }
        log.info("请求结束：{}", url);

        log.info("出参：{}", modelAndView);
    }
}
