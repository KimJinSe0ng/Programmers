class Solution {
    public int solution(int[] num_list) {
        String oldNum = "";
        String evenNum = "";
        for(int num : num_list) {
            if(num % 2 == 0) {
                evenNum += num;
            } else {
                oldNum += num;
            }
        }
        return Integer.parseInt(oldNum) + Integer.parseInt(evenNum);
    }
}