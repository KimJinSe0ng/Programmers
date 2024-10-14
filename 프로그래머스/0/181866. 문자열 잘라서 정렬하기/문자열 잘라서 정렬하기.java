import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] parts = myString.split("x");
        
        String[] filteredParts = Arrays.stream(parts)
                                       .filter(str -> !str.isEmpty())
                                       .toArray(String[]::new);
        
        Arrays.sort(filteredParts);
        
        return filteredParts;
    }
}