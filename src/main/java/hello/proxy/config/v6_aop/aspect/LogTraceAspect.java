package hello.proxy.config.v6_aop.aspect;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@RequiredArgsConstructor
public class LogTraceAspect {
    private final LogTrace logTrace;

    @Around("execution(* hello.proxy.app..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        TraceStatus st = null;
        try {
            String message = joinPoint.getSignature().toShortString();
            st = logTrace.begin(message);
            Object result = joinPoint.proceed();
            logTrace.end(st);
            return result;
        } catch (Exception e) {
            logTrace.exception(st, e);
            e.printStackTrace();
            throw e;
        }
    }
}
