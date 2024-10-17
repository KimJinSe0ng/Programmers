class Solution {
    public int solution(String s) {
        String[] str = s.split(" ");
        int sum = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i].equals("Z")) {
                sum -= Integer.parseInt(str[i - 1]);
                continue;
            }
            sum += Integer.parseInt(str[i]);
        }
        return sum;
    }
}