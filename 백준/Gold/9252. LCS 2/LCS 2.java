import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] s1 = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());
        char[] s2 = st.nextToken().toCharArray();

        int[][] dp = new int[s1.length + 1][s2.length + 1];

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    sb.append(s1[i - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[s1.length][s2.length]);

        // LCS 문자열 찾기 (Backtracking)
        StringBuilder lcs = new StringBuilder();
        int i = s1.length, j = s2.length;

        while (i > 0 && j > 0) {
            if (s1[i - 1] == s2[j - 1]) {  // 같은 문자일 경우
                lcs.append(s1[i - 1]);  // LCS에 추가
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;  // 위쪽으로 이동
            } else {
                j--;  // 왼쪽으로 이동
            }
        }

        // LCS 문자열 출력 (역순이므로 뒤집어서 출력)
        if (lcs.length() > 0) {
            System.out.println(lcs.reverse().toString());
        }

    }
}
