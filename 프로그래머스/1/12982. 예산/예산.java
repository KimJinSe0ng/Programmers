import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int count = 0;
        
        Arrays.sort(d);
        
        for(int m : d) {
            if(budget - m >= 0) {
                budget -= m;
                count++;
            } else {
                break;
            }
        }
        
        return count;
    }
}