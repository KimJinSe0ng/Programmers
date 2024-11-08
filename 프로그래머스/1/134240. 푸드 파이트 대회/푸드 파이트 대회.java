class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < food.length; i++) {
            int place = food[i] / 2;
            String f = Integer.toString(i);
            sb.append(f.repeat(place));
        }
        
        String prefix = sb.toString();
        String postfix = sb.reverse().toString();
        

        return prefix + "0" + postfix;
    }
}