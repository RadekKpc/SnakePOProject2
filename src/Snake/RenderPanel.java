package Snake;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class RenderPanel extends JPanel {

    public JFrame mainFrame;
    public SnakeFrame gameFrame;
    public SnakeMap snakeMap;
    public Snake snake;
    public RenderPanel(JFrame f,SnakeMap snakeMap,SnakeFrame gameFrame){
        this.mainFrame = f;
        this.snakeMap = snakeMap;
        this.snake = snakeMap.snake;
        this.gameFrame= gameFrame;
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setSize(mainFrame.getWidth(),mainFrame.getHeight()-38);
        this.setLocation(0, 0);
        int width = this.getWidth();
        int height = this.getHeight(); //38 is toolbar size
        int ScaleX = width/snakeMap.width;
        int ScaleY = height/snakeMap.height;

        g.setColor(new Color(81, 224, 111));
        g.fillRect(0, 0, width, height);

        int c=0;
        for (Part p: snake.tail){
            if(c==0)g.setColor(new Color(140, 148, 224));
            else g.setColor(new Color(213, 224, 52));
            c++;
            g.fillRect(p.x*ScaleX,p.y*ScaleY,ScaleX,ScaleY);
        }

        g.setColor(new Color(224, 80, 89));
        for (Part p: snakeMap.apples){
            g.fillRect(p.x*ScaleX,p.y*ScaleY,ScaleX,ScaleY);
        }
        g.setColor(new Color(0, 0, 0));
        String str = "Your Score: " + this.snakeMap.score;
        g.drawString(str,10,height -20);

        if(this.gameFrame.gameOver){
            str = "Kliknij spację aby spróbować ponownie";
            g.drawString(str,width/2 - 100 ,height /2);
        }

    }
}
