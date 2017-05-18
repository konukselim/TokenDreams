

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class TokenFairy implements AnimationDrawEntity, AnimationActEntity {

    /**
     * Default constructor
     */
    private ArrayList<TokenFactory> factories = new ArrayList<TokenFactory>();

    public TokenFairy(Vector2D position) throws IOException {

        this.position = position;
        this.image = new BufferedImage[2];
        this.image[0] = ImageIO.read(new File("Tinkerbell-LookingLeft.png"));
        this.image[1] = ImageIO.read(new File("Tinkerbell-LookingRight.png"));
        /*this.image[0] = ImageIO.read(TokenFairy.class.getClassLoader().getResourceAsStream("Tinkerbell-LookingLeft.png"));
        this.image[1] = ImageIO.read(TokenFairy.class.getClassLoader().getResourceAsStream("Tinkerbell-LookingRight.png"));*/
        this.imageIndice = 0;

        factories.add(new RegularFactory());
        factories.add(new FakeFactory());
        factories.add(new BlackFactory());
    }

    /**
     * 
     */
    public Vector2D position;
    public BufferedImage[] image;
    public int imageIndice;


    /**
     * @return
     */
    public Token createToken(Vector2D v) {
        Random rnd = new Random();
        int n = rnd.nextInt(3) + 0;
        Token t = factories.get(n).createToken(v);

        return t;
    }

    /**
     * @param g2d
     */
    public void draw(Graphics2D g2d) {

        g2d.drawImage(image[imageIndice], (int) position.x, (int) position.y , null);
    }

    public void act(Data data) {
        Random rand = new Random();
        imageIndice = rand.nextInt(2);
        position.x = rand.nextInt(data.windowWidth-40);
        position.y = rand.nextInt(data.windowHeight-140) + 100;
    }

}