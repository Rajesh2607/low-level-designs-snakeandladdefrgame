public class Board {
    private int size;
    private int start;
    private int end;

    public Board(int size){
        this.start=1;
        this.end=start+size-1;
        this.size=size;
    }
    public int getstart(){
        return start;
    }
    public int getsize()
    {
        return size;
    }
    public int getend(){
        return end;
    }
}
