import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        int zero = 0;
        int one = 0;
        boolean isZero = false;
        boolean isOne = false;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                isOne = false;
                if (!isZero) {
                    zero++;
                    isZero = true;
                }
            } else {
                isZero = false;
                if (!isOne) {
                    one++;
                    isOne = true;
                }
            }
        }

        System.out.println(Math.min(zero, one));
    }
}
