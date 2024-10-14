import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        // 참여 가능한 학생들의 (등수, 번호)를 저장할 리스트
        List<int[]> participants = new ArrayList<>();
        
        // 참여 가능한 학생들만 리스트에 추가
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                participants.add(new int[]{rank[i], i});
            }
        }
        
        // 등수를 기준으로 오름차순 정렬
        participants.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        // 상위 3명의 학생 번호 추출
        int a = participants.get(0)[1];
        int b = participants.get(1)[1];
        int c = participants.get(2)[1];
        
        // 수식에 따라 결과 계산
        return 10000 * a + 100 * b + c;
    }
}