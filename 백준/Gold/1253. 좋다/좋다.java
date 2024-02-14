import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //1253
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        int count = 0;

        for (int i = 0; i < n; i++) {
            int start_index = 0;
            int end_index = n - 1;
            int find = numbers[i];
            while (start_index < end_index) {
                if (numbers[start_index] + numbers[end_index] == find) {
                    if (start_index != i && end_index != i) {
                        count++;
                        break;
                    } else if (start_index == i) {
                        start_index++;
                    } else if (end_index == i) {
                        end_index--;
                    }
                } else if (numbers[start_index] + numbers[end_index] < find) {
                    start_index++;
                } else {
                    end_index--;
                }
            }
        }
        System.out.println(count);
    }
}
