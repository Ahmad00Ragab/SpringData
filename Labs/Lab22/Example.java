public class Example {
    // Fields : static fields & instance fields
    private static int staticField = initializeStaticField();
    private int instanceField      = initializeInstanceField();

    // Initializer Blocks : static & instance
    static {
        System.out.println(staticField);
        System.out.println("Static initializer block");
    }

    {
        System.out.println(this.instanceField);
        System.out.println("Instance initializer block");
    }

    // constructor 
    public Example() {
        System.out.println("Constructor");
    }
    private static int initializeStaticField() {
        System.out.println("Static field initialized");
        return 1;
    }

    private int initializeInstanceField() {
        System.out.println("Instance field initialized");
        return 2;
    }

    public static void main(String[] args) {
        System.out.println("Main method started");
        Example example = new Example();
        Example example2 = new Example(); // static initializer block will be exe-cuted only one time before calling the main
    }
}