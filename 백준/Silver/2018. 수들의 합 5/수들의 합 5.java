import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //2018
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        while (end_index != n) {
            if (sum == n) { //현재 연속 합이 n과 같은 경우
                count++;
                end_index++;
                sum += end_index;
            } else if (sum > n) { //현재 연속 합이 n보다 더 큰 경우
                sum -= start_index;
                start_index++;
            } else { //현재 연속 합이 n보다 작은 경우
                end_index++;
                sum += end_index;
            }
        }
        System.out.println(count);
    }
}
