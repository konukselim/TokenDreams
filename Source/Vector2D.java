
import java.util.*;

/**
 * 
 */
public class Vector2D {

    public Vector2D() {
    }

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double x;
    public double y;



    @Override
    public String toString(){
        return "Coordinates: X - " + x + "  Y - " + y;
    }

}