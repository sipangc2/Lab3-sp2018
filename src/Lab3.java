import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */
public class Lab3 {
        public static String urlToString(final String url) {
                Scanner urlScanner;
                try {
                        urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
                } catch (IOException e) {
                        return "";
                }
                String contents = urlScanner.useDelimiter("\\A").next();
                urlScanner.close();
                return contents;
        }
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
}
