
import java.util.*;

/**
 * 
 */
public abstract class TokenFactory {

    /**
     * Default constructor
     */

    public TokenFactory() {

    }

    /**
     * @return
     */
    public abstract Token createToken(Vector2D v);

}