import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String[] S1;
    static String[] S2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S1 = st.nextToken().split("");

        st = new StringTokenizer(br.readLine());
        S2 = st.nextToken().split("");

        dp = new int[S1.length + 1][S2.length + 1];
        for (int i = 1; i <= S1.length; i++) { //문자 하나 결정
            for (int j = 1; j <= S2.length; j++) {
                if (S1[i - 1].equals(S2[j - 1])) { //두 문자가 같으면
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { //두 문자열이 다르면 둘 중 하나 지운 값중 큰 것을 가져오겠다.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[S1.length][S2.length]);
    }
}
