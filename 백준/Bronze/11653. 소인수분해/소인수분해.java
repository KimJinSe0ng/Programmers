import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num = 2;
        while (N > 1) {
            if (N % num == 0) {
                N /= num;
                System.out.println(num);
            } else {
                num++;
            }
        }
    }
}
