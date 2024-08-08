import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static int[] prefix;
    static int max_value = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        prefix = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        prefix[0] = A[0];
        int max = prefix[0];

        for (int i = 1; i < N; i++) {
            prefix[i] = Math.max(prefix[i - 1] + A[i], A[i]);
            max = Math.max(max, prefix[i]);
        }

        System.out.println(max);
    }
}
