class Solution {
    boolean solution(String s) {
        //1.문자열을 모두 소문자로 변환
        s = s.toLowerCase();
        //2.p의 개수 세기
        //2.1.문자열에 등장하는 모든 p를 ""로 치환
        //2.2.원본 문자열과 변환된 문자열의 길이 차이가 p의 개수
        int ps = s.length() - s.replace("p", "").length();
        //3.2와 같은 방식으로 y의 개수 세기
        int ys = s.length() - s.replace("y", "").length();
        //4.구한 p의 개수와 y의 개수 비교
        return ps == ys;
    }
}