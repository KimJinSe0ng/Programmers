import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }
    
    private void hanoi(int n, int from, int to, List<int[]> process) {
        if (n == 1) {
            process.add(new int[] {from, to});
            return;
        }
        //기둥의 번호는 항상 1, 2, 3 중에서 선택되므로, 남는 기둥은 총합에서 현재 사용하는 기둥 번호를 뺀 값
        int empty = 6 - from - to;
        
        hanoi(n - 1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, empty, to, process);
    }
}