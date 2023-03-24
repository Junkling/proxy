package hello.proxy.pureporxy.proxy;

import hello.proxy.pureporxy.proxy.code.CacheProxy;
import hello.proxy.pureporxy.proxy.code.ProxyPattenClient;
import hello.proxy.pureporxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPattenTest {
    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPattenClient client = new ProxyPattenClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void proxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        ProxyPattenClient client = new ProxyPattenClient(cacheProxy);
        client.execute();
        client.execute();
        client.execute();
    }
}
