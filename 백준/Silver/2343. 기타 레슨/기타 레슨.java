import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] lessons;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lessons = new int[N];
        st = new StringTokenizer(br.readLine());

        int maxLesson = 0;
        int totalLength = 0;
        for (int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            maxLesson = Math.max(maxLesson, lessons[i]);
            totalLength += lessons[i];
        }

        int left = maxLesson;
        int right = totalLength;
        int result = totalLength;

        while (left <= right) {
            int mid = (left + right) / 2; 

            if (canDivide(lessons, N, M, mid)) {
                result = mid; 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canDivide(int[] lessons, int N, int M, int x) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (sum + lessons[i] > x) {
                count++;
                sum = lessons[i];
                if (count > M) return false;
            } else {
                sum += lessons[i];
            }
        }

        return true; 
    }
}
