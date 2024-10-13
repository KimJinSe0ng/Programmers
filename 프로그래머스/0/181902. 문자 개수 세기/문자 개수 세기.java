import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int[] arr = new int[52];
        for (char ch : my_string.toCharArray()) {
            System.out.println(ch - 'A');
            if (ch >= 'A' && ch <= 'Z') {
                arr[ch - 'A']++;
            } else if (ch >= 'a' && ch <= 'z') {
                arr[ch - 'a' + 26]++;
            }
        }
        return arr;
    }
}