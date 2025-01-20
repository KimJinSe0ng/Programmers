import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        
        if (isFind(word)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    
    private static boolean isFind(String word) {
        int left = 0;
        int right = word.length() - 1;
        while(left < right) {
            if(word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
