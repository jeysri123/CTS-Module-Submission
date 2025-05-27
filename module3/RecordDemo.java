import java.util.*;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class RecordDemo {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
            new Person("John", 25),
            new Person("Alice", 17),
            new Person("Bob", 30),
            new Person("Eve", 16),
            new Person("Charlie", 22)
        );
        
        System.out.println("All people:");
        people.forEach(System.out::println);
        
        List<Person> adults = people.stream()
            .filter(p -> p.age() >= 18)
            .collect(Collectors.toList());
            
        System.out.println("\nAdults (18 or older):");
        adults.forEach(System.out::println);
    
        double averageAge = people.stream()
            .mapToInt(Person::age)
            .average()
            .orElse(0.0);
            
        System.out.println("\nAverage age: " + averageAge);
        
        Map<String, List<Person>> ageGroups = people.stream()
            .collect(Collectors.groupingBy(p -> 
                p.age() < 18 ? "Minor" : "Adult"));
                
        System.out.println("\nPeople by age category:");
        ageGroups.forEach((category, list) -> {
            System.out.println(category + ":");
            list.forEach(p -> System.out.println("  " + p));
        });
    }
} 