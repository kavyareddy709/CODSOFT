import java.util.Scanner;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            rounds++;
            System.out.println("\nRound " + rounds);
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (between 1 and 100): ");
                int userGuess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempt(s)!");
                    score += maxAttempts - attempts + 1; // Increase score based on attempts left
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Number is Smaller");
                } else {
                    System.out.println("Number is Bigger");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + randomNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing!");
                System.out.println("Your total score is: " + score);
                System.out.println("Your average attempts per round is: " + (double) totalAttempts / rounds);
                break;
            }
        }

        scanner.close();
    }
}