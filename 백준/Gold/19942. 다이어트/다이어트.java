import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] necessary;
    static int[][] ingredient;
    static int answer = Integer.MAX_VALUE;
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
            System.out.println(answer);
            for (int idx : answerUsed) {
                System.out.print((idx + 1) + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static void recur(int idx, int mp, int mf, int ms, int mv, int price) {
        if (mp >= necessary[0] && mf >= necessary[1] && ms >= necessary[2] && mv >= necessary[3]) {
            if (answer > price) {
                answer = price;
                answerUsed = new ArrayList<>(used);
            }
        }

        if (idx == N) { //모든 재료를 사용한 경우
            return;
        }

        //재료를 사용한 경우
        used.add(idx);
        recur(idx + 1, mp + ingredient[idx][0], mf + ingredient[idx][1], ms + ingredient[idx][2], mv + ingredient[idx][3], price + ingredient[idx][4]);
        used.remove(used.size() - 1);
        //재료를 사용하지 않은 경우
        recur(idx + 1, mp, mf, ms, mv, price);
    }
}
