import java.util.Scanner;

public class Game {
    Player p = new Player();
    public void startGame() throws InterruptedException {

        // *** Pre Game Info *** //
        p.playerScore = 0;
        p.playerHighScore = 0;

        // Only runs once, just to introduce player, get name, etc
        System.out.println("Welcome to Flip A Coin!");
        Thread.sleep(2000);
        System.out.println("The game is simple, press F to flip a coin!");
        Thread.sleep(2000);
        System.out.println("If you win, you...won't get anything.");
        Thread.sleep(2000);

        // Get the player's name
        Scanner info = new Scanner(System.in);
        System.out.println("What is your name?");
        p.player_name = info.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Best of luck " + p.player_name);
        Thread.sleep(2000);

        // Start game
        boolean play = true;
        while (play) {
            // Ask for heads or tails
            Scanner want = new Scanner(System.in);
            System.out.println("What side do you want?\nheads or tails?");
            String user_want = want.nextLine().toLowerCase();
            while (!user_want.equals("heads") && !user_want.equals("tails")) {
                System.out.println("Please pick either heads or tails!");
                user_want = want.nextLine().toLowerCase();
            }
            // User choice selection
            if (user_want.equals("heads")) {
                System.out.println("You have selected heads!");
                p.player_choice = "heads";
                Thread.sleep(2000);
            } else if (user_want.equals("tails")) {
                System.out.println("You have selected tails!");
                p.player_choice = "tails";
                Thread.sleep(2000);
            }

            // Ask the user to flip the coin
            Scanner flip = new Scanner(System.in);
            System.out.println("Press F to flip!");
            Thread.sleep(2000);

            String user_flip = flip.nextLine().toLowerCase();
            while (!user_flip.equals("f")) {
                System.out.println("Please press F!");
                user_flip = flip.nextLine().toLowerCase();
            }

            double coin_flip = Math.random();
            String coin_value = coin_flip > 0.50 ? "heads" : "tails";
            System.out.println("The coin landed on " + coin_value + "!");
            Thread.sleep(2000);

            // Winning case
            if ((user_want.equals("heads") && coin_value.equals("heads")) || (user_want.equals("tails") && coin_value.equals("tails"))) {
                System.out.println("Congratulations " + p.player_name + ". You Won!");

                // Update scores
                p.playerScore += 1;
                p.playerHighScore += 1;
                System.out.println("Your current score is: " + p.playerScore);
                Thread.sleep(2000);
                System.out.println("Your all-time high score is: " + p.playerHighScore);
                Thread.sleep(2000);
                // Ask if they want to flip again or quit
                System.out.println("Would you like to flip again? yes | no");
                Scanner flipAgain = new Scanner(System.in);
                String fAgain = flipAgain.nextLine().toLowerCase();

                while (!fAgain.equals("yes") && !fAgain.equals("no")) {
                    System.out.println("Please choose a valid option: yes | no");
                    fAgain = flipAgain.nextLine().toLowerCase();
                }

                if (fAgain.equals("no")) {
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                    play = false;
                }
                // If the user chooses to flip again, continue without the intro
            }
            // This is the losing case
            else {
                System.out.println("Sorry but you lost!");
                System.out.println("Your high score was " + p.playerHighScore + ".");
                System.out.println("Would you like to play again?");
                Scanner endGame = new Scanner(System.in);
                String endChoice = endGame.nextLine().toLowerCase();

                while (!endChoice.equals("yes") && !endChoice.equals("no")) {
                    System.out.println("Please choose yes or no");
                    endChoice = endGame.nextLine().toLowerCase();
                }

                if (endChoice.equals("no")) {
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                } else {
                    p.playerScore = 0;
                    continue;
                }
            }
        }
    }
}
