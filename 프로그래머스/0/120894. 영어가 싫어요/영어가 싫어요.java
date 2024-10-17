import java.util.*;

class Solution {
    public long solution(String numbers) {
        Map<String, Integer> map = Map.ofEntries(
            Map.entry("zero", 0),
            Map.entry("one", 1),
            Map.entry("two", 2),
            Map.entry("three", 3),
            Map.entry("four", 4),
            Map.entry("five", 5),
            Map.entry("six", 6),
            Map.entry("seven", 7),
            Map.entry("eight", 8),
            Map.entry("nine", 9)
        );
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(char c : numbers.toCharArray()) {
            sb.append(c);
            if(map.containsKey(sb.toString())) {
                result.append(map.get(sb.toString()));
                sb.setLength(0);
            }
        }
        return Long.parseLong(result.toString());
    }
}