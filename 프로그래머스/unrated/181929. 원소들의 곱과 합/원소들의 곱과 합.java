class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int multiplSum = 1;
        for(int num : num_list) {
            sum += num;
            multiplSum *= num;
        }
        return (sum*sum > multiplSum) ? 1 : 0;
    }
}