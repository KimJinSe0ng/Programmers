import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        int zero = 0;
        int one = 0;

        if (S.charAt(0) == '0') { //초깃값
            zero++;
        } else {
            one++;
        }

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) != S.charAt(i)) { //이전 숫자와 다를 경우
                if (S.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
        }
        System.out.println(Math.min(one, zero));
    }
}
