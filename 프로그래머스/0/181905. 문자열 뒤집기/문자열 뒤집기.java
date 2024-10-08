class Solution {
    public String solution(String my_string, int s, int e) {
        String before = my_string.substring(0, s);
        String middle = new StringBuilder(my_string.substring(s, e + 1)).reverse().toString();
        String after = my_string.substring(e + 1);

        return before + middle + after;
    }
}