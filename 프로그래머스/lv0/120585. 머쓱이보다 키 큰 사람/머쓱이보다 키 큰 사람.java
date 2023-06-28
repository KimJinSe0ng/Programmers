class Solution {
    public int solution(int[] array, int height) {
        int count = 0;
        for (int h : array) {
            // 머쓱이 키보다 크면
            if (height < h) count += 1;
        }
        return count;
    }
}