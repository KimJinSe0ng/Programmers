import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static int[] op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        op = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, A[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void DFS(int index, int acc) {
        if (index == N - 1) {
            max = Math.max(max, acc);
            min = Math.min(min, acc);
        } else {
            // 각 연산자에 대하여 재귀적으로 수행
            if (op[0] > 0) {
                op[0] -= 1;
                DFS(index + 1, acc + A[index + 1]);
                op[0] += 1;
            }
            if (op[1] > 0) {
                op[1] -= 1;
                DFS(index + 1, acc - A[index + 1]);
                op[1] += 1;
            }
            if (op[2] > 0) {
                op[2] -= 1;
                DFS(index + 1, acc * A[index + 1]);
                op[2] += 1;
            }
            if (op[3] > 0) {
                op[3] -= 1;
                DFS(index + 1, acc / A[index + 1]);
                op[3] += 1;
            }
        }
    }

}
