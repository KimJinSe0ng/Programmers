import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] necessary;
    static int[][] items;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Integer> use;
    static ArrayList<Integer> answer_use = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        necessary = new int[4];
        items = new int[N][5];
        use = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            necessary[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
            items[i][2] = Integer.parseInt(st.nextToken());
            items[i][3] = Integer.parseInt(st.nextToken());
            items[i][4] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0, 0, 0, 0, 0);

        if (!answer_use.isEmpty()) {
            Collections.sort(answer_use);
            System.out.println(answer);
            for (Integer idx : answer_use) {
                System.out.printf("%d ", idx + 1);
            }
        } else {
            System.out.println(-1);
        }
    }

    private static void recur(int idx, int dan, int zi, int tan, int bi, int price) {
        if (dan >= necessary[0] && zi >= necessary[1] && tan >= necessary[2] && bi >= necessary[3]) {
            if (answer > price) {
                answer = price;
                answer_use = new ArrayList<>(use);
            }
        }
        if (idx == N) { //모든 재료를 다 사용했다면
            return;
        }

        //현재 재료를 선택한 경우
        use.add(idx);
        recur(idx + 1, dan + items[idx][0], zi + items[idx][1], tan + items[idx][2], bi + items[idx][3], price + items[idx][4]);
        use.remove(use.size() - 1);
        //현재 재료를 선택하지 않은 경우
        recur(idx + 1, dan, zi, tan, bi, price);

    }
}
