import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int A = 0; A < N; A++) { //택희
            for (int B = 0; B < N; B++) { //영훈
                for (int C = 0; C < N; C++) { //남규
                    if (A + B + C == N) {
                        if (C >= B + 2) {
                            if (A != 0 && B != 0 && C != 0) {
                                if (A % 2 != 1) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
