import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class WeatherReader {
    
    private static WeatherReader instance;

    int windX = 0;
    int windY = 0;
    
    public WeatherReader(){
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://13.238.167.130/weather"))
        .header("Accept", "text/event-stream")
        .build();

    client.sendAsync(request, HttpResponse.BodyHandlers.ofInputStream())
        .thenApply(HttpResponse::body)
        .thenAccept(inputStream -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                        // System.out.println("Received: " + line);
                        String[] parts = line.split("\\s+");
                        long timestamp = Long.parseLong(parts[0]);
                        String attribute = parts[1];
                        float xCord = Float.parseFloat(parts[2]);
                        float yCord = Float.parseFloat(parts[3]);
                        float value = Float.parseFloat(parts[4]);

                        switch (attribute) {
                            case "windx":
                                windX = (int)((xCord * value)/5);
                                break;
                            case "windy":
                                windX = (int)((yCord * value)/5);
                                break;
                            default:
                                throw new AssertionError();
                        }

                        System.out.println(timestamp + attribute + xCord + yCord + value + "\n");

                }
            } catch (IOException e) {
                System.err.println("Error reading Server Side Event (SSE) stream: " + e.getMessage());
            }
        });
    }

    public static synchronized WeatherReader getInstance() {
        if (instance == null) {
            instance = new WeatherReader();
        }
        return instance;
    }
}
