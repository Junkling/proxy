package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("time proxy 실행");
        Long startTime = System.currentTimeMillis();
//        Object result = method.invoke(target, args);
        Object result = invocation.proceed();
        Long endTime = System.currentTimeMillis();
        Long resultTime = endTime - startTime;
        log.info("time proxy 종료 resultTime ={}", resultTime);
        return result;
    }
}
