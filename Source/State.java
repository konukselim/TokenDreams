
import java.awt.*;
import java.util.*;

/**
 * 
 */
public abstract class State {

    /**
     * Default constructor
     */
    public State() {
    }


    public abstract void act(Student student, Data data);
    public abstract void draw(Graphics2D g2d, Student student);

    public double calculateDistance(Student student, Vector2D v){
        double pow1 = Math.pow(v.x+2 - student.position.x-16 , 2);
        double pow2= Math.pow(v.y+2 - student.position.y-16 , 2);
        return Math.sqrt(pow1+ pow2);
    }

    public Vector2D normalize(Student student, Vector2D v){
        double denom = calculateDistance(student, v);
        return new Vector2D((v.x+2 - student.position.x-16)/denom, (v.y+2 - student.position.y-16)/denom);
    }

    public Token findNearestToken(Student student, Data data){

        double leastDif = Double.POSITIVE_INFINITY;
        Token aimedToken = null;
        double tmp;

        for(Token t: data.tokens){
            if ((tmp = calculateDistance(student, t.position)) < leastDif ){
                leastDif = tmp;
                aimedToken = t;
            }
        }
        return aimedToken;
    }

}