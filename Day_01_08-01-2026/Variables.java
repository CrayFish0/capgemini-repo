// Day 1 – Literals and Variables
// Variables store data values; literals are the actual values assigned.

public class Variables {
    public static void main(String[] args) {
        // Primitive data types
        byte b = 127;
        short s = 32000;
        int i = 1_000_000;
        long l = 9_876_543_210L;
        float f = 3.14f;
        double d = 3.141592653589793;
        char c = 'Z';
        boolean bl = false;

        System.out.println("byte    : " + b);
        System.out.println("short   : " + s);
        System.out.println("int     : " + i);
        System.out.println("long    : " + l);
        System.out.println("float   : " + f);
        System.out.println("double  : " + d);
        System.out.println("char    : " + c);
        System.out.println("boolean : " + bl);

        // String literal (reference type)
        String name = "Capgemini Trainee";
        System.out.println("name    : " + name);

        // Constants (final)
        final double TAX_RATE = 0.18;
        System.out.println("TAX     : " + TAX_RATE);
    }
}
