// Day 12 – Wrapper Classes
// Each primitive type has a corresponding wrapper class in java.lang.
// Allows primitives to be used in Collections, generics, and provides utility methods.

public class WrapperClasses {
    public static void main(String[] args) {
        // ===== Boxing & Unboxing =====
        // Autoboxing: primitive -> Wrapper
        int primitiveInt = 42;
        Integer wrappedInt = primitiveInt; // autoboxing
        System.out.println("Autoboxed  : " + wrappedInt);

        // Unboxing: Wrapper -> primitive
        double d = 3.14;
        Double wd = d; // boxing
        double d2 = wd; // unboxing
        System.out.println("Unboxed    : " + d2);

        // ===== Wrapper Utility Methods =====
        System.out.println("\n=== Integer utilities ===");
        System.out.println("parseInt    : " + Integer.parseInt("123"));
        System.out.println("toBinary    : " + Integer.toBinaryString(10));
        System.out.println("toHex       : " + Integer.toHexString(255));
        System.out.println("toOctal     : " + Integer.toOctalString(8));
        System.out.println("MAX_VALUE   : " + Integer.MAX_VALUE);
        System.out.println("MIN_VALUE   : " + Integer.MIN_VALUE);
        System.out.println("compare     : " + Integer.compare(5, 10));
        System.out.println("max(5,10)   : " + Integer.max(5, 10));

        System.out.println("\n=== Double utilities ===");
        System.out.println("parseDouble : " + Double.parseDouble("3.14"));
        System.out.println("isNaN       : " + Double.isNaN(0.0 / 0.0));
        System.out.println("isInfinite  : " + Double.isInfinite(1.0 / 0.0));

        System.out.println("\n=== Character utilities ===");
        char c = 'A';
        System.out.println("isLetter    : " + Character.isLetter(c));
        System.out.println("isDigit     : " + Character.isDigit(c));
        System.out.println("toLowerCase : " + Character.toLowerCase(c));
        System.out.println("toUpperCase : " + Character.toUpperCase('z'));

        System.out.println("\n=== Boolean utilities ===");
        System.out.println("parseBoolean: " + Boolean.parseBoolean("true"));
        System.out.println("toString    : " + Boolean.toString(false));

        // ===== Null-safe with Wrapper =====
        Integer nullableInt = null;
        System.out.println("\nWrapper can be null : " + nullableInt);
    }
}
