import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //1546
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println(sum * 100.0 / max / n);
    }
}
