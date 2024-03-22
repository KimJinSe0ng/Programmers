import java.util.*;

class Solution {
        //1.상태정의
        private static class State {
            public final String word;
            public final int step; //변환 횟수 : 정답을 구하고자 추적하는 변수일 뿐 상태 변수는 아님 -> 중복 검사는 word 로만 함

            public State(String word, int step) {
                this.word = word;
                this.step = step;
            }
        }
    
        private boolean isConvertable(String src, String dst) { //두 단어는 하나의 문자만 다를 때 변환 가능
            char[] srcArr = src.toCharArray();
            char[] dstArr = dst.toCharArray();

            int diff = 0;
            for (int i = 0; i < srcArr.length; i++) {
                if (srcArr[i] != dstArr[i]) diff++;
            }
            return diff == 1;
        }

        public int solution(String begin, String target, String[] words) {
            //2.방문검사배열
            boolean[] isVisited = new boolean[words.length];
            //3.초기상태
            Queue<State> queue = new LinkedList<>();
            queue.add(new State(begin, 0));

            //4.탐색진행
            while (!queue.isEmpty()) {
                State state = queue.poll();
                //5.현재상태처리
                if (state.word.equals(target)) {
                    return state.step;
                }
                //6.전이상태생성
                for (int i = 0; i < words.length; i++) {
                    String next = words[i];
                    //7.유효성검사
                    if (!isConvertable(state.word, next)) {
                        continue;
                    }
                    //8.중복검사
                    if (isVisited[i]) {
                        continue;
                    }
                    //9.방문처리 & 상태전이
                    isVisited[i] = true;
                    queue.add(new State(next, state.step + 1));
                }
            }
            
            return 0;
        }
}