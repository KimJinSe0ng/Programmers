import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int number = 0;
        for (int i = 3; i >= 1; i--) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if (input.matches("[0-9]*")) {
                number = Integer.parseInt(input) + i;
                break;
            }
        }

        System.out.println(findFizzBuzz(number));
    }

    private static String findFizzBuzz(int num) {
        if (num % 3 == 0 && num % 5 == 0) {
            return "FizzBuzz";
        } else if (num % 3 == 0 && num % 5 != 0) {
            return "Fizz";
        } else if (num % 3 != 0 && num % 5 == 0) {
            return "Buzz";
        }
        return Integer.toString(num);
    }
}
