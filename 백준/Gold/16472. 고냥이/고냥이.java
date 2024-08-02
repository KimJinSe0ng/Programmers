import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().trim().toCharArray();

        int s = 0;
        int e = 0;
        List<Character> letters = new ArrayList<>();
        letters.add(arr[s]);

        int dist = 0;

        while (s < arr.length && e < arr.length) {
            dist = Math.max(dist, e - s + 1);
            if (letters.size() <= n) {
                e += 1;
                if (e < arr.length && !letters.contains(arr[e])) {
                    letters.add(arr[e]);
                }
            }
            if (letters.size() > n) {
                s += 1;
                e = s;
                letters.clear();
                if (s < arr.length) {
                    letters.add(arr[s]);
                }
            }
        }

        System.out.println(dist);
    }
}
