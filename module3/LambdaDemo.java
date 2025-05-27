import java.util.*;

public class LambdaDemo {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>(Arrays.asList(
            "John", "Alice", "Bob", "Charlie", "David", "Eve"
        ));
        
        System.out.println("Original list:");
        System.out.println(names);

        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        
        System.out.println("\nSorted list (ascending):");
        System.out.println(names);
        
        Collections.sort(names, (s1, s2) -> s2.compareTo(s1));
        
        System.out.println("\nSorted list (descending):");
        System.out.println(names);
      
        Collections.sort(names, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        
        System.out.println("\nSorted by length:");
        System.out.println(names);
    }
} 