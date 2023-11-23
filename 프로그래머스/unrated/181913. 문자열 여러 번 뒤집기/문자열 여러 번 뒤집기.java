class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        StringBuilder reverseSb = new StringBuilder();
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            String newString = my_string.substring(start, end + 1);
            reverseSb.append(newString)
                    .reverse();
            my_string = sb.replace(start, end + 1, reverseSb.toString()).toString();
            reverseSb.delete(0, reverseSb.length());
        }
        return sb.toString();
    }
}