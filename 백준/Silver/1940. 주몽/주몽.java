import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //1940
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int start_index = 0;
        int end_index = n - 1;
        int count = 0;
        while (start_index < end_index) {
            if (numbers[start_index] + numbers[end_index] < m) {
                start_index++;
            } else if (numbers[start_index] + numbers[end_index] > m) {
                end_index--;
            } else {
                count++;
                start_index++;
                end_index--;
            }
        }
        System.out.println(count);
        br.close();
    }
}
