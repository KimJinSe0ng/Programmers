import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        //1.끝 지점을 이용하여 이동 경로 정렬하기
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));
        //2.단속 카메라 설치하기
        int last = Integer.MIN_VALUE;

        int count = 0; //개수
        //단속 카메라 설치를 위해 모든 이동 경로 순회
        for (int[] route : routes) {
            if (last >= route[0] && last <= route[1]) continue; //직전에 설치한 카메라가 경로에 포함되어 이씅면 해당 경로는 이미 단속 카메라를 만남, 새로 추가X
            last = route[1];
            count++;
        }
        return count;
    }
}