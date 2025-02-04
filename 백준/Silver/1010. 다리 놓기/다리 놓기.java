import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        D = new int[31][31];
        for (int i = 0; i < 31; i++) {
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }

        for (int i = 2; i < 31; i++) {
            for (int j = 1; j < 31; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(D[M][N]);
        }
    }
}
