import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        String sortedSpell = String.join("", spell);
        char[] spellArray = sortedSpell.toCharArray();
        Arrays.sort(spellArray);
        String sortedSpellString = new String(spellArray);
        
        for (String word : dic) {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String sortedWord = new String(wordArray);
            
            if (sortedWord.equals(sortedSpellString)) {
                return 1;
            }
        }
        
        return 2;
    }
    
}