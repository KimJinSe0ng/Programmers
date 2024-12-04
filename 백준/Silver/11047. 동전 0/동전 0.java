import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] coins;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coins);

        int idx = N - 1;
        while (K > 0) {
            int coin = coins[idx];
            count += K / coin;
            K %= coin;
            idx--;
        }

        System.out.println(count);
    }
}
