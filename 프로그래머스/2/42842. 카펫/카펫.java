class Solution {
    public int[] solution(int brown, int yellow) {
        //가능한 모든 width 와 height 검사
        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
                //조건 검사
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