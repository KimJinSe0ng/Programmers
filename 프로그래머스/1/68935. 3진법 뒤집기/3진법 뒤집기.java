import java.util.*;

class Solution {
    public int solution(int n) {
        String ternary = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder(ternary);
        
        sb.reverse(); //앞뒤 반전
        
        String digit = sb.toString();
        
        return Integer.parseInt(digit, 3);
    }
}