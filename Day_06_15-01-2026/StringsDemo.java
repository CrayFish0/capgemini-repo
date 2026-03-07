// Day 6 – Strings in Java

public class StringsDemo {
    public static void main(String[] args) {
        String s = "Hello, Java World!";

        // Common String methods
        System.out.println("Original   : " + s);
        System.out.println("Length     : " + s.length());
        System.out.println("Upper      : " + s.toUpperCase());
        System.out.println("Lower      : " + s.toLowerCase());
        System.out.println("Trim       : " + "  hello  ".trim());
        System.out.println("charAt(7)  : " + s.charAt(7));
        System.out.println("indexOf('J'): " + s.indexOf('J'));
        System.out.println("substring(7,11): " + s.substring(7, 11));
        System.out.println("replace    : " + s.replace("Java", "Python"));
        System.out.println("contains   : " + s.contains("World"));
        System.out.println("startsWith : " + s.startsWith("Hello"));
        System.out.println("endsWith   : " + s.endsWith("!"));

        // Split
        String csv = "Alice,Bob,Charlie,Dave";
        String[] names = csv.split(",");
        for (String name : names)
            System.out.print(name + " ");
        System.out.println();

        // String comparison
        String a = "hello", b = "hello", c = new String("hello");
        System.out.println("\na.equals(b)   : " + a.equals(b)); // true
        System.out.println("a == c        : " + (a == c)); // false (different refs)
        System.out.println("a.equalsIgnoreCase(\"HELLO\"): " + a.equalsIgnoreCase("HELLO"));

        // String is immutable
        String original = "Java";
        original.concat(" is great"); // does NOT change original
        System.out.println("\nImmutable: " + original);
        String modified = original.concat(" is great");
        System.out.println("New ref  : " + modified);

        // Reverse a string manually
        String rev = new StringBuilder("capgemini").reverse().toString();
        System.out.println("Reversed : " + rev);
    }
}
