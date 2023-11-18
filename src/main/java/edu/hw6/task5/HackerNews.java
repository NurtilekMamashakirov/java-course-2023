package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {

    private static final int CONST_SIZE = 100;
    private final static String URI_FORMAT_TO_GET_NEW_NAME = "https://hacker-news.firebaseio.com/v0/item/%s.json";
    private final static String URI_TO_GET_TOP_NEWS = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private final static Pattern NAME_PATTERN = Pattern.compile("\"title\":\"([^\"]+)\"");

    public static long[] hackerNewsTopStories() {
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                .uri(new URI(URI_TO_GET_TOP_NEWS))
                .GET()
                .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            String stringToParse = responseBody.substring(1, responseBody.length() - 1);
            long[] parsedResponse = Arrays.stream(stringToParse.split(","))
                .mapToLong(Long::parseLong).toArray();
            return parsedResponse;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return new long[CONST_SIZE];
    }

    public static String news(Long id) {
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                .uri(new URI(String.format(URI_FORMAT_TO_GET_NEW_NAME, id)))
                .GET()
                .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            return getName(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getName(String responseBody) {
        Matcher matcher = NAME_PATTERN.matcher(responseBody);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

}
