import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = A[0];
        for (int i = 0; i < N; i++) {
            dp[i + 1] = Math.max(dp[i] + A[i], A[i]);
            max = Math.max(max, dp[i + 1]);
        }

        System.out.println(max);
    }
}
