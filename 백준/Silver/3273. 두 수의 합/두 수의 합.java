import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static int X;
    static int pair = 0;
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
                pair++;
                left++;
                right--;
            } else if (A[left] + A[right] > X) {
                right--;
            } else if (A[left] + A[right] < X) {
                left++;
            }
        }
        System.out.println(pair);
    }
}
