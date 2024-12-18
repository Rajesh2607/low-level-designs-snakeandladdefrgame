import java.util.*;

public class Game {
    private Board board;
    private Dice dice;
    private Queue<Player> players;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Game(int boardSize, int snakeCount, int ladderCount) {
        this.board = new Board(boardSize);
        this.dice = new Dice();
        this.players = new LinkedList<>();
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();

        initializeSnakes(snakeCount);
        initializeLadders(ladderCount);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    private void initializeSnakes(int count) {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            int head = rand.nextInt(board.getstart() + 1, board.getend());
            int tail = rand.nextInt(board.getstart(), head);
            snakes.add(new Snake(head, tail));
        }
    }

    private void initializeLadders(int count) {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            int start = rand.nextInt(board.getstart(), board.getend() - 1);
            int end = rand.nextInt(start + 1, board.getend());
            ladders.add(new Ladder(start, end));
        }
    }

    public void playGame() {
        while (true) {
            Player currentPlayer = players.poll(); // Get the next player
            int diceRoll = dice.roll();
            System.out.println(currentPlayer.getName() + " rolled a " + diceRoll);

            int newPosition = currentPlayer.getPosition() + diceRoll;

            if (newPosition > board.getend()) {
                System.out.println(currentPlayer.getName() + " rolled too high and stays at " + currentPlayer.getPosition());
                players.add(currentPlayer); // Add player back to the queue
                continue;
            }

            for (Snake snake : snakes) {
                if (snake.gethead() == newPosition) {
                    System.out.println(currentPlayer.getName() + " hit a snake! Sliding down to " + snake.gettail());
                    newPosition = snake.gettail();
                }
            }

            for (Ladder ladder : ladders) {
                if (ladder.getstart() == newPosition) {
                    System.out.println(currentPlayer.getName() + " climbed a ladder! Moving up to " + ladder.getend());
                    newPosition = ladder.getend();
                }
            }

            currentPlayer.setPosition(newPosition);

            System.out.println(currentPlayer.getName() + " is now at position " + currentPlayer.getPosition());

            if (newPosition == board.getend()) {
                System.out.println(currentPlayer.getName() + " wins the game!");
                break;
            }

            players.add(currentPlayer); // Add player back to the queue
        }
    }
}
