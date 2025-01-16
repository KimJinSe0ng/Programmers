import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long number = Long.parseLong(st.nextToken());
            if (isCorrectPassword(number)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean isCorrectPassword(long number) {
        for (int i = 2; i <= 1_000_000; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
