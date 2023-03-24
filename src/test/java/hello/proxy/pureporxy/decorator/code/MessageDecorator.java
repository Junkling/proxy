package hello.proxy.pureporxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {
    private Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("messageDecorator 실행");
        String operation = component.operation();
        String decoResult = "****" + operation + "****";
        log.info("꾸미지건 ={}, 후={}", operation, decoResult);
        return decoResult;
    }
}
