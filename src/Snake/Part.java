package Snake;

public class Part {
    int x;
    int y;

    Part(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Part addPart(Part p){
        return new Part(this.x+p.x,this.y+p.y);
    }
}
