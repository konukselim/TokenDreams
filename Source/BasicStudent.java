
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 
 */
public class BasicStudent extends Student {

    /**
     * Default constructor
     */
    public BasicStudent(String name, int speed, Vector2D position) {
        super(name, speed, position);
    }

    /**
     * @param g2d
     */
    public void draw(Graphics2D g2d) {

        FontMetrics metrics = g2d.getFontMetrics();

        g2d.setPaint(Color.GRAY);
        g2d.drawOval((int) position.x , (int) position.y , 45 , 45);
        g2d.setPaint(Color.BLACK);
        g2d.drawString( name + " (" + speed + ")" , (int) position.x  + (45 - metrics.stringWidth(name + " (" + speed + ")")) /2 , (int) position.y - 4);
        g2d.setPaint(Color.BLACK);
        g2d.drawString( Integer.toString(courses.size()) , (int) position.x + (45 - metrics.stringWidth(Integer.toString(courses.size()))) /2, (int) position.y+35);

        this.getState().draw(g2d,this);

    }

}