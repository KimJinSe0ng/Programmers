import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        List<String> arr = new ArrayList<>(List.of(seoul));
        
        int idx = arr.indexOf("Kim");
        
        return "김서방은 " + idx + "에 있다";
    }
}