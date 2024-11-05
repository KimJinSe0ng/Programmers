class Solution {
    public boolean solution(int x) {
        StringBuilder sb = new StringBuilder(Integer.toString(x));
        
        int sum = 0;
        for (int i = 0; i < sb.length(); i++) {
            sum += Character.getNumericValue(sb.charAt(i));
        }
        
        return x % sum == 0;
    }
}