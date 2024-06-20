import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            priorityQueue.add(Integer.parseInt(st.nextToken()));
        }

        int num1 = 0;
        int num2 = 0;
        int sum = 0;
        while (priorityQueue.size() != 1) {
            num1 = priorityQueue.remove();
            num2 = priorityQueue.remove();
            sum += num1 + num2;
            priorityQueue.add(num1 + num2);
        }

        System.out.println(sum);
    }
}
