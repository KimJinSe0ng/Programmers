class Solution {
    public int solution(String num_str) {
        char[] nums = num_str.toCharArray();
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += Character.getNumericValue(nums[i]);
        }
        return sum;
    }
}