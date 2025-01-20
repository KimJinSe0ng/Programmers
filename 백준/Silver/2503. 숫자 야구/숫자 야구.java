import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //재귀
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

        recur(0, 100);
        System.out.println(answer);

    }

    private static void recur(int idx, int num) {
        if (idx == N) {
            answer++;
            recur(0, num + 1);
            return;
        }

        if (num == 1000) return;

        if (checker(idx, num)) recur(idx + 1, num);
        else recur(0, num + 1);
    }

    private static boolean checker(int idx, int num) {
        int hintNumber = hints[idx][0];
        int strike = hints[idx][1];
        int ball = hints[idx][2];

        int strike_count = 0;
        int ball_count = 0;

        int hint100 = hintNumber / 100;
        int hint10 = (hintNumber % 100) / 10;
        int hint1 = hintNumber % 10;

        int guess100 = num / 100;
        int guess10 = (num % 100) / 10;
        int guess1 = num % 10;

        if (guess100 == 0 || guess10 == 0 || guess1 == 0) return false;

        if (guess100 == guess10 || guess10 == guess1 || guess1 == guess100) return false;

        if (guess100 == hint100) strike_count++;
        if (guess10 == hint10) strike_count++;
        if (guess1 == hint1) strike_count++;

        if (guess100 == hint10 || guess100 == hint1) ball_count++;
        if (guess10 == hint100 || guess10 == hint1) ball_count++;
        if (guess1 == hint100 || guess1 == hint10) ball_count++;

        return strike == strike_count && ball == ball_count;
    }
}
