
import java.util.*;

/**
 * 
 */
public class RegularFactory extends TokenFactory {

    /**
     * Default constructor
     */
    public RegularFactory() {
        super();
    }

    /**
     * @return
     */
    public Token createToken(Vector2D v) {
        Token regular = new Regular(v);
        return regular;
    }

}