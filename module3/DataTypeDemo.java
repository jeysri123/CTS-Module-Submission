import java.util.*;

public class DataTypeDemo {
    public static void main(String[] args) {
        byte byteNum = 127;
        short shortNum = 32767;
        int intNum = 2147483647;
        long longNum = 9223372036854775807L;
        
        float floatNum = 3.14159f;
        double doubleNum = 3.141592653589793;
        
        char charVal = 'A';
        boolean boolVal = true;
        
        System.out.println("Integer Types:");
        System.out.println("byte: " + byteNum);
        System.out.println("short: " + shortNum);
        System.out.println("int: " + intNum);
        System.out.println("long: " + longNum);
        
        System.out.println("\nFloating-Point Types:");
        System.out.println("float: " + floatNum);
        System.out.println("double: " + doubleNum);
        
        System.out.println("\nCharacter Type:");
        System.out.println("char: " + charVal);
        
        System.out.println("\nBoolean Type:");
        System.out.println("boolean: " + boolVal);
    }
} 