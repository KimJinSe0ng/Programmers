import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] hints;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        hints = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            hints[i][0] = Integer.parseInt(st.nextToken());
            hints[i][1] = Integer.parseInt(st.nextToken());
            hints[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i == j || j == k || k == i) {
                        continue;
                    }

                    int count = 0;
                    
                    for (int[] hint : hints) {
                        int number = hint[0];
                        int strike = hint[1];
                        int ball = hint[2];

                        int guess1 = i, guess2 = j, guess3 = k;
                        int num1 = number / 100;
                        int num2 = (number / 10) % 10;
                        int num3 = number % 10;

                        int strike_count = 0;
                        int ball_count = 0;

                        if (guess1 == num1) strike_count++;
                        if (guess2 == num2) strike_count++;
                        if (guess3 == num3) strike_count++;

                        if (guess1 == num2 || guess1 == num3) ball_count++;
                        if (guess2 == num1 || guess2 == num3) ball_count++;
                        if (guess3 == num1 || guess3 == num2) ball_count++;

                        if (strike == strike_count && ball == ball_count) {
                            count++;
                        }
                    }

                    if (count == N) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
