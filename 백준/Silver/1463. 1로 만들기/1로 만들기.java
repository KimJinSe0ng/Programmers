import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];

        dp[1] = 0;
        for (int i = 2; i < N+1; i++)
        {
            dp[i] = dp[i-1]+1; // 1을 뺀다
            if (i % 2 == 0 && dp[i] > dp[i/2]+1) // 2로 나누어 떨어지면, 2로 나눈다.
            {
                dp[i] = dp[i/2]+1;
            }
            if (i % 3 == 0 && dp[i] > dp[i/3]+1) // 3으로 나누어 떨어지면, 3으로 나눈다.
            {
                dp[i] = dp[i/3]+1;
            }
        }
        System.out.println(dp[N]);
    }
}
