package Patterns.proxy;

public class RequestClass {
    private String reqTypeName;
    public RequestClass(String reqTypeName) {
        this.reqTypeName = reqTypeName;
    }

    @Override
    public String toString() {
        return "Request: "+ reqTypeName;
    }
}
