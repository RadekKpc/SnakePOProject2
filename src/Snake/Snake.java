package Snake;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Snake {


    ArrayList<Part> tail = new ArrayList<Part>();
    public Directions direction = Directions.LEFT;

    public Snake(int size){

        this.tail.add(new Part(0,20));

        for(int i=1;i<size;i++){
            this.tail.add(new Part(i,20));
        }
    }

    public void move(Directions d){

        for(int i=tail.size()-1;i>0;i--){
            tail.set(i,tail.get(i-1));
        }
        tail.set(0,tail.get(0).addPart(d.toPart(d)));
    }

    public void setTail(ArrayList<Part> tail) {
        this.tail = tail;
    }

    public boolean snakeIsAt(Part p){
        for (Part t:tail) {
            if(t.x == p.x && t.y == p.y)return true;
        }
        return false;
    }

    public void repairSnake(int mapSizeX, int mapSizeY){
        for (Part t:tail) {
            if(t.x < 0)t.x=mapSizeX;
            if(t.x > mapSizeX)t.x = 0;
            if(t.y < 0)t.y=mapSizeY;
            if(t.y > mapSizeY)t.y=0;
        }
    }
    public void eat(){
        tail.add(new Part(-1,-1));
    }

    public void changeDirection(Directions d){
        if(d == Directions.RIGHT)if(direction!=Directions.LEFT)direction=d;
        if(d == Directions.LEFT)if(direction!=Directions.RIGHT)direction=d;
        if(d == Directions.FORWARD)if(direction!=Directions.BACKWARD)direction=d;
        if(d == Directions.BACKWARD)if(direction!=Directions.FORWARD)direction=d;
    }

    public boolean snakeIsCollision(){
        for(int i=0;i<tail.size();i++){
            for(int j=0;j<tail.size();j++){
                if(j!=i){
                    if(tail.get(i).x == tail.get(j).x && tail.get(i).y == tail.get(j).y)
                        return true;
                }
            }
        }
        return false;
    }
}
