package com.kangyonggan.bankengine.biz.util;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 打印入参合出参，打印方法执行时间
 *
 * @author kangyonggan
 * @since 2016/11/30
 */
@Component
@Log4j2
public class LogAop {

    /**
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Class clazz = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Object args[] = joinPoint.getArgs();

        String targetName = "LogAop[" + clazz.getName() + "." + methodName + "] - ";
        log.info(targetName + args);

        long beginTime = DateUtils.getNow().getTime();
        Object result = joinPoint.proceed(args);
        long endTime = DateUtils.getNow().getTime();

        log.info(targetName + "耗时" + (endTime - beginTime) + "ms");
        return result;
    }

}
