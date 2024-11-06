import java.util.*;

class Solution {
    public int solution(int n) {
        StringBuilder ternary = new StringBuilder();
        while (n > 0) {
            ternary.append(n % 3);
            n /= 3;              
        }

        String reversedTernary = ternary.toString();

        int answer = 0;
        for (int i = 0; i < reversedTernary.length(); i++) {
            int digit = reversedTernary.charAt(i) - '0';
            answer += digit * Math.pow(3, reversedTernary.length() - 1 - i);
        }

        return answer;
    }
}