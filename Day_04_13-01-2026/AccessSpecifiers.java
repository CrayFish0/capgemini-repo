// Day 4 – Access Specifiers and Static vs Non-Static Methods

public class AccessSpecifiers {

    // public – accessible from anywhere
    public int publicVar = 1;

    // protected – accessible within same package and subclasses
    protected int protectedVar = 2;

    // default (no modifier) – accessible within same package
    int defaultVar = 3;

    // private – accessible only within this class
    private int privateVar = 4;

    // Getter for private variable (encapsulation principle)
    public int getPrivateVar() {
        return privateVar;
    }

    // ---- Static vs Non-Static ----

    // Static method: belongs to the class, not an instance.
    // Can be called without creating an object.
    static void staticMethod() {
        System.out.println("Static method – called on class directly.");
    }

    // Non-static (instance) method: requires an object to call.
    void instanceMethod() {
        System.out.println("Instance method – called on an object.");
        System.out.println("Accessing instance variable publicVar = " + publicVar);
    }

    // Static variable shared across all instances
    static int instanceCount = 0;

    AccessSpecifiers() {
        instanceCount++;
    }

    public static void main(String[] args) {
        // Call static method – no object needed
        AccessSpecifiers.staticMethod();

        // Create object to call instance method
        AccessSpecifiers obj = new AccessSpecifiers();
        obj.instanceMethod();

        System.out.println("Public    : " + obj.publicVar);
        System.out.println("Protected : " + obj.protectedVar);
        System.out.println("Default   : " + obj.defaultVar);
        System.out.println("Private (via getter): " + obj.getPrivateVar());

        // Show static variable shared count
        new AccessSpecifiers();
        new AccessSpecifiers();
        System.out.println("Total instances created: " + instanceCount);
    }
}
