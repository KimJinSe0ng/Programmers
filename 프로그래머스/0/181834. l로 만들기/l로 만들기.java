class Solution {
    public String solution(String myString) {
        StringBuilder result = new StringBuilder();

        for (char c : myString.toCharArray()) {
            if (c < 'l') {
                result.append('l');
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}