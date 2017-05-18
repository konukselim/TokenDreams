
import java.awt.*;
import java.util.*;

/**
 * 
 */
public abstract class Token implements AnimationDrawEntity {

    /**
     * Default constructor
     */
    public Token(Vector2D v){
        Random rnd = new Random();
        int n = rnd.nextInt(25) + 1;
        count = n;


        int x = rnd.nextInt(((int) v.x )-40)+20;
        int y = rnd.nextInt(((int) v.y )-140)+120;


        Vector2D pos = new Vector2D();
        pos.x = x;
        pos.y = y;
        position = pos;
    }


    public int count;
    public Vector2D position;
    public Color color;


    /**
     * @param g2d
     */
    public void draw(Graphics2D g2d) {
        g2d.setPaint(color);

        float thickness = 4;
        g2d.setStroke(new BasicStroke(thickness));

        g2d.drawOval((int) position.x, (int) position.y, 16,16);
        FontMetrics metrics = g2d.getFontMetrics();
        g2d.drawString( Integer.toString(count)  , (int) position.x  + (16 - metrics.stringWidth(Integer.toString(count))) /2 , (int) position.y - 2);
    }

}