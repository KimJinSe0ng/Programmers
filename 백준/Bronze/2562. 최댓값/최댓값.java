import java.io.*;
import java.util.*;

public class Main {
    private static int maxValue = Integer.MIN_VALUE;
    private static int maxIndex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());

            if (number > maxValue) {
                maxValue = number;
                maxIndex = i;
            }
        }

        System.out.println(maxValue);
        System.out.println(maxIndex);
    }
}
