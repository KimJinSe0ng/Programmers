class Solution {
    public String solution(String myString, String pat) {
        int index = myString.lastIndexOf(pat);

        if (index == -1) {
            return "";
        }
        
        // pat으로 끝나는 가장 긴 부분 문자열을 추출 (0부터 index + pat의 길이까지)
        return myString.substring(0, index + pat.length());
    }
}