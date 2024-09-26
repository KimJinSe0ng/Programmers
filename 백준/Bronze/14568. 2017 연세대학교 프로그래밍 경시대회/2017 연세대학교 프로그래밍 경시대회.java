import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int A = 0; A <= N; A++) { //택희
            for (int B = 0; B <= N; B++) { //영훈
                for (int C = 0; C <= N; C++) { //남규
                    if (A + B + C == N) { //남는 사탕 없어야 함
                        if (C >= B + 2) { //남규는 영훈이보다 2개 이상
                            if (A != 0 && B != 0 && C != 0) { //셋 중 사탕을 0개 받는 사람 없어야 함
                                if (A % 2 != 1) { //택희의 사탕 수는 짝수여야 함
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
