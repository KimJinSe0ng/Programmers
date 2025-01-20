import java.io.*;
import java.util.*;

public class Main {
    static int[] alpha = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().trim().toUpperCase();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                alpha[c - 'A']++;
            }
        }

        int maxCount = 0;
        char maxChar = '?';
        boolean isDuplicate = false;

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] > maxCount) {
                maxCount = alpha[i];
                maxChar = (char) (i + 'A');
                isDuplicate = false;
            } else if (alpha[i] == maxCount) {
                isDuplicate = true;
            }
        }

        if (isDuplicate) {
            System.out.println("?");
        } else {
            System.out.println(maxChar);
        }
    }
}
