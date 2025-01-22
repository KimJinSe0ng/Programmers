import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] ingredients;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        ingredients = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ingredients[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ingredients);

        int left = 0;
        int right = ingredients.length - 1;
        int count = 0;

        while (left < right) {
            if (ingredients[left] + ingredients[right] < M) {
                left++;
            } else if (ingredients[left] + ingredients[right] > M) {
                right--;
            } else {
                left++;
                right--;
                count++;
            }
        }

        System.out.println(count);
    }
}
