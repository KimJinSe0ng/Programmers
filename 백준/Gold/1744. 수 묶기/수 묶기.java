import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder()); //양수는 내림차순 정렬
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0; //1의 개수 카운트
        int zero = 0; //0의 개수 카운트

        for (int i = 0; i < N; i++) { //4개의 그룹으로 분리해 저장하기
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            if (data > 1) {
                plusPq.add(data);
            } else if (data == 1) {
                one++;
            } else if (data == 0) {
                zero++;
            } else {
                minusPq.add(data);
            }
        }

        int sum = 0;
        //양수 처리하기
        while (plusPq.size() > 1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum = sum + first * second;
        }
        if (!plusPq.isEmpty()) { //양수 1개 남은거 처리
            sum = sum + plusPq.remove();
        }

        //음수 처리하기
        while (minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum = sum + first * second;
        }
        if (!minusPq.isEmpty()) {
            if (zero == 0) {
                sum = sum + minusPq.remove();
            }
        }

        //1 처리하기
        sum = sum + one;
        System.out.println(sum);
    }
}
