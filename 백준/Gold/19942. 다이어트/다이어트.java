import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] necessary;
    static int[][] ingredient;
    static int cost = Integer.MAX_VALUE;
    static List<Integer> used = new ArrayList<>();
    static List<Integer> answerUsed = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        ingredient = new int[N][5];
        necessary = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < necessary.length; i++) {
            necessary[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
            ingredient[i][2] = Integer.parseInt(st.nextToken());
            ingredient[i][3] = Integer.parseInt(st.nextToken());
            ingredient[i][4] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0, 0, 0, 0, 0);

        if (!answerUsed.isEmpty()) {
            Collections.sort(answerUsed);
            System.out.println(cost);
            for (int idx : answerUsed) {
                System.out.print((idx) + " ");
            }
        } else {
            System.out.println(-1);
        }

    }

    private static void recur(int idx, int p, int f, int s, int v, int c) {
        if (p >= necessary[0] && f >= necessary[1] && s >= necessary[2] && v >= necessary[3]) {
            if (cost > c) {
                cost = c;
                answerUsed = new ArrayList<>(used);
            }
        }

        if (idx == N) {
            return;
        }

        // 식재료를 사용하는 경우
        used.add(idx + 1);
        recur(idx + 1, p + ingredient[idx][0], f + ingredient[idx][1], s + ingredient[idx][2], v + ingredient[idx][3], c + ingredient[idx][4]);
        used.remove(used.size() - 1);
        // 식재료를 사용하지 않는 경우
        recur(idx + 1, p, f, s, v, c);
    }


}
