import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
     public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random randomNumberGenerator = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int roundCount = 0;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = randomNumberGenerator.nextInt(maxRange - minRange + 1) + minRange;
            int attemptCount = 0;
            roundCount++;

            System.out.println("Round " + roundCount);
            System.out.println("I've selected a number between " + minRange + " and " + maxRange + ".");
            System.out.println("Try to guess the number within " + maxAttempts + " attempts.");

            while (attemptCount < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = inputScanner.nextInt();
                attemptCount++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number in " + attemptCount + " attempts.");
                    totalScore += maxAttempts - attemptCount + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                if (attemptCount < maxAttempts) {
                    System.out.println("You have " + (maxAttempts - attemptCount) + " attempts remaining.");
                } else {
                    System.out.println("You've used all your attempts. The correct number was " + targetNumber + ".");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = inputScanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your total score is " + totalScore + " points.");
        inputScanner.close();
    }
}
