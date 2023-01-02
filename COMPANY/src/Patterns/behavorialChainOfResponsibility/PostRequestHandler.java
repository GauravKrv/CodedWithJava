package Patterns.behavorialChainOfResponsibility;

public class PostRequestHandler extends RequestHandler{



    @Override
    public String toString() {
        return "PostRequest";
    }

    @Override
    public void handleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.POST)) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }
}
