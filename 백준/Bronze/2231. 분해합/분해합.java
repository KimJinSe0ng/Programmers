import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = Math.max(1, N - 9 * String.valueOf(N).length()); i < N; i++) {
            if (getDecompositionSum(i) == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    private static int getDecompositionSum(int num) {
        int sum = num;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
