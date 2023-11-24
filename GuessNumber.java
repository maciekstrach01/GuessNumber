import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(101);

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("Try to guess the number between 0 and 100.");

        int attempts = 0;
        boolean hasGuessed = false;

        while (attempts < 5) {
            System.out.print("Enter your guess: ");

            try {
                int userGuess = scanner.nextInt();

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the number.");
                    hasGuessed = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }

                attempts++;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        if (!hasGuessed) {
            System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
        }

        scanner.close();
    }
}
