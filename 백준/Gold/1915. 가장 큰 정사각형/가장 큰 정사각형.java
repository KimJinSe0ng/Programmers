import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static long[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        D = new long[1001][1001];
        long max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                D[i][j] = Long.parseLong(line.substring(j, j + 1));
                if (D[i][j] == 1 && j > 0 && i > 0) {
                    D[i][j] = Math.min(D[i - 1][j - 1], Math.min(D[i - 1][j], D[i][j - 1])) + D[i][j];
                }
                if (max < D[i][j]) {
                    max = D[i][j];
                }
            }
        }

        System.out.println(max * max);
    }
}
