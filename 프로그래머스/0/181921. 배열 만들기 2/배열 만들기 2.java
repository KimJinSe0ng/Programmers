import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> result = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            if (isZeroFiveNumber(i)) {
                result.add(i); 
            }
        }

        if (result.isEmpty()) {
            return new int[]{-1};
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isZeroFiveNumber(int num) {
        String str = Integer.toString(num);
        for (char c : str.toCharArray()) {
            if (c != '0' && c != '5') {
                return false; 
            }
        }
        return true;
    }
}