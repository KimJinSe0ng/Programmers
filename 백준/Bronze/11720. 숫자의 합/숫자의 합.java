import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        char[] numbers = br.readLine().toCharArray();

        int sum = 0;
        for (char number : numbers) {
            sum += Character.getNumericValue(number);
        }

        System.out.println(sum);
    }
}
