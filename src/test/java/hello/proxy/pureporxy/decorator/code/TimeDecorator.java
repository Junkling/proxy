package hello.proxy.pureporxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component {
    private Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("timeDeco 실행");
        long start = System.currentTimeMillis();
        String result = component.operation();
        long end = System.currentTimeMillis();
        long resultTime = end - start;
        log.info("timeDeco 종료 resultTime ={}ms",resultTime);

        return result;
    }
}
