import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //1463
    static int n;
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        D = new int[n + 1];
        D[1] = 0;
        for (int i = 2; i <= n; i++) {
            D[i] = D[i - 1] + 1; //-1연산
            if (i % 2 == 0) {
                D[i] = Math.min(D[i], D[i / 2] + 1); //나누기 2 연산
            }
            if (i % 3 == 0) {
                D[i] = Math.min(D[i], D[i / 3] + 1); //나누기 3연산
            }
        }
        System.out.println(D[n]);
    }
}
