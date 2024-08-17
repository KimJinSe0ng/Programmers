import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        if (num_list.length >= 11) {
            answer = cal_sum(num_list);
        } else {
            answer = cal_mul(num_list);
        }
        return answer;
    }
    
    private static int cal_sum(int[] num_list) {
        int tmp = 0;
        for(int num : num_list) {
            tmp += num;
        }
        return tmp;
    }
    
    private static int cal_mul(int[] num_list) {
        int tmp = 1;
        for(int num : num_list) {
            tmp *= num;
        }
        return tmp;
    }
}