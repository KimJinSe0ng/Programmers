import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<String> words = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (!words.contains(word)) {
                words.add(word);
            }
        }

        Collections.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (String word : words) {
            System.out.println(word);
        }
    }
}
