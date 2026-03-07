// Day 1 – Type Conversions
// Widening (implicit) and Narrowing (explicit / casting) conversions

public class TypeConversions {
    public static void main(String[] args) {
        // --- Widening (Implicit) conversion ---
        // byte -> short -> int -> long -> float -> double
        int intVal = 150;
        long longVal = intVal; // widening: int -> long
        double doubleVal = longVal; // widening: long -> double
        System.out.println("Widening   : int " + intVal + " -> double " + doubleVal);

        // --- Narrowing (Explicit) conversion / Casting ---
        double pi = 3.99;
        int truncated = (int) pi; // data after decimal is lost
        System.out.println("Narrowing  : double " + pi + " -> int " + truncated);

        // --- String to int (Parsing) ---
        String numStr = "42";
        int parsed = Integer.parseInt(numStr);
        System.out.println("Parse int  : \"" + numStr + "\" -> " + parsed);

        // --- int to String ---
        int num = 256;
        String str = String.valueOf(num);
        System.out.println("To String  : " + num + " -> \"" + str + "\"");

        // --- char to int ---
        char ch = 'A';
        int ascii = (int) ch;
        System.out.println("Char ASCII : '" + ch + "' -> " + ascii);
    }
}
