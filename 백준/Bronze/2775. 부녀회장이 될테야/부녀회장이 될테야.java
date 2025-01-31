import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N, K;
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        D = new int[15][15]; // 0층~14층

        for (int i = 1; i <= 14; i++) {
            D[i][1] = 1;
            D[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 2; j <= 14; j++) {
                D[i][j] = D[i][j - 1] + D[i - 1][j];
            }
        }

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            System.out.println(D[N][K]);
        }
    }
}
