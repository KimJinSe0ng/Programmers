import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] cards;
    static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for (int first = 0; first < cards.length - 2; first++) {
            for (int second = first + 1; second < cards.length - 1; second++) {
                for (int third = second + 1; third < cards.length; third++) {
                    if (cards[first] + cards[second] + cards[third] <= M) {
                        maxSum = Math.max(maxSum, cards[first] + cards[second] + cards[third]);
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}
