import java.util.*;

/*
    1.정렬
    2.뒤에서 부터 m개씩 자름
    3.포인터를 옮길 때 범위를 벗어나면 패스
*/
class Solution {
    public int solution(int k, int m, int[] score) {
        int profit = 0;
        int l = score.length - m;
        int r = score.length - 1;
        
        Arrays.sort(score);
        
        while(l >= 0) {
            profit += score[l] * m;
            r = l - 1;
            l = l - m;
        }
        
        return profit;
    }
}