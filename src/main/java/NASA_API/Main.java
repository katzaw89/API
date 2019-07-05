package NASA_API;

import com.google.gson.Gson;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackAttachment;
import net.gpedro.integrations.slack.SlackMessage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {
    public static final String API_URL = "https://api.nasa.gov/planetary/apod?api_key=4h6MhQpCRu4HecvbO49Sxb2YLpoa2CFv6qcRfXiX";
    public static final Gson GSON = new Gson();


    public static void main(String[] args) throws IOException {
        String API_URL = "https://api.nasa.gov/planetary/apod?api_key=4h6MhQpCRu4HecvbO49Sxb2YLpoa2CFv6qcRfXiX";
        SlackApi api = new SlackApi("https://hooks.slack.com/services/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");
        String text = downloadTextFromUrl(API_URL);
        Gson GSON = new Gson();
        Nasa nasa = downloadNasa();
        NasaImage nasaImage = GSON.fromJson(text, NasaImage.class);
        System.out.println(nasaImage.url);

        SlackMessage slackMessage = new SlackMessage(nasa.getTitle() + "\n\n" + nasa.getExplanation() + "\n\n" + nasa.getDate() + "\n\n" + nasa.getUrl());
        SlackAttachment slackAttachment = new SlackAttachment();
        slackAttachment.setImageUrl(String.valueOf(nasaImage.url));
        slackAttachment.setFallback("Nasa image");
        slackMessage.addAttachments(slackAttachment);
        api.call(slackMessage);

        BufferedImage image = ImageIO.read(new URL(nasa.getHdurl()));
//        File fileWith = new File("nasa");


    }


    private static String downloadTextFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        InputStream is = url.openStream();
        Scanner scanner = new Scanner(is);
        return scanner.nextLine();
    }


    public static Nasa downloadNasa() throws IOException {
        URL url = new URL(API_URL);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Chrome");
        InputStream is = connection.getInputStream();
        try (Scanner scanner = new Scanner(is)) {
            String lines = scanner.nextLine();
            return GSON.fromJson(lines, Nasa.class);
        }
    }
}
