class Solution {
    public long solution(int a, int b) {
        long minNumber = Math.min(a, b);
        long maxNumber = Math.max(a, b);
        return (maxNumber - minNumber + 1) * (minNumber + maxNumber) / 2;
    }
}