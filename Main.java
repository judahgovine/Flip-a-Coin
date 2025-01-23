public class Main {
    public static void main(String[] args) {
        Game game1 = new Game();
        try {
            game1.startGame();
        } catch (InterruptedException e) {
            System.exit(0);
        }
    }
}
