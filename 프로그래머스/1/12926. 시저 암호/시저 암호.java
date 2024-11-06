class Solution {
    public String solution(String s, int n) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                result.append((char) ((c - 'A' + n) % 26 + 'A'));
            } else if (c >= 'a' && c <= 'z') {
                result.append((char) ((c - 'a' + n) % 26 + 'a'));
            }
        }

        return result.toString();
    }
}