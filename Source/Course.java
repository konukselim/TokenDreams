
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Course implements AnimationDrawEntity {

    public Course(String name, Color color, int minTokens , Vector2D v , int width){
        this.name = name;
        this.color = color;
        this.minTokens = minTokens;
        this.position = v;
        this.width = width;
        this.studentNumber = 0;
    }


    public String name;
    public Color color;
    public int minTokens;
    public Vector2D position;
    public int width;
    public int studentNumber;


    public void draw(Graphics2D g2d) {

        int wide = width;
        int startWidth = (int) position.x - wide/2;

        g2d.setColor(color);
        g2d.fillRect(startWidth, 0, wide , 100);

        float thickness = 1;
        g2d.setStroke(new BasicStroke(thickness));

        g2d.setColor(Color.BLACK);
        g2d.drawRect(startWidth, 0, wide , 100);

        FontMetrics metrics = g2d.getFontMetrics();

        String text1 = "Min Tokens: " + minTokens;
        String text2 = "Students: " + studentNumber;
        g2d.drawString(name, startWidth + (wide - metrics.stringWidth(name)) /2 , (20 - metrics.getHeight())/2 + metrics.getAscent());
        g2d.drawString(text1, startWidth + (wide - metrics.stringWidth(text1)) /2 , (60 - metrics.getHeight())/2 + metrics.getAscent());
        g2d.drawString(text2, startWidth + (wide - metrics.stringWidth(text2)) /2 , (100 - metrics.getHeight())/2 + metrics.getAscent());

    }


}