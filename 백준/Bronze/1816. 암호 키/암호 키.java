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
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long S = Long.parseLong(st.nextToken());
            if (isPrime(S)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPrime(long S) {
        for (int i = 2; i <= 1000000; i++) {
            if (S % i == 0) { //나눠지면 소수이고, 10^6보다 작으면 NO
                return false;
            }
        }
        return true;
    }
}
