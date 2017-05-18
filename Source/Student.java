
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 
 */
public abstract class Student implements AnimationDrawEntity, AnimationActEntity {

    public Student(){

    }

    public Student(String name, int speed, Vector2D position){
        this.name = name;
        this.speed = speed;
        this.position = position;
        this.courses = new ArrayList<Course>();
        this.state = new Seek();
        tokenedCourses = new HashMap<Course, Integer>();

    }

    public State getState(){
        return state;
    }
    public void setState(State s){
        this.state = s;
    }


    public String name;
    public Vector2D position;
    public int speed;
    public List<Course> courses;
    private State state;
    public Map<Course, Integer> tokenedCourses;



    /**
     * @param g2d
     */
    public abstract void draw(Graphics2D g2d);

    public void act(Data data){
        getState().act( this , data);
    }


}