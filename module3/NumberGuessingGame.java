import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int guess;
        boolean correct = false;
        
        System.out.println("Guess the number between 1 and 100.");
        
        while (!correct) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            
            if (guess == secretNumber) {
                System.out.println("Correct! The number was " + secretNumber);
                correct = true;
            } else if (guess < secretNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }
        }
        
        scanner.close();
    }
} 