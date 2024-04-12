import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] D = new long[1001];
        D[1] = 1; //길이가 2*1일 때 타일의 경우의 수
        D[2] = 2; //길이가 2*2일 때 타일의 경우의 수
        for (int i = 3; i <= N; i++) {
            D[i] = (D[i - 1] + D[i - 2]) % 10007; //점화식이 덧셈으로만 이루어져 있다면 다 하고 mod연산하나 하면서 mod해도 똑같음
        }
        System.out.println(D[N]);
    }
}
