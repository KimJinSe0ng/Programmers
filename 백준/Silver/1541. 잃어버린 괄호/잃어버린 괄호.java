import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String example = st.nextToken();
        String[] str = example.split("-");
        for (int i = 0; i < str.length; i++) {
            int temp = sum(str[i]);
            if (i == 0) {
                answer = answer + temp;
            } else {
                answer = answer - temp;
            }
        }

        System.out.println(answer);
    }

    private static int sum(String s) {
        int sum = 0;
        String[] temp = s.split("[+]");
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
