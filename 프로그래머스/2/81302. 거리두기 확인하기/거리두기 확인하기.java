import java.util.*;

class Solution {
    private static int[] dx = {0, -1, 1, 0};
    private static int[] dy = {-1, 0, 0, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for(int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] =0;
            }
        }
        
        return answer;
    }
    
    // exclude 방향을 제외한 네 방향에 다른 응시자가 있는지 검사
    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }
    
    // 거리두기 검사
    private boolean isDistanced(char[][] room) { //대기실 정보만 넘겨주었을 때는 해당 대기실이 거리두기를 지키고 있는지 검사
        // 1. 대기실의 모든 응시자 위치에 대해 반복
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }
    
    private boolean isDistanced(char[][] room, int x, int y) { //해당 대기실에서 (x, y) 위치의 응시자가 거리두기를 지키고 있는지 검사
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            switch (room[ny][nx]) {
                case 'P' : return false;
                case 'O' :
                    if (isNextToVolunteer(room, nx, ny, 3 - d)) return false; //인접한 곳에 다른 응시자가 있는지 검사
                    break;
            }
        }
        return true;
    }
}

/*
-대기실은 5개
-응시자들 끼리는 맨해튼 거리가 2히아로 앉지 말기 : 테이블 t1, t2가 (r1, c1), (r2, c2)에 위치할 때 t1, t2 사이의 거리는
 |r1 - r2| + |c1 - c2|
-단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우 허용

기능 목록
1.모든 응시자의 위치 저장
2.각 응시자의 위치를 하나 선정한 후, 남은 모든 응시자들의 위치와 비교
3.BFS로 이동할 때 마다 이동 거리를 지도에 갱신
*/