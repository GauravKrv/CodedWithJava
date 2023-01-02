package Patterns.behavorialChainOfResponsibility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MasterHandler {
    private List<RequestHandler> handlers;

    public MasterHandler() {
        buildChain();
    }

    private void buildChain() {
        handlers = Arrays.asList(new GetRequestHandler(), new PostRequestHandler(), new PutRequestHandler());
    }
//mistake below ???
    public void makeRequest(Request req) {
        handlers
                .stream()

                .map(handler -> {
                    handler.handleRequest(req);
                    return true;
                });
    }

    public static void main(String[] args) {
        var king = new MasterHandler();
        king.makeRequest(new Request(RequestType.GET, "sent response"));
        king.makeRequest(new Request(RequestType.POST, "saved body"));
        king.makeRequest(new Request(RequestType.PUT, "updated data"));
    }
}
