package Patterns.proxy;

public class ProxyUserApplication {
    public static void main(String[] args) {
        ProxyServer proxyServer = new ProxyServer(new CommonInterfaceServerImpl());
        proxyServer.enter(new RequestClass("1"));
        proxyServer.enter(new RequestClass("2"));
        proxyServer.enter(new RequestClass("3"));
        proxyServer.enter(new RequestClass("Request 4"));
    }
}
