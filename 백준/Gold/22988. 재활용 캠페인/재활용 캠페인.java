import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long X;
    static long[] bottles;

    /**
     * Java에서는 배열의 크기나 인덱스는 int 타입으로 처리되기 때문에, long 타입으로 배열의 인덱스나 크기를 사용할 수는 없습니다.
     * 다만, 배열의 요소가 long 타입인 것은 가능합니다.
     * 코드에서 long 타입의 배열 요소를 사용하는 부분과 인덱스를 int 타입으로 처리하는 부분을 분리해야 합니다.
     */
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
