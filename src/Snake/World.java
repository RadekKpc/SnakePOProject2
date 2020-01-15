package Snake;

public class World {

    public static void main(String[] args) {
        SnakeMap snakeMap = new SnakeMap(40,40);
        SnakeFrame s = new SnakeFrame(snakeMap);
        s.startGame();
    }
}
