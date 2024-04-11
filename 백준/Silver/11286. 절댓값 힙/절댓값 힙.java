import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> { //비교할 객체 커스터마이징
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) { //절댓값이 같은 경우 음수 우선
                return o1 > o2 ? 1 : -1; //첫번째 애가 크면 1을 리턴, 아니면 -1을 리턴(양수 리턴, 음수 리턴)
            }
            return first_abs - second_abs; //앞의 데이터가 크면 양수 리턴, 뒤에가 크면 음수 리턴 -> 절댓값 작은 데이터 우선
        });

        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (queue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(request);
            }
        }
    }
}
