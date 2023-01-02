package Patterns.behavorialChainOfResponsibility;

public class PutRequestHandler extends RequestHandler{

    @Override
    public String toString() {
        return "PutRequest";
    }

    @Override
    public void handleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.PUT)) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }
}
