import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<Word> words = new ArrayList<>();
        
        for(String str : strings) {
            char standard = str.charAt(n);
            words.add(new Word(str, standard));
        }
        
        words.sort((o1, o2) -> {
            if (o1.standard == o2.standard) {
                return o1.name.compareTo(o2.name); //이름을 사전 순으로 비교
            }
            return Character.compare(o1.standard, o2.standard); //기준 문자 비교
        });
        
        String[] answer = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            answer[i] = words.get(i).name;
        }
        
        return answer;
    }
    
    private class Word {
        public String name;
        public char standard;
        
        Word(String name, char standard) {
            this.name = name;
            this.standard = standard;
        }
    }
}