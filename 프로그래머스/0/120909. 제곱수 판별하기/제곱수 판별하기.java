class Solution {
    public int solution(int n) {
        for(int num = 1; num <= Math.sqrt(n); num++) {
            if((num * num) == n) {
                return 1;
            }
        }
        return 2;
    }
}