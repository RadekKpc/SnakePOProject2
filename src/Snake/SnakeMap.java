package Snake;

import java.util.ArrayList;
import java.util.Random;

public class SnakeMap {

    Snake snake;
    public int height;
    public int width;
    public ArrayList<Part> apples = new ArrayList<Part>();
    int score;
    SnakeMap(int height,int width){
        snake = new Snake(4);
        this.height =height;
        this.width = width;
        renderApple();
        renderApple();
        renderApple();
        this.score =0;
    }

    void renderApple(){
        int c = 0;
        Part p;
        do{
           p  = new Part(new Random().nextInt(width+1),new Random().nextInt(height+1));
           c++;
        }while(snake.snakeIsAt(p) && c< 200);
        apples.add(p);

    }
    void isSnakeAtApple(){
        int toRemove= 999;
        for (Part p: apples) {
            if(snake.snakeIsAt(p)){
                for(int i=0;i<apples.size();i++){
                    if(apples.get(i) == p)toRemove =i;
                }
                snake.eat();
                score++;
            }
        }
        if(toRemove!= 999)apples.remove(toRemove);
    }

}
