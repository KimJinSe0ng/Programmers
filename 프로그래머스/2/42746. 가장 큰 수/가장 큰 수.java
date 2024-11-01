import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for(int i = 0; i < str.length; i++) {
            str[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        String result = String.join("", str);

        if (result.startsWith("0")) {
            return "0";
        }
        
        return result;
    }
}