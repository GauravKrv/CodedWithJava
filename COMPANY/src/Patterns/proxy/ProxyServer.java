package Patterns.proxy;

public class ProxyServer implements CommonInterfaceServer {
    static int requestCount = 3;
    static Integer availableServerCount = 5;

    CommonInterfaceServerImpl commonInterfaceProxy;

    public ProxyServer(CommonInterfaceServerImpl commonInterfaceProxy) {
        this.commonInterfaceProxy = commonInterfaceProxy;
        commonInterfaceProxy.setServerDistinctProperty(availableServerCount.toString());
        availableServerCount--;
    }

    @Override
    public void enter(RequestClass requestClass) {
        if (availableServerCount<=0) {
            System.out.println("Wait for availability of a server...");
            return;//wait -> inc server count & reset req Count to 0
        }
        if (requestCount<=0){
            System.out.println("Server "+commonInterfaceProxy.getServerDistinctProperty()+" overloaded. Routing to another available server");
            requestCount = 3;
            commonInterfaceProxy.setServerDistinctProperty(availableServerCount.toString());
            availableServerCount--;
        }
        commonInterfaceProxy.enter(requestClass);
        requestCount--;
    }
}
