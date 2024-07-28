import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int a = 0; a < N; a++) { //택희
            for (int b = 0; b < N; b++) { //영훈
                for (int c = 0; c < N; c++) { //남규
                    if (c >= b + 2) {
                        if (a != 0 && b != 0 && c != 0) {
                            if (a % 2 != 1) {
                                if (a + b + c == N) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
