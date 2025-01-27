import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        prime = new boolean[N + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        calculatePrime();

        for (int i = M; i <= N; i++) {
            if (prime[i]) System.out.println(i);
        }
    }

    private static void calculatePrime() {
        for (int i = 2; i * i <= N; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
