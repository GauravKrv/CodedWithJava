package Patterns.behavorialChainOfResponsibility;

public abstract class RequestHandler {
    private final RequestHandler next;
    public boolean canHandle;

    public RequestHandler() {
        this.next = null;
    }

    public void handleRequest(Request req){
        if (next!=null){
            next.handleRequest(req);
        }
    }

    public boolean canHandleRequest(){
        return this.canHandle;
    }

    protected void printHandling(Request req) {
        this.canHandle = true;
        System.out.println(this+" handling request " + req);
    }

    @Override
    public abstract String toString();
}
