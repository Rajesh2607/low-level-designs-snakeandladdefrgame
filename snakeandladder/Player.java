
public class Player {
    private String name;
    private int position;
    private boolean won;

    public Player(String name)
    {
        this.name=name;
        this.position=0;
        this.won=false;
    }
    public int getPosition()
    {
        return position;
    }
    public void setPosition(int position){
        this.position=position;
    }
    public void setWon(boolean won){
        this.won=true;
    }
    public String getName()
    {
        return name;
    }

    
}
