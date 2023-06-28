class Solution {
    public int solution(int[] array, int n) {
        int count = 0;
        for (int num : array) {
            if (num == n) count += 1;
        }
        return count;
    }
}