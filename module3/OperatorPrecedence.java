import java.util.*;

public class OperatorPrecedence {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;
        int result3 = 10 + 5 / 2;
        int result4 = (10 + 5) / 2;
        int result5 = 2 + 3 * 4 - 5;
        int result6 = (2 + 3) * (4 - 5);

        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("(10 + 5) * 2 = " + result2);
        System.out.println("10 + 5 / 2 = " + result3);
        System.out.println("(10 + 5) / 2 = " + result4);
        System.out.println("2 + 3 * 4 - 5 = " + result5);
        System.out.println("(2 + 3) * (4 - 5) = " + result6);
    }
} 