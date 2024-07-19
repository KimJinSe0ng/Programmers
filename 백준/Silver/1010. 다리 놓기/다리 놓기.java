import java.util.Scanner;

public class Main {
    static long[][] D;
    public static void main(String[] args) {
        D = new long[31][31];
        for (int i = 0; i <= 30; i++) {
            D[i][1] = i; //i개 중 1개를 뽑는 경우의 수는 i개
            D[i][0] = 1; //i개 중 1개도 선택하지 않는 경우의 수는 1개
            D[i][i] = 1; //i개 중 i개를 선택하는 경우의 수는 1개
        }

        for (int i = 2; i <= 30; i++) {
            for (int j = 1; j < i; j++) { //고르는 수의 개수가 전체 개수를 넘을 수 없음
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(D[M][N]);
        }
    }
}
