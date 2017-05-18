
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Deposit extends State {

    /**
     * Default constructor
     */
    public Deposit() {

    }
    public Deposit(Token grabbed, Course aimedCourse) {
        this.grabbed = grabbed;
        this.aimedCourse = aimedCourse;
    }

    int amount = 0;
    Token grabbed;
    Course aimedCourse;

    public void act(Student student, Data data) {

        Vector2D normals = normalize(student , aimedCourse.position);

        student.position.x += normals.x * student.speed;
        student.position.y += normals.y * student.speed;

        if( aimedCourse.position.x - 18.0 < student.position.x &&  student.position.x < aimedCourse.position.x){
            if( aimedCourse.position.y - 18.0 < student.position.y &&  student.position.y < aimedCourse.position.y){

                if(!student.tokenedCourses.containsKey(aimedCourse)){
                    student.tokenedCourses.put(aimedCourse , amount);
                }
                else{
                    student.tokenedCourses.replace(aimedCourse, student.tokenedCourses.get(aimedCourse) + amount);
                }

                if(student.tokenedCourses.get(aimedCourse) >= aimedCourse.minTokens){

                    data.increaseCourseStudent(aimedCourse);
                    student.courses.add(aimedCourse);
                    data.checkDecoration(student);
                }

                if(student.courses.size() == 2){
                    student.setState(new Leave());
                }
                else{
                    student.setState(new Seek());
                }
            }
        }

        int goRest = new Random().nextInt(100);
        if(goRest == 50){
            student.setState(new Rest(student.getState(), amount));
        }
    }

    public void draw(Graphics2D g2d, Student student){

        int tokenAmount = 0;

        if(grabbed.color == Color.GREEN){
            tokenAmount = grabbed.count;
        }
        else if(grabbed.color == Color.BLACK){
            tokenAmount = grabbed.count/2;
        }
        else{ // BLUE
            tokenAmount = 1;
        }
        this.amount = tokenAmount;

        FontMetrics metrics = g2d.getFontMetrics();

        g2d.setPaint(aimedCourse.color);
        g2d.drawString("Deposit", (int) student.position.x + (45 - metrics.stringWidth("Deposit")) /2, (int) student.position.y+20);
        g2d.setPaint(Color.GREEN);
        g2d.drawString( Integer.toString(tokenAmount) , (int) student.position.x + (45 - metrics.stringWidth(Integer.toString(tokenAmount) )) /2, (int) student.position.y+58);
    }

    @Override
    public String toString(){
        return "Deposit";
    }

}