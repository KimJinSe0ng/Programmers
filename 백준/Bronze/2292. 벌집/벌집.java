import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        long layer = 1; // 현재 계층
        long maxNumber = 1; // 계층의 끝 번호

        while (maxNumber < N) {
            maxNumber += 6 * layer; // 다음 계층의 끝 번호
            layer++;
        }

        System.out.println(layer);
    }
}
