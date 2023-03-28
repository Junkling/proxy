package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends OrderControllerV2 {
    private final OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV2 orderControllerV2, LogTrace logTrace) {
        super(null);
        this.target = orderControllerV2;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus st = null;
        try {
            st = logTrace.begin("OrderController.request()");
            //target 호출
            String result = target.request(itemId);
            logTrace.end(st);
            return result;
        } catch (Exception e) {
            logTrace.exception(st, e);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
