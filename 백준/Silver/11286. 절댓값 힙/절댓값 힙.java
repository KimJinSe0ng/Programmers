import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] command = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) != Math.abs(o2)) { // 1. 절댓값이 작은 순서
                return Math.abs(o1) - Math.abs(o2);
            }
            return o1 - o2; // 2. 절댓값이 같으면 숫자가 작은 순서
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            command[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < command.length; i++) {
            int c = command[i];
            if (c != 0) {
                pq.add(c);
            } else {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
