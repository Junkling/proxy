package hello.proxy.cglib.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@RequiredArgsConstructor
@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {
    private final Object target;

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("time proxy 실행");
        Long startTime = System.currentTimeMillis();
        Object result = methodProxy.invoke(target, args);
        Long endTime = System.currentTimeMillis();
        Long resultTime = endTime - startTime;
        log.info("time proxy 종료 resultTime ={}", resultTime);
        return result;
    }
}
