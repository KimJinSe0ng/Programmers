import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long X;
    static long[] bottles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());

        bottles = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bottles[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(bottles);

        int l = 0;
        int r = bottles.length - 1;
        int count = 0;
        int remain = 0;

        while (l <= r) {
            if (bottles[r] == X) {
                count++;
                r--;
                continue;
            }

            if (l == r) {
                remain++;
                break;
            }
            if (bottles[l] + bottles[r] < X / 2.0) {
                l++;
                remain++;
            } else {
                r--;
                l++;
                count++;
            }
        }
        System.out.println(count + (remain / 3));
    }
}
