import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int t = 0; t <= N; t++) { //택희
            for (int y = 0; y <= N; y++) { //영훈
                for (int n = 0; n <= N; n++) { //남규
                    if (t + y + n == N) {
                        if (n >= y + 2) {
                            if (t != 0 && y != 0 && n != 0) {
                                if (t % 2 != 1) {
                                    answer++;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
