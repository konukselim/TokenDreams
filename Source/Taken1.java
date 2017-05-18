
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 
 */
public class Taken1 extends StudentDecorator {

    public Color color;



    public Taken1(Student student) {
        super(student);
        this.color = student.courses.get(0).color;

    }

    public void draw(Graphics2D g2d) {
        position = student.position;
        courses = student.courses;
        tokenedCourses = student.tokenedCourses;
        student.draw(g2d);
        g2d.setPaint(color);
        g2d.fillRect((int) position.x + 5 , (int) position.y + 25, 10 ,10);
    }

    @Override
    public void act( Data data) {
        student.act( data);
    }

}