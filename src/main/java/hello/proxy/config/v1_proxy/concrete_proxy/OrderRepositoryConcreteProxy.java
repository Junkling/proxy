package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {
    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus st = null;
        try {
            st = logTrace.begin("OrderRepository.request");
            //target 호출
            target.save(itemId);
            logTrace.end(st);

        } catch (Exception e) {
            logTrace.exception(st, e);
            e.printStackTrace();
        }
    }
}
