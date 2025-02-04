import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[][] D;
    static long mod = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            D[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            D[i][0] = D[i - 1][1];
            D[i][9] = D[i - 1][8];
            for (int j = 1; j <= 8; j++) {
                D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % mod;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + D[N][i]) % mod;
        }

        System.out.println(sum);
    }
}
