class Solution {
    public int solution(String s) {
        String[] numbers = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < numbers.length; i++) {
            String idx = Integer.toString(i);
            if(s.contains(numbers[i])) {
                s = s.replaceAll(numbers[i], idx);
            }
        }
        
        return Integer.parseInt(s);
    }
}