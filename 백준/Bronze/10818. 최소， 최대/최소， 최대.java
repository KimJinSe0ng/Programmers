import java.io.*;
import java.util.*;

public class Main {
    private static int minValue = Integer.MAX_VALUE;
    private static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }

        System.out.printf("%d %d\n", minValue, maxValue);
    }
}
