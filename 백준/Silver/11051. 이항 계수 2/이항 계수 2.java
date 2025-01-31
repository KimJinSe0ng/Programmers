import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            D[i][1] = i; // i개 중 1개를 뽑는 경우의 수는 i개
            D[i][i] = 1; // i개 중 i개를 선택하는 경우의 수는 1개
            D[i][0] = 1; // i개 중 1개도 선택하지 않는 경우의 수는 1개
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
                D[i][j] %= 10007;
            }
        }

        System.out.println(D[N][K]);
    }
}
