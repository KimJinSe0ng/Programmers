import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //11399
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] S = new int[N]; //합 배열: 각 사람이 인출을 완료하는 데 필요한 시간을 저장하기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 두 번째 요소부터 마지막 요소까지 반복
        for (int i = 1; i < N; i++) {
            int key = A[i]; // 현재 요소를 key 변수에 저장
            int j;
            // 현재 요소의 이전 요소부터 시작하여 첫 번째 요소까지 반복
            for (j = i - 1; j >= 0 && A[j] > key; j--) {
                A[j + 1] = A[j]; // 현재 요소보다 큰 값을 찾을 때까지 배열을 이동
            }
            A[j + 1] = key; // 적절한 위치에 현재 요소를 삽입
        }
        S[0] = A[0]; //합 배열 만들기
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += S[i];
        }
        System.out.println(sum);
    }
}
