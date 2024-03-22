import java.util.*;

class Solution {
    
    private static class State {
        public final int index; //연산자를 결정할 인덱스 위치
        public final int acc; //현재까지 결정된 연산자로 결정된 값

        State(int index, int acc) {
            this.index = index;
            this.acc = acc;
        }
    }
    
    public int solution(int[] numbers, int target) {
        Stack<State> s = new Stack<>();
        s.push(new State(0, 0));
                    
        int count = 0;
        
        while (!s.isEmpty()) {
            State state = s.pop();
            
            //state 처리, 전이
            if (state.index == numbers.length) {
                if (state.acc == target) count++;
                continue;
            }
            
            //상태 전이
            //+를 선택한 경우
            s.push(new State(state.index + 1, state.acc - numbers[state.index]));
            //-를 선택한 경우
            s.push(new State(state.index + 1, state.acc + numbers[state.index]));
        }
        
        return count;
    }
}