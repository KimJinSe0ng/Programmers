import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = new long[N + 1][2];

        D[1][1] = 1;
        D[1][0] = 0;

        for (int i = 2; i <= N; i++) {
            D[i][0] = D[i - 1][1] + D[i - 1][0];
            D[i][1] = D[i - 1][0];
        }

        System.out.println(D[N][0] + D[N][1]);
    }
}
