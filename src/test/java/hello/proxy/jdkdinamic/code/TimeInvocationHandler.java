package hello.proxy.jdkdinamic.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
@RequiredArgsConstructor
@Slf4j
public class TimeInvocationHandler implements InvocationHandler {
    private final Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("time proxy 실행");
        Long startTime = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        Long endTime = System.currentTimeMillis();
        Long resultTime = endTime - startTime;
        log.info("time proxy 종료 resultTime ={}", resultTime);
        return result;
    }
}
