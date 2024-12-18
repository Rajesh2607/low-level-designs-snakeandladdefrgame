import java.util.*;
public class Dice {
    public int roll()
    {
        Random rand=new Random();
        return rand.nextInt(0,6);
    }
}
