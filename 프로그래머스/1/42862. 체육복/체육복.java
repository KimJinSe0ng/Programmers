import java.util.*;
import java.util.stream.*;

class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        //1.작은 문제의 최적해
        //번호 순서대로 순회할 수 있도록 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //여벌의 체육복을 가져온 학생이 체육복을 도난당한 경우에는 체육복을 빌려줄 수 없음
        Set<Integer> owns = Arrays.stream(lost) //배열 lost와 reserve를 Set으로 변환하고, Set 인터페이스의 retainAll()로 두 Set의 교집합을 구함
                .boxed()
                .collect(Collectors.toSet());
        owns.retainAll(Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toSet()));

        //2.체육복을 빌리는 학생들을 번호 순서대로 검사
        Queue<Integer> q = new LinkedList<>();
        for (int l : lost) {
            q.add(l);
        }

        //배열 reserve를 순회하며 큐에 담긴 체육복을 빌려야 하는 학생 중 몇 명에게 빌려줄 수 있는지 셈
        int get = 0; //셀 변수
        for (int r : reserve) {
            if (owns.contains(r)) { //여벌의 체육복을 갖고 있는 학생 r이 체육복을 잃어버렸다면 빌려주지 못함
                continue;
            }

            //큐에는 체육복을 빌려야 하는 학생들이 있음
            //체육복을 빌려야 하는 학생 번호가 너무 적으면 해당 학생은 체육복을 빌리지 못함. 또 체육복을 빌려야 하는 학생이 여벌의 체육복을 갖고 있다면 빌릴 필요 없음
            /**
             * peek()은 큐에서 요소를 반환하고 제거하지 않음, poll()은 큐에서 요소를 반환하고 제거함
             * peek()은 isEmpty()로 항상 확인해야 함
             */
            while (!q.isEmpty() && (q.peek() < r - 1 || owns.contains(q.peek()))) {
                q.poll();
            }

            if (q.isEmpty()) break; //큐가 비면 더 이상 체육복이 필요한 학생이 없음

            if (q.peek() <= r + 1) { //큐의 가장 앞에는 체육복을 갖고 있는 학생이 빌려줄 수 있는 번호이거나 그보다 큰 번호를 가짐. 빌려줄 수 있는 번호라면 큐에서 해당 학생 제거
                q.poll();
                get++;
            }
        }

        return n - lost.length + owns.size() + get; //전체 학생 수 - 도난 당한 학생 수 + 여벌의 체육복이 있는 학생 수 + 빌린 학생 수
    }
}