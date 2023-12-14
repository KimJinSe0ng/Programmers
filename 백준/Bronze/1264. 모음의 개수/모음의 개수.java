import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String reg = "[aeiou]";
        int count;
        while (true) {
            count = 0;
            String line = sc.nextLine();
            if (line.equals("#")) break;
            Matcher matcher = Pattern.compile(reg).matcher(line.toLowerCase());
            while (matcher.find()) {
                count++;
            }
            System.out.println(count);
        }
    }
}
