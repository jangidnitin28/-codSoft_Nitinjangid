import java.util.Random;
import java.util.Scanner;

public class task1 {

     private static final int MAX_ATTEMPTS = 7;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("\n Welcome to the Number Guessing Game ");

        boolean playAgain = true;
        while (playAgain) {
            roundsPlayed++;
            boolean won = playSingleRound(sc);

            if (won) {
                roundsWon++;
            }

            System.out.println("\n Scoreboard: Rounds Played = " + roundsPlayed + ", Rounds Won = " + roundsWon);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next().trim().toLowerCase();
            playAgain = choice.equals("yes") || choice.equals("y");
        }

        System.out.println("\n Final Scoreboard:");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println(" Thanks for playing!");
        sc.close();
    }

    private static boolean playSingleRound(Scanner sc) {
        Random rand = new Random();
        int secretNumber = rand.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
        int attemptsUsed = 0;

        System.out.println("\nI have chosen a number between " + RANGE_START + " and " + RANGE_END + ". Can you guess it?");

        while (attemptsUsed < MAX_ATTEMPTS) {
            System.out.print("Attempt " + (attemptsUsed + 1) + "/" + MAX_ATTEMPTS + " → Enter your guess: ");

            // check input validation
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // discard invalid
                continue;
            }

            int guess = sc.nextInt();
            attemptsUsed++;

            if (guess == secretNumber) {
                System.out.println(" Correct! You guessed the number in " + attemptsUsed + " attempts.");
                return true;
            } else if (guess < secretNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        System.out.println("\n Out of attempts! The correct number was: " + secretNumber);
        return false;
    }
    
}
