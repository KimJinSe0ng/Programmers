import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] numbers;
    static int[] prefix;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        prefix = new int[n + 1];
        
        Arrays.fill(prefix, -1001);

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = Math.max(prefix[i] + numbers[i], numbers[i]);
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxSum = Math.max(maxSum, prefix[i]);
        }

        System.out.println(maxSum);
    }
}
