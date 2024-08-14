import java.util.*;
import java.io.*;

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
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) { //첫 번째 집 초기화, 초기화를 하지 않는다면, 밑에 for문 idx = 1부터 시작
            dp[1][i] = colors[1][i];
        }

        for (int idx = 2; idx <= N; idx++) {
            for (int rgb = 0; rgb < 3; rgb++) { //rgb는 현재 선택한 색상
                if (rgb == 0) { //현재 빨강을 칠한 상황에선 나머지 비용 중 작은 걸 비용으로 합치겠다.
                    dp[idx][rgb] = Math.min(dp[idx - 1][1], dp[idx - 1][2]) + colors[idx][rgb];
                }
                if (rgb == 1) {
                    dp[idx][rgb] = Math.min(dp[idx - 1][0], dp[idx - 1][2]) + colors[idx][rgb];
                }
                if (rgb == 2) {
                    dp[idx][rgb] = Math.min(dp[idx - 1][0], dp[idx - 1][1]) + colors[idx][rgb];
                }
            }
        }

        int result = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
        System.out.println(result);

    }
}
