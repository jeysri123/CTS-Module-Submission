public class BytecodeDemo {
    private int number;
    private String text;

    public BytecodeDemo(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int calculate(int x, int y) {
        int sum = x + y;
        int product = x * y;
        return sum + product;
    }

    public String processText(String input) {
        if (input == null) {
            return "null";
        }
        return input.toUpperCase() + " - " + number;
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("inspect")) {
            try {
                System.out.println("Compiling BytecodeDemo.java...");
                Process compile = Runtime.getRuntime().exec("javac BytecodeDemo.java");
                compile.waitFor();

                System.out.println("\nInspecting bytecode with javap -c...\n");
                Process javap = Runtime.getRuntime().exec("javap -c BytecodeDemo");
                javap.getInputStream().transferTo(System.out);

                System.out.println("\nInspecting bytecode with javap -v...\n");
                Process javapVerbose = Runtime.getRuntime().exec("javap -v BytecodeDemo");
                javapVerbose.getInputStream().transferTo(System.out);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            BytecodeDemo demo = new BytecodeDemo(42, "Hello");
            int result = demo.calculate(5, 3);
            String text = demo.processText("test");
            System.out.println("Result: " + result);
            System.out.println("Text: " + text);
        }
    }
} 