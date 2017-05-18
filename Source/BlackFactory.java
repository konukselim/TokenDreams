
import java.util.*;

/**
 * 
 */
public class BlackFactory extends TokenFactory {

    /**
     * Default constructor
     */
    public BlackFactory() {
        super();
    }

    /**
     * @return
     */
    public Token createToken(Vector2D v) {
        Token black = new Black(v);
        return black;
    }

}