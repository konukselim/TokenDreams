
import java.util.*;

/**
 * 
 */
public class FakeFactory extends TokenFactory {

    /**
     * Default constructor
     */
    public FakeFactory() {
    }


    public Token createToken(Vector2D v) {
        Token fake = new Fake(v);
        return fake;
    }


}