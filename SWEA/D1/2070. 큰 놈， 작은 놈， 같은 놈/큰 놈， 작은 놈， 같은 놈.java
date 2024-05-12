import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            System.out.println("#" + test_case + " " + compare(num1, num2));
        }
    }

    private static String compare(int num1, int num2) {
        if (num1 > num2) {
            return ">";
        } else if (num1 < num2) {
            return "<";
        } else {
            return "=";
        }
    }
}