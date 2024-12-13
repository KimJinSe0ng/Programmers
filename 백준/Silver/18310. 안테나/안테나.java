import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] homes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        homes = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(homes);

        System.out.println(homes[(N - 1) / 2]);
    }
}
