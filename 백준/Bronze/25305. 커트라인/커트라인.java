import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ary = new int[n];

        for (int i = 0; i < n; i++) {
            ary[i] = sc.nextInt();

        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ary[i] > ary[j]) {
                    int tmp = ary[i];
                    ary[i] = ary[j];
                    ary[j] = tmp;
                }

            }
        }
        System.out.println(ary[n - k]);
        sc.close();
    }
}