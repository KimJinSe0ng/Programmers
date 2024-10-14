import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> enlargedPicture = new ArrayList<>();
        
        for (String row : picture) {
            StringBuilder enlargedRow = new StringBuilder();
            
            for (char pixel : row.toCharArray()) {
                enlargedRow.append(String.valueOf(pixel).repeat(k));
            }
            
            for (int i = 0; i < k; i++) {
                enlargedPicture.add(enlargedRow.toString());
            }
        }
        
        return enlargedPicture.toArray(new String[0]);
    }
}