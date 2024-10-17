class Solution {
    public int solution(int[] array, int n) {
        int closest = array[0];
        
        for (int num : array) {
            if (Math.abs(num - n) < Math.abs(closest - n)) {
                closest = num;
            } 
            else if (Math.abs(num - n) == Math.abs(closest - n) && num < closest) {
                closest = num;
            }
        }
        
        return closest;
    }
}