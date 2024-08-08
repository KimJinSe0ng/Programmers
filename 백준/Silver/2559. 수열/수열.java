import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] A;
    static int[] prefix;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        prefix = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // prefix 배열 초기화
        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }

        // 부분 합 계산
        int maxSum = Integer.MIN_VALUE;
        for (int j = K; j <= N; j++) {
            int currentSum = prefix[j] - prefix[j - K];
            maxSum = Math.max(maxSum, currentSum);
        }

        // 결과 출력
        System.out.println(maxSum);

    }
}
