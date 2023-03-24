package hello.proxy.pureporxy.decorator;

import hello.proxy.pureporxy.decorator.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {
    @Test
    void noDeco() {
        Component component = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(component);
        client.execute();
    }

    @Test
    void deco1() {
        Component realComponent = new RealComponent();
        Component messageDeco = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDeco);
        client.execute();
    }

    @Test
    void deco2() {
        Component realCom = new RealComponent();
        Component messageDeco = new MessageDecorator(realCom);
        Component timeDeco = new TimeDecorator(messageDeco);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDeco);
        client.execute();
        
    }
}
