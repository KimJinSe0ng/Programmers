import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        int count = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    if (a == b || b == c || c == a) {
                        continue;
                    }

                    int correctCount = 0;

                    for (int[] hint : hints) {
                        int number = hint[0];
                        int strike = hint[1];
                        int ball = hint[2];

                        int number100 = number / 100;
                        int number10 = (number / 10) % 10;
                        int number1 = number % 10;

                        int strike_count = 0;
                        int ball_count = 0;

                        if (number100 == a) {
                            strike_count++;
                        }
                        if (number10 == b) {
                            strike_count++;
                        }
                        if (number1 == c) {
                            strike_count++;
                        }

                        if (number100 == b || number100 == c) {
                            ball_count++;
                        }
                        if (number10 == a || number10 == c) {
                            ball_count++;
                        }
                        if (number1 == b || number1 == a) {
                            ball_count++;
                        }

                        if (strike_count == strike && ball_count == ball) {
                            correctCount++;
                        }
                    }

                    if (correctCount == N) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
