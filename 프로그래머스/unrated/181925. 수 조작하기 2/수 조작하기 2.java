class Solution {
    public String solution(int[] numLog) {
        String answer = "";

        int temp = numLog[0];
        for(int i=1; i<numLog.length; i++){

           switch(numLog[i]-temp) {
                case 1:
                   answer += "w";
                   break;
                case -1:
                   answer += "s";
                   break;
                case 10:
                   answer += "d";
                   break;
                case -10:
                   answer += "a";
                   break;
           }
            temp = numLog[i];
        }
        return answer;
    }
}
// class Solution {
//     public String solution(int[] numLog) {
//         String answer = "";
//         int[] intControl = {1, -1, 10, -10};
//         char[] charControl = {'w','s','d','a'};
//         int n = numLog[0]; // 초기값
//         for(int i = 1; i < numLog.length; i++) {
//             for(int j = 0; j < intControl.length; j++) {
//                 if(numLog[i] == (n + intControl[j])) {
//                     answer += charControl[j];
//                     n += intControl[j];
//                 }
//             }
//         }
//         return answer;
//     }
// }