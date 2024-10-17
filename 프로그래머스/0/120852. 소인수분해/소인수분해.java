import java.util.*;
class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new TreeSet<>();
        int num = 2;
        while(n > 1) {
            if(n % num == 0) {
                n /= num;
                set.add(num);
            } else {
                num++;
            }
        }
        return set.stream().mapToInt(i -> i).toArray();
    }
}