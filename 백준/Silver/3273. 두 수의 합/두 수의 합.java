import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static int X;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            if (A[left] + A[right] == X) {
                count++;
            }
            if (A[left] + A[right] >= X) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(count);
    }
}
