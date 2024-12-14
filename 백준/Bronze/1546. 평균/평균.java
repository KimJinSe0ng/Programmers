import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        scores = new int[N];
        int maxScore = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            maxScore = Math.max(maxScore, scores[i]);
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (double) scores[i] / maxScore * 100;
        }

        System.out.println(sum / N);
    }
}
