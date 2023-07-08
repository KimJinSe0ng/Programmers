class Solution {
    public String[] solution(String myStr) {
        String[] tmp = myStr.split("[abc]");
        StringBuilder tmpStr = new StringBuilder();
        int length = tmp.length;
        
        for (int i = 0; i < length; i++) {
            if (!tmp[i].isEmpty()) {
                tmpStr.append(tmp[i]).append("1");
            }
        }
        
        if (tmpStr.length() == 0) {
            tmpStr.append("EMPTY");
        }
        
        return tmpStr.toString().split("1");
    }
}
