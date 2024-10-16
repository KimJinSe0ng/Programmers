import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i, priorities[i])); // i는 인덱스
        }

        int count = 0; // 실행 순서를 기록
        while (!queue.isEmpty()) {
            Process current = queue.poll();
            
            // 현재 프로세스보다 높은 우선순위가 남아 있는지 확인
            boolean hasHigherPriority = false;
            for (Process p : queue) {
                if (p.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }

            // 높은 우선순위가 있다면 다시 큐에 넣기
            if (hasHigherPriority) {
                queue.offer(current);
            } else {
                count++; // 실행 순서를 증가
                if (current.idx == location) {
                    return count; // 찾고자 하는 프로세스가 실행될 차례면 반환
                }
            }
        }

        return -1;
    }
    
    private class Process {
        int idx;
        int priority;
        
        public Process(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
       
    }
}