import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 바텀 업
    static int N;
    static int[][] interviews;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        interviews = new int[N][2];
        dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            interviews[i][0] = Integer.parseInt(st.nextToken());
            interviews[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            int nextDay = i + interviews[i][0];

            if (nextDay <= N) {
                dp[i] = Math.max(dp[i + 1], dp[nextDay] + interviews[i][1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]); 
    }

}
