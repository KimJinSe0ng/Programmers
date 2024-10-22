import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> list = new ArrayList<>();
        
        PriorityQueue<Number> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.dist != o2.dist) {
                return o1.dist - o2.dist;
            } else {
                return o2.num - o1.num;
            }
        });
        
        for(int num : numlist) {
            pq.add(new Number(num, Math.abs(n - num)));
        }
        
        while(!pq.isEmpty()) {
            Number number = pq.poll();
            list.add(number.num);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
    
    class Number {
        public int num;
        public int dist;
        public Number(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
}