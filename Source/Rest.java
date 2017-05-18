
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * 
 */
public class Rest extends State {

    /**
     * Default constructor
     */
    int duration;
    int amount;
    State lastState;


    public Rest(State lastState) {
        duration = new Random().nextInt(5)+1;
        duration *= 5;
        this.lastState = lastState;
    }
    public Rest(State lastState , int amount) {
        duration = new Random().nextInt(5)+1;
        duration *= 5;
        this.lastState = lastState;
        this.amount = amount;
    }


    public void act(Student student, Data data) {

        if(duration == 0)
            student.setState(lastState);
        else
            duration -= 1;

    }

    public void draw(Graphics2D g2d, Student student){
        FontMetrics metrics = g2d.getFontMetrics();

        g2d.setPaint(Color.GRAY);
        g2d.drawString("Rest", (int) student.position.x + (45 - metrics.stringWidth("Rest")) /2, (int) student.position.y+20);
        g2d.setPaint(Color.GREEN);
        if(lastState instanceof Seek || lastState instanceof Leave){
            g2d.drawString("None", (int) student.position.x + (45 - metrics.stringWidth("Seek")) /2, (int) student.position.y+58);
        }
        else{
            g2d.drawString(Integer.toString(amount), (int) student.position.x + (45 - metrics.stringWidth(Integer.toString(amount))) /2, (int) student.position.y+58);
        }
    }

    @Override
    public String toString(){
        return "Rest";
    }

}