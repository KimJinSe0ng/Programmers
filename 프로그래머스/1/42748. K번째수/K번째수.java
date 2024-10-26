import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for(int[] command : commands) {
            int start = command[0];
            int end = command[1];
            int times = command[2];
            int[] copy = new int[end - start + 1];
            System.arraycopy(array, start - 1, copy, 0, end - start + 1);
            Arrays.sort(copy);
            answer.add(copy[times - 1]);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}