import javafx.concurrent.Task;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class SearchTask extends Task<DataCollection> {
    protected String search;

    public SearchTask(String search) {
        this.search = search;
    }

    @Override
    protected DataCollection call() {
        return requestResponse();
    }

    // Creating
    abstract DataCollection requestResponse();

    protected String httpGetRequest(String request) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest getRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(request))
                .build();
        try {
            return client.send(getRequest, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}