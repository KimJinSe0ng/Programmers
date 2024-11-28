import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] testCases = new int[T];
        int maxN = 0;

        for (int i = 0; i < T; i++) {
            testCases[i] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, testCases[i]); // 최대 N 값 찾기
        }

        maxN = Math.max(maxN, 1);

        // DP 배열 초기화
        // fibonacci(n) 호출 시 0과 1이 출력되는 횟수를 저장하는 배열을 사용.
        int[][] dp = new int[maxN + 1][2];
        dp[0][0] = 1; // fibonacci(0)에서 0 출력 횟수
        dp[0][1] = 0; // fibonacci(0)에서 1 출력 횟수
        dp[1][0] = 0; // fibonacci(1)에서 0 출력 횟수
        dp[1][1] = 1; // fibonacci(1)에서 1 출력 횟수

        // DP 테이블 채우기
        for (int i = 2; i <= maxN; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int n : testCases) {
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }
        System.out.print(sb);
    }
}
