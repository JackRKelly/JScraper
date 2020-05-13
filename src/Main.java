import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static boolean printUrls(String[] urls) {

    }

    private static boolean validateUrl(String url) {
        String urlRegex = "^(http|https)://[-a-zA-Z0-9+&@#/%?=~_|,!:.;]*[-a-zA-Z0-9+@#/%=&_|]";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static void scrapeLinks(String url) {
        String urlRegex = "<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1";
        Pattern pattern = Pattern.compile(urlRegex);
        String[] final_matches;
        try {
            final Document document = Jsoup.connect(url).get();
            Matches matches = pattern.matches(document);
            printUrls(matches);
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
