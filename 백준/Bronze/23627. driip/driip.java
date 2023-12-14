import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regExp = "driip$";
        String line = sc.nextLine();
        Matcher matcher = Pattern.compile(regExp).matcher(line);
        if (matcher.find()) {
            System.out.println("cute");
        } else {
            System.out.println("not cute");
        }
    }
}
