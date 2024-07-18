import java.util.Scanner;

public class Main {
    static int N, K;
    static int[][] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        D = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            D[i][1] = i; //i개에서 1개 선택하는 경우의 수는 1개
            D[i][0] = 1; //i개에서 1개도 선택하지 않는 경우의 수는 1개
            D[i][i] = 1; //i개에서 모두 선택하는 경우의 수는 1개
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) { //고르는 수의 개수가 전체 개수를 넘을 수 없음
                D[i][j] = (D[i - 1][j] + D[i - 1][j - 1]) % 10007;
            }
        }

        System.out.println(D[N][K]);
    }
}
