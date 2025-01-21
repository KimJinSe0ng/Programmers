import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] colors;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        colors = new int[N + 1][3];
        dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken()); // 빨
            colors[i][1] = Integer.parseInt(st.nextToken()); // 초
            colors[i][2] = Integer.parseInt(st.nextToken()); // 파
        }

        for (int i = 0; i < 3; i++) {
            dp[1][i] = colors[1][i];
        }

        for (int idx = 2; idx <= N; idx++) {
            for (int rgb = 0; rgb < 3; rgb++) {
                if (rgb == 0) {
                    dp[idx][rgb] = Math.min(dp[idx - 1][1], dp[idx - 1][2]) + colors[idx][rgb];
                } else if (rgb == 1) {
                    dp[idx][rgb] = Math.min(dp[idx - 1][0], dp[idx - 1][2]) + colors[idx][rgb];
                } else {
                    dp[idx][rgb] = Math.min(dp[idx - 1][0], dp[idx - 1][1]) + colors[idx][rgb];
                }
            }
        }

        int result = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
        System.out.println(result);
    }
}
