import java.util.*;

public class SnakeLadder{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of board");
        int boardsize = sc.nextInt();
        System.out.println("Enter the no of players");
        int players = sc.nextInt();
        System.out.println("Enter the no of snakes");
        int snakes = sc.nextInt();
        System.out.println("Enter the no of ladders");
        int ladder = sc.nextInt();

        Game start = new Game( boardsize , snakes,ladder);
        for (int i=1;i<=players;i++)
        {
            System.out.println("enter the  no."+i+"player name");
            String name=sc.next();
            Player player=new Player(name);
            start.addPlayer(player);

        }
        start.playGame();
        sc.close();

    }
}