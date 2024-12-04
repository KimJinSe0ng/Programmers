import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] primes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        primes = new boolean[1001];
        int totalPrime = 0;

        calculatePrime();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (primes[number]) {
                totalPrime++;
            }
        }

        System.out.println(totalPrime);
    }

    private static void calculatePrime() {
        Arrays.fill(primes, true); //모든 값을 소수라고 가정
        primes[0] = false;
        primes[1] = false; //0과 1은 아님

        for (int i = 2; i * i < 1001; i++) {
            if (primes[i]) { //i가 소수라면
                for (int j = i * i; j < 1001; j += i) {
                    primes[j] = false; //i의 배수는 소수가 아님
                }
            }
        }
    }

}
