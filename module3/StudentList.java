import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        
        while (true) {
            System.out.println("\n1. Add student name");
            System.out.println("2. Display all students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    students.add(name);
                    System.out.println("Student added successfully!");
                    break;
                    
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students in the list!");
                    } else {
                        System.out.println("\nStudent List:");
                        System.out.println("-------------");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println((i + 1) + ". " + students.get(i));
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
} 