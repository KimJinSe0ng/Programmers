import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main { //1874
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;
        for (int i = 0; i < numbers.length; i++) {
            int su = numbers[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString());
    }
}
