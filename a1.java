 import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class NumberGuessingGame {

    // Store previous players and scores
    static ArrayList<String> playerHistory = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {

            System.out.println("\n==============================");
            System.out.println("     NUMBER GUESSING GAME");
            System.out.println("==============================");

            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            int number = random.nextInt(100) + 1;
            int guess;
            int attempts = 0;
            int score = 100;

            // Timer starts
            long startTime = System.currentTimeMillis();

            System.out.println("\nGuess a number between 1 and 100.");
            System.out.println("You have 30 seconds!");
            System.out.println();

            while (true) {

                // Check timer
                long currentTime = System.currentTimeMillis();
                long timePassed = (currentTime - startTime) / 1000;

                if (timePassed >= 30) {
                    System.out.println("\n⏰ Time's Up!");
                    System.out.println("The correct number was: " + number);
                    break;
                }

                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                attempts++;

                if (guess == number) {

                    // Give score according to attempts
                    score = score - ((attempts - 1) * 10);

                    if (score < 0) {
                        score = 0;
                    }

                    System.out.println("\n🎉 Correct Answer!");
                    System.out.println("You guessed the number in "
                            + attempts + " attempts.");

                    break;

                } else if (guess > number) {

                    System.out.println("Too High! Try again.");
                    score = score - 5;

                } else {

                    System.out.println("Too Low! Try again.");
                    score = score - 5;
                }

                if (score < 0) {
                    score = 0;
                }

                System.out.println("Current Score: " + score);
            }

            // Calculate total time
            long endTime = System.currentTimeMillis();
            long totalTime = (endTime - startTime) / 1000;

            // Display final result
            System.out.println("\n==============================");
            System.out.println("         GAME OVER");
            System.out.println("==============================");

            System.out.println("Player Name : " + name);
            System.out.println("Attempts    : " + attempts);
            System.out.println("Time Taken  : " + totalTime + " seconds");
            System.out.println("Final Score : " + score);

            // Save player history
            playerHistory.add(
                    name + " | Score: " + score
                    + " | Attempts: " + attempts
                    + " | Time: " + totalTime + " sec"
            );

            // Display history
            System.out.println("\n===== PLAYER HISTORY =====");

            for (int i = 0; i < playerHistory.size(); i++) {
                System.out.println((i + 1) + ". " + playerHistory.get(i));
            }

            // Play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = sc.next();

            if (!answer.equalsIgnoreCase("yes")) {
                playAgain = false;
            }

            sc.nextLine(); // clear input
        }

        System.out.println("\nThanks for playing! 🎮");
        sc.close();
    }
}
ayushi rathod 
iklahfigegeihipfyeahiehfeelkhtgf;9  
