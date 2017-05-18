
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * 
 */
public class Display extends JPanel{

    /**
     * Default constructor
     */
    public Display(Data data) {
        super();
        this.data = data;

    }

    /**
     * 
     */
    public Data data;

    /**
     * @return
     */
    public Dimension getPreferredSize() {
        return new Dimension(data.windowWidth, data.windowHeight);
    }

    /**
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        synchronized (data){

            for(Token t: data.tokens){
                t.draw(g2d);
            }
        }

        for(Course c: data.courses){
            c.draw(g2d);
        }

        for(Student s: data.students){
            s.draw(g2d);
        }

        data.fairy.draw(g2d);

        if(data.finito){
            FontMetrics metrics = g2d.getFontMetrics();

            for(Course c: data.courses){
                int height = 120;
                for(Student s: data.students){
                    Student basic = ((Taken1)((Taken2) s).getStudent()).getStudent();
                    if(basic.courses.contains(c)){
                        g2d.setColor(c.color);
                        g2d.drawString(basic.name + "(" + basic.tokenedCourses.get(c) + ")" , (int ) ((c.position.x - c.width/2) + (c.width - metrics.stringWidth(basic.name + "(" + basic.tokenedCourses.get(c) + ")")) /2) , height);
                        height += 20;
                    }
                }
            }
        }
    }

}