import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = new long[1001];

        D[1] = 1;
        D[2] = 2;

        for (int i = 3; i <= N; i++) {
            D[i] = (D[i - 2] + D[i - 1]) % 10007;
        }

        System.out.println(D[N]);
    }
}
