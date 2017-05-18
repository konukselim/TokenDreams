
import java.awt.*;
import java.util.*;

/**
 * 
 */
public abstract class StudentDecorator extends Student {

    protected Student student;

    /**
     * Default constructor
     */
    public StudentDecorator(Student student) {
        name = student.name;
        speed = student.speed;
        position = student.position;
        courses = student.courses;
        setState(student.getState());
        tokenedCourses = student.tokenedCourses;
        this.student = student;
    }

    /**
     * @param g2d
     */
    public abstract void draw(Graphics2D g2d);

    public Student getStudent(){
        return this.student;
    }


}