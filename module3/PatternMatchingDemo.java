public class PatternMatchingDemo {
    public static void main(String[] args) {
        Object[] objects = {
            "Hello",
            42,
            3.14,
            true,
            new int[]{1, 2, 3},
            null
        };
        
        for (Object obj : objects) {
            String result = switch (obj) {
                case String s -> "String: " + s;
                case Integer i -> "Integer: " + i;
                case Double d -> "Double: " + d;
                case Boolean b -> "Boolean: " + b;
                case int[] arr -> "Array with " + arr.length + " elements";
                case null -> "null value";
                default -> "Unknown type: " + obj.getClass().getSimpleName();
            };
            System.out.println(result);
        }
    }
} 