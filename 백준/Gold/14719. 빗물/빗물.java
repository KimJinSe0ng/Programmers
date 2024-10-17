import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        height = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 1; i < W - 1; i++) { //블록 별 모이는 빗물 계산, 첫번째와 마지막은 빗물이 고일 수 없어서 제외
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) { //현재 블록 기준 모든 왼쪽 블록의 높이까지 검사
                left = Math.max(height[j], left);
            }

            for (int j = i + 1; j < W; j++) { //현재 블록 기준 모든 오른쪽 블록의 높이까지 검사
                right = Math.max(height[j], right);
            }
            
            if (height[i] < left && height[i] < right) {
                result += Math.min(left, right) - height[i];
            }
            

        }
        System.out.println(result);
    }
}
