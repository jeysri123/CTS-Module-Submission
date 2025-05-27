import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Original list:");
        System.out.println(numbers);
        
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
            
        System.out.println("\nEven numbers:");
        System.out.println(evenNumbers);
        
        System.out.println("\nSum of even numbers: " + 
            numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum());
                
        System.out.println("\nEven numbers squared:");
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .forEach(n -> System.out.print(n + " "));
    }
} 