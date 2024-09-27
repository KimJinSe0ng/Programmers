import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] question;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        question = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            question[i][0] = Integer.parseInt(st.nextToken());
            question[i][1] = Integer.parseInt(st.nextToken());
            question[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int num100 = 1; num100 <= 9; num100++) {
            for (int num10 = 1; num10 <= 9; num10++) {
                for (int num1 = 1; num1 <= 9; num1++) {
                    if (num1 == num10 || num10 == num100 || num100 == num1) {
                        continue;
                    }

                    int passedHintCount = 0;

                    for (int i = 0; i < N; i++) {
                        int guess = question[i][0];
                        int strike = question[i][1];
                        int ball = question[i][2];

                        int guess100 = guess / 100;
                        int guess10 = (guess % 100) / 10;
                        int guess1 = guess % 10;

                        int strike_count = 0;
                        int ball_count = 0;

                        if (num100 == guess100) {
                            strike_count++;
                        }
                        if (num10 == guess10) {
                            strike_count++;
                        }
                        if (num1 == guess1) {
                            strike_count++;
                        }

                        if (num100 == guess10 || num100 == guess1) {
                            ball_count++;
                        }
                        if (num10 == guess100 || num10 == guess1) {
                            ball_count++;
                        }
                        if (num1 == guess100 || num1 == guess10) {
                            ball_count++;
                        }

                        if (strike_count == strike && ball_count == ball) {
                            passedHintCount++;
                        }
                    }

                    if (passedHintCount == N) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
