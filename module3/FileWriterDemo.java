import java.util.*;
import java.io.*;

public class FileWriterDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter text to write to file: ");
            String text = scanner.nextLine();
            
            FileWriter writer = new FileWriter("output.txt");
            writer.write(text);
            writer.close();
            
            System.out.println("Text has been written to output.txt successfully!");
            
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
} 