package ChuckNorris;



import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public static final String API_URL = "https://api.chucknorris.io/jokes/random";
    public static final Gson GSON = new Gson();

    public static void main(String[] args) throws IOException {

        Set<ChuckNorrisJoke> jokeSet = new HashSet<>();
        while (jokeSet.size() < 10) {
            ChuckNorrisJoke joke = downloadJoke();
            jokeSet.add(joke);
        }
        for (ChuckNorrisJoke chuckNorrisJoke : jokeSet) {
            System.out.println(chuckNorrisJoke.getValue());
        }

    }

    public static ChuckNorrisJoke downloadJoke() throws IOException {
        URL url = new URL(API_URL);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Chrome");
        InputStream is = connection.getInputStream();
        try (Scanner scanner = new Scanner(is)) {
            String line = scanner.nextLine();

            return GSON.fromJson(line, ChuckNorrisJoke.class);
        }
    }

}