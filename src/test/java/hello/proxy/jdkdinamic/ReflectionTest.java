package hello.proxy.jdkdinamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {
    @Test
    void reflection0() {
        Hello hello = new Hello();
        //공통로직 1 시작
        log.info("start");
        String s1 = hello.callA();
        log.info("s1 ={}", s1);
        // 1 종료

        //2 시작
        log.info("start");
        String s2 = hello.callB();
        log.info("s2 ={}", s2);
    }

    @Test
    void reflection1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //클래스 정보
        Class classHello = Class.forName("hello.proxy.jdkdinamic.ReflectionTest$Hello");
        Hello hello = new Hello();

        //callA 메서드 정보 얻기
        log.info("start");
        Method callA = classHello.getMethod("callA");
        Object result1 = callA.invoke(hello);
        log.info("result1 ={}", result1);

        //callB 메서드 얻기
        log.info("start");
        Method callB = classHello.getMethod("callB");
        Object result2 = callB.invoke(hello);
        log.info("result2 ={}",result2);
    }
    @Test
    void reflection2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //클래스 정보
        Class classHello = Class.forName("hello.proxy.jdkdinamic.ReflectionTest$Hello");
        Hello hello = new Hello();

        //callA 메서드 정보 얻기
        Method callA = classHello.getMethod("callA");
        dynamicCall(callA, hello);

        //callB 메서드 얻기
        Method callB = classHello.getMethod("callB");
        dynamicCall(callB, hello);
    }

    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("start");
        Object result = method.invoke(target);
        log.info("result={}", result);
    }
    @Slf4j
    static class Hello{
        public String callA() {
            log.info("callA");
            return "A";
        }
        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}

