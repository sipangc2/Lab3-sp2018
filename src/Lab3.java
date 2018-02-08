import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Lab3 {

        /**
         * Retrieve contents from a URL and return them as a string.
         *
         * @param url url to retrieve contents from
         * @return the contents from the url as a string, or an empty string on error
         */

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

        public static int countwords(final String strurl) {
                int word = 0;
                for (int i = 0; i < strurl.length(); i++) {
                        if (!Character.isLetter(strurl.charAt(i))) {
                            word++;
                            if (!Character.isLetter(strurl.charAt(i+1))) {
                                word--;
                                if (strurl.charAt(i) == '.') {
                                    word++;
                                }
                            }
                        }
                }
                return word;
        }

        /**
         *
         * @param unused
         */

        public static void main(String[] unused) {
            Scanner lineScanner = new Scanner(System.in);
            System.out.println("Enter a url: ");
            String inputurl = lineScanner.nextLine();
            String stringurl = urlToString(inputurl);
            System.out.println("The word count is: ");
            System.out.println(countwords(stringurl));
        }
}
