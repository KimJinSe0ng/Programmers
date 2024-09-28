class Solution {
    public int solution(int a, int b) {
        String ab = Integer.toString(a) + Integer.toString(b);
        
        int abInt = Integer.parseInt(ab);
        int ab2Int = a * b * 2;
        
        return Math.max(abInt, ab2Int);
    }
}