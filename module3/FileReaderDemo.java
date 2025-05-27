import java.io.*;
import java.util.*;

public class FileReaderDemo {
    public static void main(String[] args) {
        try {
            File file = new File("output.txt");
            Scanner fileReader = new Scanner(file);
            
            System.out.println("Contents of output.txt:");
            System.out.println("----------------------");
            
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
            }
            
            fileReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File 'output.txt' not found!");
        }
    }
} 