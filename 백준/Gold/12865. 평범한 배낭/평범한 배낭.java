import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 탑 다운 dp
    static int N, B;
    static int[][] items;
    static int answer = 0;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        items = new int[N][2];
        dp = new int[N][100_001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        recur(0, 0);
        System.out.println(dp[0][0]);
    }

    private static int recur(int idx, int weight) {
        if (weight > B) {
            return Integer.MIN_VALUE;
        }

        if (idx == N) {
            return 0;
        }

        if (dp[idx][weight] != -1) {
            return dp[idx][weight];
        }

        dp[idx][weight] = Math.max(recur(idx + 1, weight + items[idx][0]) + items[idx][1], recur(idx + 1, weight));

        return dp[idx][weight];
    }
}
