// Day 6 – Regular Expressions (Regex) in Java

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        // matches() – tests if entire string matches pattern
        System.out.println("=== matches() ===");
        System.out.println("\"12345\".matches(\"\\\\d+\")   : " + "12345".matches("\\d+"));
        System.out.println("\"hello\".matches(\"\\\\d+\")   : " + "hello".matches("\\d+"));
        System.out.println("\"test@mail.com\" valid email : " +
                "test@mail.com".matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));

        // Mobile number validation (10 digits starting with 6-9)
        String mobile = "9876543210";
        boolean validMobile = mobile.matches("[6-9]\\d{9}");
        System.out.println("Mobile valid: " + validMobile);

        // Password: min 8 chars, at least one digit, one uppercase
        String pwd = "Secret1!";
        boolean validPwd = pwd.matches("(?=.*[A-Z])(?=.*\\d).{8,}");
        System.out.println("Password valid: " + validPwd);

        // Pattern & Matcher – find all matches in a string
        System.out.println("\n=== Pattern & Matcher ===");
        String text = "Call 9876543210 or email support@company.com for help at 8881112222";
        Pattern pPhone = Pattern.compile("[6-9]\\d{9}");
        Matcher mPhone = pPhone.matcher(text);
        System.out.print("Phones found: ");
        while (mPhone.find())
            System.out.print(mPhone.group() + "  ");
        System.out.println();

        // replaceAll
        System.out.println("\n=== replaceAll ===");
        String sentence = "Java  has   extra   spaces";
        System.out.println("Cleaned: " + sentence.replaceAll("\\s+", " "));
    }
}
