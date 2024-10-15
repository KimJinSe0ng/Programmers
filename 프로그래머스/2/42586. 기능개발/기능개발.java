import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 남은 작업 일수를 저장할 큐
        Queue<Integer> remainingDays = new LinkedList<>();

        // 각 작업의 남은 작업일 계산 후 큐에 저장
        for (int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];  // 남은 작업량
            int days = (int) Math.ceil((double) remainingWork / speeds[i]);  // 남은 작업일 계산
            remainingDays.offer(days);  // 큐에 삽입
        }

        List<Integer> answerList = new ArrayList<>();
        
        while (!remainingDays.isEmpty()) {
            int deployDay = remainingDays.poll();  // 첫 번째 작업의 남은 일수
            int count = 1;  // 이번 배포에서 몇 개의 기능이 배포되는지 카운트

            // 큐에서 다음 작업들이 함께 배포 가능한지 확인
            while (!remainingDays.isEmpty() && remainingDays.peek() <= deployDay) {
                remainingDays.poll();  // 함께 배포할 수 있는 작업 제거
                count++;
            }
            
            // 이번 배포의 기능 개수를 저장
            answerList.add(count);
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}