import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] pole;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        pole = new int[N][2];
        dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pole[i][0] = a;
            pole[i][1] = b;
        }

        //왼쪽 전봇대에서 번호 순으로 정렬
        Arrays.sort(pole, Comparator.comparingInt(a -> a[0]));

        int max = 0;

        //최장 증가 부분수열 찾기
        for (int i = 0; i < N; i++) { //왼쪽 전봇대 번호 선택
            for (int j = 0; j < i; j++) { //오른쪽 전봇대는 왼쪽 전봇대 번호만큼까지만 확인
                if (pole[i][1] > pole[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);

    }
}
