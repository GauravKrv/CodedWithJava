package Patterns.proxy;

public class CommonInterfaceServerImpl implements CommonInterfaceServer {
    private String serverDistinctProperty;
    public CommonInterfaceServerImpl(){
    }

    public CommonInterfaceServerImpl(String serverDistinctProperty){
        this.serverDistinctProperty = serverDistinctProperty;
    }

    public String getServerDistinctProperty() {
        return serverDistinctProperty;
    }

    public void setServerDistinctProperty(String serverDistinctProperty) {
        this.serverDistinctProperty = serverDistinctProperty;
    }

    @Override
    public void enter(RequestClass requestClass) {
        System.out.println("Entering request: "+requestClass.toString()+" to server: "+this.getServerDistinctProperty());
    }
}
