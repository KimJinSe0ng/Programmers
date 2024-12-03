import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String B = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String C = st.nextToken();

        System.out.println(calculateByNumber(A, B, C));
        System.out.println(calculateByString(A, B, C));
    }

    private static int calculateByNumber(String A, String B, String C) {
        return Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C);
    }

    private static int calculateByString(String A, String B, String C) {
        return Integer.parseInt(A + B) - Integer.parseInt(C);
    }
}
