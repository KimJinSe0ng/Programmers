class Solution {
    public int solution(String number) {
        int sum = 0;
        for(int i = 0; i < number.length(); i++) {
            // sum += (int)(number.charAt(i)); // 이 코드는 아스키 코드로 바꿔짐
            sum += Character.getNumericValue(number.charAt(i));
        }
        return sum % 9;
    }
}