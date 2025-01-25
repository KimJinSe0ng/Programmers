import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long M;
    static int[] trees;
    static int maxTreeHeight = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxTreeHeight = Math.max(maxTreeHeight, trees[i]);
        }

        Arrays.sort(trees);

        long start = 0;
        long end = maxTreeHeight;
        long maxHeight = Integer.MIN_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;
            long timber = 0;

            for (int height : trees) {
                if (height > mid) {
                    timber += height - mid;
                }
            }

            if (timber >= M) {
                maxHeight = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(maxHeight);
    }
}
