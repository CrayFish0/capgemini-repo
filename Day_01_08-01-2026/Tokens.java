// Day 1 – Tokens in Java
// Tokens are the smallest individual elements of a Java program.
// Types: Keywords, Identifiers, Literals, Operators, Separators

public class Tokens {
    public static void main(String[] args) {
        // Keywords – reserved words with special meaning
        int number = 10; // 'int' is a keyword
        boolean flag = true; // 'boolean' is a keyword

        // Identifiers – names given to variables, methods, classes
        int studentAge = 21; // 'studentAge' is an identifier

        // Literals – fixed constant values in code
        int decimal = 100;
        double pi = 3.14;
        char letter = 'A';
        String text = "Hello, Java!";

        // Operators – symbols that perform operations
        int sum = 5 + 3; // '+' is an arithmetic operator

        // Separators – characters that separate tokens { } ( ) ; , .
        System.out.println("number  : " + number);
        System.out.println("flag    : " + flag);
        System.out.println("age     : " + studentAge);
        System.out.println("decimal : " + decimal);
        System.out.println("pi      : " + pi);
        System.out.println("letter  : " + letter);
        System.out.println("text    : " + text);
        System.out.println("sum     : " + sum);
    }
}
