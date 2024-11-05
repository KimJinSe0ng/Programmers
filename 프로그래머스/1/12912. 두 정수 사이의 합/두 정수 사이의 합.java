class Solution {
    public long solution(int a, int b) {
        int minNumber = Math.min(a, b);
        int maxNumber = Math.max(a, b);
        long answer = 0;
        
        for(int i = minNumber; i <= maxNumber; i++) {
            answer += (long) i;
        }
        
        return answer;
    }
}