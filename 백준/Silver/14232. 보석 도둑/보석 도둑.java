import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        List<Long> factors = primeFactorization(k);

        System.out.println(factors.size());
        for (long factor : factors) {
            System.out.print(factor + " ");
        }
    }

    private static List<Long> primeFactorization(long n) {
        List<Long> factors = new ArrayList<>();

        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        Collections.sort(factors);
        return factors;
    }
}
