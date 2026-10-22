
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Sentence Analysis Program =====");
        System.out.println("Enter a sentence (you can enter multiple words):");
        String line = sc.nextLine();

        System.out.println("Enter a keyword to search in the sentence:");
        String keyword = sc.nextLine();

        line = line.trim();

        String[] words = line.split(" +");

        int wordCount = words.length;
        int keywordCount = 0;
        int vowelCount = 0;

        String shortest = words[0].toLowerCase();

        for (String word : words) {
            String lowerWord = word.toLowerCase();

            if (lowerWord.length() < shortest.length()) {
                shortest = lowerWord;
            }

            if (lowerWord.equals(keyword.toLowerCase())) {
                keywordCount++;
            }
        }

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if ("aeiouAEIOU".indexOf(ch) != -1) {
                vowelCount++;
            }
        }

        StringBuilder cleaned = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                cleaned.append(" ");
            }

            cleaned.append(words[i].toLowerCase());
        }

        cleaned.setCharAt(
            0, Character.toUpperCase(cleaned.charAt(0))
        );

        System.out.println("\n===== Analysis Result =====");
        System.out.println("Sentence: " + cleaned);
        System.out.println("Words: " + wordCount);
        System.out.println("Shortest word: " + shortest);
        System.out.println("Keyword count: " + keywordCount);
        System.out.println("Vowels: " + vowelCount);

        sc.close();
    }
}
