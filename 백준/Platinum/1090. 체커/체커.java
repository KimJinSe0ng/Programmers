import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<int[]> points = new ArrayList<>();
        List<Integer> arrX = new ArrayList<>();
        List<Integer> arrY = new ArrayList<>();
        int[] answer = new int[N];
        Arrays.fill(answer, -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new int[]{x, y});
            arrX.add(x);
            arrY.add(y);
        }

        // 만날 장소 정하기
        for (int x : arrX) {
            for (int y : arrY) {
                // 만날 장소까지 모든 점의 거리 계산
                List<Integer> dist = new ArrayList<>();
                for (int[] point : points) {
                    int px = point[0];
                    int py = point[1];
                    int d = Math.abs(px - x) + Math.abs(py - y);
                    dist.add(d);
                }

                // 짧은 거리 순으로 정렬
                Collections.sort(dist);

                int sum = 0;
                for (int i = 0; i < dist.size(); i++) {
                    sum += dist.get(i);
                    if (answer[i] != -1) {
                        answer[i] = Math.min(answer[i], sum);
                    } else {
                        answer[i] = sum;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
