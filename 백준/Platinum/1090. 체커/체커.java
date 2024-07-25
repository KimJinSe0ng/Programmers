import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        int[] arr_y = new int[n];
        int[] arr_x = new int[n];
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        // 입력 받기
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            arr[i][0] = a;
            arr[i][1] = b;
            arr_y[i] = b;
            arr_x[i] = a;
        }

        // 만날 장소 정하기
        for (int y : arr_y) {
            for (int x : arr_x) {
                List<Integer> dist = new ArrayList<>();

                // 만날 장소로 각각의 점들이 오는 비용 계산하기
                for (int[] point : arr) {
                    int ex = point[0];
                    int ey = point[1];
                    int d = Math.abs(ex - x) + Math.abs(ey - y);
                    dist.add(d);
                }

                // 가까운 순서대로 정렬하기
                Collections.sort(dist);

                int tmp = 0;
                for (int i = 0; i < dist.size(); i++) {
                    int d = dist.get(i);
                    tmp += d;
                    if (answer[i] == -1) {
                        answer[i] = tmp;
                    } else {
                        answer[i] = Math.min(tmp, answer[i]);
                    }
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
