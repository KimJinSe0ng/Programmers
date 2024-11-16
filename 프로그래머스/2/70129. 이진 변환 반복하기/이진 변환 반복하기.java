class Solution {
    public int[] solution(String s) {
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[2];
        boolean isFind = false;
        
        while(!isFind) {
            //1. 제거할 0의 개수 세기
            int zero = 0;
            for(char c : s.toCharArray()) {
                if (c == '0') zero++;
            }
            answer[0]++;
            answer[1] += zero;
            //2. 0 제거 후 길이 c 구하기
            int c = s.length() - zero;
            //3. c를 2진법으로 표현한 문자열로 변환
            s = Integer.toString(c, 2);
            //4. 1이 될 때까지 반복
            System.out.println(s);
            if(s.equals("1")) isFind = true;
        }
        
        
        
        
        return answer;
    }
}