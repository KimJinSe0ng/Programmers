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

        for (int i = 1; i < 10; i++) { //1~9 : 100의자리
            for (int j = 1; j < 10; j++) { //10의자리
                for (int k = 1; k < 10; k++) { //1의자리
                    if (i == j || j == k || k == i) { //숫자 중복은 패스
                        continue;
                    }

                    int count = 0;

                    for (int[] hint : hints) {
                        int number = hint[0];
                        int strike = hint[1];
                        int ball = hint[2];

                        int strike_count = 0;
                        int ball_count = 0;

                        int guess1 = i;
                        int guess2 = j;
                        int guess3 = k;
                        int num1 = number / 100; //100의자리
                        int num2 = (number / 10) % 10; //10의자리
                        int num3 = number % 10; //1의자리

                        if (num1 == guess1) {
                            strike_count++;
                        }
                        if (num2 == guess2) {
                            strike_count++;
                        }
                        if (num3 == guess3) {
                            strike_count++;
                        }

                        if (num1 == guess2 || num1 == guess3) {
                            ball_count++;
                        }
                        if (num2 == guess1 || num2 == guess3) {
                            ball_count++;
                        }
                        if (num3 == guess1 || num3 == guess2) {
                            ball_count++;
                        }

                        if (strike_count == strike && ball_count == ball) {
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
