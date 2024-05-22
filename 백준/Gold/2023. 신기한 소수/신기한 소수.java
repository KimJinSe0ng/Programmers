import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    private static void dfs(int num, int digit) {
        if (digit == N) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(num * 10 + i)) {
                dfs(num * 10 + i, digit + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) { //방법1
            if (num % i == 0) {
                return false;
            }
        }
        return true;
//        for (int i = 2; i <= num / 2; i++) { //방법2
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
    }
}
