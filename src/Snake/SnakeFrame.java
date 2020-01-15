package Snake;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeFrame extends JFrame implements ActionListener, KeyListener {
    public JFrame gameFrame;
    public SnakeMap snakeMap;
    public RenderPanel renderPanel;
    public Timer timer;
    public Snake snake;
    public boolean gameOver = false;
    int whenRenderApple = 0;

    public SnakeFrame(SnakeMap snakeMap){
        this.snakeMap = snakeMap;

        gameFrame = new JFrame("Snake 2020");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(500,500);
        gameFrame.setLocationRelativeTo(null);

        renderPanel = new RenderPanel(gameFrame,this.snakeMap,this);
        renderPanel.setSize(new Dimension(1, 1));
        gameFrame.add(renderPanel);
        gameFrame.addKeyListener(this);


        timer = new Timer(30, this);
        snake = snakeMap.snake;
    }

    public void startGame(){


        gameFrame.setVisible(true);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(whenRenderApple == 5) {
            snakeMap.renderApple();
            whenRenderApple=0;
        }
        snake.move(snake.direction);
        snake.repairSnake(this.snakeMap.width,this.snakeMap.height);
        snakeMap.isSnakeAtApple();
        if(snake.snakeIsCollision()){
            gameOver=true;
            timer.stop();
        }
        this.renderPanel.repaint();

        whenRenderApple++;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();

        if (i == KeyEvent.VK_A || i == KeyEvent.VK_LEFT) {
            snake.changeDirection(Directions.LEFT);
        }

        if (i == KeyEvent.VK_D || i == KeyEvent.VK_RIGHT) {
            snake.changeDirection(Directions.RIGHT);
        }

        if (i == KeyEvent.VK_W || i == KeyEvent.VK_UP) {
            snake.changeDirection(Directions.FORWARD);
        }

        if (i == 40 || i == 83) {
            snake.changeDirection(Directions.BACKWARD);
        }

        if (i == 32 ) {
            if (gameOver) {
                restartGame();
            }

        }
    }

    public void restartGame(){
        this.snakeMap = new SnakeMap(40,40);
        this.snake = snakeMap.snake;
        this.gameOver = false;
        this.gameFrame.remove(renderPanel);
        renderPanel = new RenderPanel(gameFrame,this.snakeMap,this);
        renderPanel.setSize(new Dimension(1, 1));
        gameFrame.add(renderPanel);
        startGame();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}

