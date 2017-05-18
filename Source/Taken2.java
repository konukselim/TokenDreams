
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 
 */
public class Taken2 extends StudentDecorator {

    public Color color;

    public Taken2(Student student) {
        super(student);
        this.color = student.courses.get(1).color;

    }

    /**
     * @param g2d
     */
    public void draw(Graphics2D g2d) {
        position = student.position;
        courses = student.courses;
        tokenedCourses = student.tokenedCourses;
        student.draw(g2d);
        g2d.setPaint(color);
        g2d.fillRect((int) position.x + 30 , (int) position.y + 25, 10 ,10);
    }

    @Override
    public void act( Data data) {
        student.act( data);
    }

}