class Solution {
    public int solution(int order) {
        String str_order = Integer.toString(order);
        int sum = 0;
        for(char c : str_order.toCharArray()) {
            if(c == '3' || c == '6' || c == '9') {
                sum++;
            }
        }
        return sum;
    }
}