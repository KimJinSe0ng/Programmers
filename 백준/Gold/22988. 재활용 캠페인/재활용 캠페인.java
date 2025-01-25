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

        int s = 0;
        int e = N - 1;
        int count = 0;
        int remain = 0;

        while (s <= e) {
            if (bottles[e] == X) {
                count++;
                e -= 1;
                continue;
            }

            if (s == e) {
                remain++;
                break;
            }
            if (bottles[s] + bottles[e] >= X / 2.0) { //두 병 용량의 합이 총량의 절반에 가까우면, 남은 절반을 채워주기 때문에 꽉 채운 용기를 받을 수 있다.
                count++;
                e -= 1;
                s += 1;
            } else { //절반에 가깝지 않다면
                s += 1;
                remain++;
            }
        }

        System.out.println(count + (remain / 3));
    }
}
