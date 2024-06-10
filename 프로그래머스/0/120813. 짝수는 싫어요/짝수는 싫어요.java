import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for(int i = 1; i <= n; i += 2) {
            arrayList.add(i);
        }
        
        // ArrayList를 int[] 배열로 변환
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        
        return result;
    }
}