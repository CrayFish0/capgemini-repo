// Day 6 – StringBuffer and StringBuilder
// String is immutable; StringBuffer/StringBuilder are mutable.
// StringBuffer  – thread-safe (synchronized), slightly slower.
// StringBuilder – not thread-safe, faster for single-threaded use.

public class StringBufferBuilder {
    public static void main(String[] args) {
        // ===== StringBuffer =====
        System.out.println("=== StringBuffer ===");
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(", World");
        sb.append("!");
        System.out.println("append   : " + sb);

        sb.insert(5, " Java");
        System.out.println("insert   : " + sb);

        sb.delete(5, 10);
        System.out.println("delete   : " + sb);

        sb.reverse();
        System.out.println("reverse  : " + sb);

        sb.replace(0, 5, "XXXXX");
        System.out.println("replace  : " + sb);

        System.out.println("length   : " + sb.length());
        System.out.println("charAt 0 : " + sb.charAt(0));

        // ===== StringBuilder =====
        System.out.println("\n=== StringBuilder ===");
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            builder.append("item").append(i);
            if (i < 5)
                builder.append(", ");
        }
        System.out.println("Built    : " + builder);

        // Performance comparison (String concatenation vs StringBuilder)
        System.out.println("\n=== Performance ===");
        long start1 = System.nanoTime();
        String concat = "";
        for (int i = 0; i < 1000; i++)
            concat += "a";
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        StringBuilder sbPerf = new StringBuilder();
        for (int i = 0; i < 1000; i++)
            sbPerf.append("a");
        long end2 = System.nanoTime();

        System.out.println("String concat time   : " + (end1 - start1) + " ns");
        System.out.println("StringBuilder time   : " + (end2 - start2) + " ns");
    }
}
