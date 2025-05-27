import java.lang.reflect.*;

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class<?> targetClass = Class.forName("ReflectionDemo$TargetClass");
            Object instance = targetClass.getDeclaredConstructor(int.class, String.class)
                .newInstance(42, "Test");

            System.out.println("Class Name: " + targetClass.getName());
            System.out.println("\nDeclared Methods:");
            
            for (Method method : targetClass.getDeclaredMethods()) {
                System.out.println("\nMethod: " + method.getName());
                System.out.println("Return Type: " + method.getReturnType().getName());
                
                System.out.println("Parameters:");
                for (Parameter param : method.getParameters()) {
                    System.out.println("  - " + param.getType().getName() + " " + param.getName());
                }
                
                if (method.getName().equals("calculate")) {
                    Object result = method.invoke(instance, 5);
                    System.out.println("Invoked calculate(5) = " + result);
                }
                
                if (method.getName().equals("process")) {
                    Object result = method.invoke(instance, "hello");
                    System.out.println("Invoked process(\"hello\") = " + result);
                }
            }

            System.out.println("\nDeclared Fields:");
            for (Field field : targetClass.getDeclaredFields()) {
                field.setAccessible(true);
                System.out.println(field.getName() + " = " + field.get(instance));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
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