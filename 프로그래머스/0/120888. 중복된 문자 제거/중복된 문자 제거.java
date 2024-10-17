import java.util.*;
class Solution {
    public String solution(String my_string) {
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : my_string.toCharArray()) {
            if(list.contains(c)) {
                continue;
            }
            list.add(c);
        }
        
        for(char c : list) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}