class Solution {
    public long solution(long n) {
        return isSqrt(n);
    }
    
    private long isSqrt(long n) {
        long sqrt = (long) Math.sqrt(n);
        if(sqrt * sqrt == n) {
            return (sqrt + 1) * (sqrt + 1);
        }
        return -1;
    }
}