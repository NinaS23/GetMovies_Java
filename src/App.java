import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {

    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI adress = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(adress).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        JsonParse parser = new JsonParse();
        List<Map<String, String>> movieList = parser.parse(body);
     

        for(int i = 0; i < movieList.size(); i++){
            Map<String,String> movie = movieList.get(i);
            System.out.println(" title: " + movie.get("title"));
            System.out.println(" image: " + movie.get("image"));
            System.out.println(" avaliationValue: " + movie.get("imDbRating") +  " ⭐" );
        }
    }
}
