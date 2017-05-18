
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Leave extends State {

    /**
     * Default constructor
     */
    public Leave() {
    }


    public void act(Student student, Data data) {
        student.position.y += student.speed;

        int goRest = new Random().nextInt(100);
        if(goRest == 50){
            student.setState(new Rest(student.getState()));
        }
    }

    public void draw(Graphics2D g2d, Student student){
        FontMetrics metrics = g2d.getFontMetrics();

        g2d.setPaint(Color.GRAY);
        g2d.drawString("Leave", (int) student.position.x + (45 - metrics.stringWidth("Leave")) /2, (int) student.position.y+20);
        g2d.setPaint(Color.GREEN);
        g2d.drawString("None", (int) student.position.x + (45 - metrics.stringWidth("Seek")) /2, (int) student.position.y+58);
    }

    @Override
    public String toString(){
        return "Leave";
    }

}