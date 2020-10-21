package com.natsumes.demo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author hetengjiao
 */
public class HttpClientDemo {

    public static void main(String[] args) throws Exception{
        httpSync();
        httpAsync();
    }

    /**
     * 同步调用
     */
    private static void httpSync() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/httpdemo")).build();
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response = client.send(request, handler);
        String body = response.body();
        System.out.println(body);
    }

    /**
     * 异步调用
     */
    private static void httpAsync() throws ExecutionException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/httpdemo")).build();
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> responseCompletableFuture = client.sendAsync(request, handler);
        HttpResponse<String> response = responseCompletableFuture.get();
        String body = response.body();
        System.out.println(body);
    }
}
