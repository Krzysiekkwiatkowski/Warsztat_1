package pl.coderslab.warsztat1.zadanie5;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        String[] table = {"oraz", "ponieważ", "dlatego", "gdyż", "jakże", "jednakże", "dlaczego"};
        Connection connection = Jsoup.connect("https://www.wp.pl/");
        try {
            Document document = connection.get();
            Elements links = document.select("div");
            PrintWriter printWriter = new PrintWriter("popular_words.txt");
            for (Element element : links) {
                StringTokenizer stringTokenizer = new StringTokenizer(element.text(), "!?,.\"\' ");
                while (stringTokenizer.hasMoreTokens()) {
                    String text = stringTokenizer.nextToken().toLowerCase();
                    if (text.length() > 2) {
                        printWriter.println(text);
                    }
                }
            }
            File file = new File("popular_words.txt");
            Scanner scanner = new Scanner(file);
            String word = scanner.nextLine();
            PrintWriter printWrite = new PrintWriter("filtered_popular_words.txt");
            while (scanner.hasNextLine()) {
                if (check(word, table)) {
                    printWrite.println(word);
                }
                word = scanner.nextLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean check(String text, String[] table) {
        for (String word : table) {
            if (text.toLowerCase().equals(word)) {
                return false;
            }
        }
        return true;
    }
}
