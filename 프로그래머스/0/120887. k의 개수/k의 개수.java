class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;
        String target = String.valueOf(k);
        
        for (int num = i; num <= j; num++) {
            String numStr = String.valueOf(num);
            for (int idx = 0; idx < numStr.length(); idx++) {
                if (numStr.charAt(idx) == target.charAt(0)) {
                    count++; 
                }
            }
        }
        
        return count;
    }
}