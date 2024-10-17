import java.util.*;
class Solution {
    public String solution(String my_string) {
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        
        for (char ch : my_string.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}