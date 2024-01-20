import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[] arr;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int index = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N + 1];

        recursion(0);
        bw.flush();
        bw.close();
    }

    public static void recursion(int index) throws IOException {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!visit[i]) {
                arr[index] = i;
                visit[i] = true;
                recursion(index + 1);
                for (int j = i + 1; j <= N; j++) {
                    visit[j] = false;
                }
            }
        }
    }
}
