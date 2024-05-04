class Solution {
    public int[] solution(int brown, int yellow) {
        for (int width = 3; width <= 5000; width++) { //가능한 모든 가로, 세로 검사
            for (int height = 3; height <= width; height++) { //세로는 가로 길이 이하
                int boundary = (width + height - 2) * 2; //경계 격자 개수
                int center = width * height - boundary; //내부 격자 개수
                if (brown == boundary && yellow == center) {
                    return new int[]{width, height};
                }
            }
        }
        return null;
    }
}