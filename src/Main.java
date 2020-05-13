import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static boolean validateUrl(String url) {
        String urlRegex = "^(http|https)://[-a-zA-Z0-9+&@#/%?=~_|,!:.;]*[-a-zA-Z0-9+@#/%=&_|]";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher m = pattern.matcher(url);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static void scrapeLinks(String url) {
        System.out.println(url);

        try {
            final Document document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (!validateUrl(args[0])) {
            System.out.println("Please enter a valid link.");
        } else {
            scrapeLinks(args[0]);
        }
    }
}
