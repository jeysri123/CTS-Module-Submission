public class ModuleDemo {
    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "world";
        
        String capitalizedName = StringUtils.capitalize(name);
        String reversedName = StringUtils.reverse(name);
        
        System.out.println("Hello, " + capitalizedName + "!");
        System.out.println("Your name reversed is: " + reversedName);
    }
}

class StringUtils {
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }
} 