class Solution {
    public int solution(int[] numbers, int k) {
        int idx = 0 ;
        int count = 1;
        while(count != k) {
            count++;
            idx = (idx + 2) % numbers.length;
        }
        return idx + 1;
    }
}