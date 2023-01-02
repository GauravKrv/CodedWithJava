package Patterns.behavorialChainOfResponsibility;

public class GetRequestHandler extends RequestHandler{


    @Override
    public String toString() {
        return "GetRequest";
    }

    @Override
    public void handleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.GET)) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }
}
