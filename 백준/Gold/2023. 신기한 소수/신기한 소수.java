import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] oneDigitPrimes = {2, 3, 5, 7};
        for (int prime : oneDigitPrimes) {
            dfs(prime, 1);
        }
    }

    private static void dfs(int num, int digit) {
        if (digit == N) {
            System.out.println(num);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int next = num * 10 + i;
            if (isPrime(next)) {
                dfs(next, digit + 1);
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
