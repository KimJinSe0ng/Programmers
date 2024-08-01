import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int s = 0;
        int e = N - 1;
        int remain = 0;
        int cnt = 0;

        while (s <= e) {
            if (arr[e] == X) {
                cnt++;
                e--;
                continue;
            }

            if (s == e) {
                remain++;
                break;
            }

            if (arr[e] + arr[s] >= X / 2.0) {
                cnt++;
                s++;
                e--;
            } else {
                s++;
                remain++;
            }
        }

        System.out.println(cnt + remain / 3);
    }
}
