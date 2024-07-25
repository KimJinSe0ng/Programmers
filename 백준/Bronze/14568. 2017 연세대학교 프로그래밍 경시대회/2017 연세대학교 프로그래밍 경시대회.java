import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int a = 0; a <= N; a++) {
            for (int b = 0; b <= N; b++) {
                for (int c = 0; c <= N; c++) {
                    if (a + b + c == N) {
                        if (a >= b + 2) {
                            if (a != 0 && b != 0 && c != 0) {
                                if (c % 2 == 0) {
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
