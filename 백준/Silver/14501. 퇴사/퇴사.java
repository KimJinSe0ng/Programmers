import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에 N이 주어집니다.
        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][2]; // 인터뷰 정보 저장
        long[] dp = new long[N + 1]; // 최대 수익 저장

        // 인터뷰 정보 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken()); // 인터뷰 기간
            table[i][1] = Integer.parseInt(st.nextToken()); // 인터뷰 수익
        }

        // 바텀업 DP 계산
        for (int idx = N - 1; idx >= 0; idx--) {
            int duration = table[idx][0];
            int profit = table[idx][1];

            // 인터뷰를 할 수 있는 경우와 없는 경우를 나눠서 계산
            if (idx + duration > N) {
                dp[idx] = dp[idx + 1];
            } else {
                dp[idx] = Math.max(dp[idx + duration] + profit, dp[idx + 1]);
            }
        }

        // 결과 출력
        System.out.println(dp[0]);
    }
}
