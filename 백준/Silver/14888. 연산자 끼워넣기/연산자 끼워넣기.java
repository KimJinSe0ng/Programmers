import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        operators = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(1, numbers[0]);

        System.out.println(maxResult);
        System.out.println(minResult);

    }

    private static void backtrack(int idx, int currentResult) {
        if (idx == N) {
            maxResult = Math.max(maxResult, currentResult);
            minResult = Math.min(minResult, currentResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                if (i == 0) { 
                    backtrack(idx + 1, currentResult + numbers[idx]);
                } else if (i == 1) { 
                    backtrack(idx + 1, currentResult - numbers[idx]);
                } else if (i == 2) { 
                    backtrack(idx + 1, currentResult * numbers[idx]);
                } else if (i == 3) { 
                    backtrack(idx + 1, divide(currentResult, numbers[idx]));
                }

                operators[i]++; 
            }
        }
    }

    static int divide(int a, int b) {
        if (a < 0) {
            return -(-a / b);
        } else {
            return a / b;
        }
    }
}
