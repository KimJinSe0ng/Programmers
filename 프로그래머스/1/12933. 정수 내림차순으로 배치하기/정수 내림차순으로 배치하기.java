import java.util.*;

class Solution {
    public long solution(long n) {
        char[] chars = Long.toString(n).toCharArray();
        
        Arrays.sort(chars);
        
        StringBuilder sb = new StringBuilder(new String(chars)).reverse();
        
        return Long.parseLong(sb.toString());
    }
}