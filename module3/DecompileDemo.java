import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;

public class DecompileDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Compiling DecompileDemo$TargetClass.class...");
            Process compile = Runtime.getRuntime().exec("javac DecompileDemo.java");
            compile.waitFor();

            System.out.println("\nDecompiling DecompileDemo$TargetClass.class...\n");
            Process decompile = Runtime.getRuntime().exec("java -jar cfr.jar DecompileDemo$TargetClass.class");
            decompile.getInputStream().transferTo(System.out);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static class TargetClass {
        private int value;
        private String name;
        private static final double PI = 3.14159;

        public TargetClass(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int calculate(int x) {
            int result = 0;
            for (int i = 0; i < x; i++) {
                result += i * value;
            }
            return result;
        }

        public String process(String input) {
            if (input == null) {
                return "null";
            }
            StringBuilder sb = new StringBuilder();
            for (char c : input.toCharArray()) {
                sb.append(Character.toUpperCase(c));
            }
            return sb.toString() + " - " + name;
        }

        @Override
        public String toString() {
            return String.format("TargetClass{value=%d, name='%s', PI=%.5f}", 
                value, name, PI);
        }
    }
} 