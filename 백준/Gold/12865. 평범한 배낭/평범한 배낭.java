import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, B;
    static int[][] items;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        items = new int[N + 1][2];
        dp = new int[N + 1][B + 1]; //물건의 개수, 가방의 무게에 따른 경우를 나눔

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int idx = 1; idx < N + 1; idx++) { //물건 개수1~N
            for (int weight = 1; weight < B + 1; weight++) { //배낭 무게 1~N
                if (weight < items[idx][0]) { //현재 배낭의 무게 < 현재 물건의 무게 : 가방에 담을 수 없음
                    dp[idx][weight] = dp[idx - 1][weight];
                } else { //현재 배낭의 무게 > 현재 물건의 무게 : 가방에 담을 수 있음
                    dp[idx][weight] = Math.max(dp[idx - 1][weight], dp[idx - 1][weight - items[idx][0]] + items[idx][1]);
                }
            }
        }

        System.out.println(dp[N][B]);

    }
}
