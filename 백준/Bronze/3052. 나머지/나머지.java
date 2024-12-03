import java.io.*;
import java.util.*;

public class Main {
    private static final int DIVIDER = 42;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Set<Integer> remainder = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            remainder.add(num % DIVIDER);
        }

        System.out.println(remainder.size());
    }
}
