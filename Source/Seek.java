
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Seek extends State {

    /**
     * Default constructor
     */
    public Seek() {
    }


    public void act(Student student, Data data) {
        student.setState(this);

        Token aimedToken = findNearestToken(student, data);
        Vector2D normals = normalize(student, aimedToken.position);

        student.position.x += normals.x * student.speed;
        student.position.y += normals.y * student.speed;

        /*System.out.println(aimedToken.position);
        System.out.println(student.position.x + " , " + student.position.y);
        System.out.println(this);*/

        if( aimedToken.position.x - 18.0 < student.position.x &&  student.position.x < aimedToken.position.x){
            if( aimedToken.position.y - 18.0 < student.position.y &&  student.position.y < aimedToken.position.y){

                synchronized (data){
                    data.tokens.remove(aimedToken);
                    data.addToken();
                }

                Random r = new Random();
                int rnd = r.nextInt(data.courses.size());
                while (student.courses.contains(data.courses.get(rnd))){
                    rnd = r.nextInt(data.courses.size());
                }

                student.setState(new Deposit(aimedToken, data.courses.get(rnd)));
            }
        }

        int goRest = new Random().nextInt(100);
        if(goRest == 50){
            student.setState(new Rest(student.getState()));
        }

    }

    public void draw(Graphics2D g2d, Student student){
        FontMetrics metrics = g2d.getFontMetrics();

        g2d.setPaint(Color.GRAY);
        g2d.drawString("Seek", (int) student.position.x + (45 - metrics.stringWidth("Seek")) /2, (int) student.position.y+20);
        g2d.setPaint(Color.GREEN);
        g2d.drawString("None", (int) student.position.x + (45 - metrics.stringWidth("Seek")) /2, (int) student.position.y+58);
    }

    @Override
    public String toString(){
        return "Seek";
    }

}