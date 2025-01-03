import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            System.out.println(" ".repeat(N - i) + "*".repeat(i));
        }
    }
}
