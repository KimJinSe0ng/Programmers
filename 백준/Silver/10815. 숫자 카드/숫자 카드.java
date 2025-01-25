import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] cards;
    static int M;
    static int[] guess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        guess = new int[M];
        for (int i = 0; i < M; i++) {
            guess[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        Arrays.sort(cards);

        for (int i = 0; i < M; i++) {
            if (binarySearch(guess[i])) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    private static boolean binarySearch(int target) {
        int start = 0;
        int end = cards.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (cards[mid] < target) {
                start = mid + 1;
            } else if (cards[mid] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
