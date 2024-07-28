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

        recur(0, 100);
        System.out.println(answer);
    }

    private static boolean checker(int idx, int number) {
        int _number = hints[idx][0];
        int _strike = hints[idx][1];
        int _ball = hints[idx][2];

        int strike = 0;
        int ball = 0;

        int _A = _number / 100;
        int _B = (_number % 100) / 10;
        int _C = _number % 10;

        int A = number / 100;
        int B = (number % 100) / 10;
        int C = number % 10;

        if (A == 0 || B == 0 || C == 0) {
            return false;
        }

        if (A == B || A == C || B == C) {
            return false;
        }

        if (A == _A) strike++;
        if (B == _B) strike++;
        if (C == _C) strike++;

        if (A == _B || A == _C) ball++;
        if (B == _A || B == _C) ball++;
        if (C == _A || C == _B) ball++;

        return strike == _strike && ball == _ball;

    }

    private static void recur(int idx, int num) {
        if (idx == N) {
            answer++;
            recur(0, num + 1); //정답의 개수가 1개 이상일 수 있으니 계속 탐색
            return;
        }

        if (num == 1000) {
            return;
        }

        if (checker(idx, num)) { //힌트를 통과했다면
            recur(idx + 1, num);
        } else {
            recur(0, num + 1);
        }
    }
}
