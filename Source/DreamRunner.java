
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class DreamRunner {

    /**
     * Default constructor
     */
    public DreamRunner() throws IOException {
        data = new Data(800 , 600);

        window = new JFrame();
        window.setTitle("OOP HW1");
        window.setBackground(Color.WHITE);
        window.setMinimumSize(new Dimension(800,600));
       // window.setMaximumSize(new Dimension(1000,1000));
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        display = new Display(data);
        window.add(display);


        //window.setVisible(true);
        window.pack();
        window.setVisible(true);

    }

    /**
     * 
     */
    public JFrame window;

    /**
     * 
     */
    public Display display;

    /**
     * 
     */
    public Data data;


    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO implement here
        DreamRunner d = new DreamRunner();

        ActionListener timerlistenerFairy = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.data.fairy.act(d.data);
            }
        };
        javax.swing.Timer mytimer = new javax.swing.Timer(3000, timerlistenerFairy);
        mytimer.start();

        while(true){

            for(Student s : d.data.students){
                s.act(d.data);
            }
            d.window.repaint();
            Thread.sleep(50);

            if(d.data.windowWidth != d.window.getWidth() || d.data.windowHeight != d.window.getHeight()){
                d.data.windowWidth = d.window.getWidth();
                d.data.windowHeight = d.window.getHeight();
                d.data.repositionCourses();
            }


            if(!d.data.finito){
                boolean tmp = false;
                for(Student s: d.data.students){
                    if(s instanceof Taken2 && ((Taken1)((Taken2) s).getStudent()).getStudent().position.y > d.data.windowHeight){
                        tmp = true;
                    }
                    else{
                        tmp = false;
                        break;
                    }

                }
                if(tmp){
                    d.data.finito = true;
                    d.data.tokens.clear();
                    break;
                }
            }

        }

        while(true){
            d.window.repaint();
            Thread.sleep(50);

            if(d.data.windowWidth != d.window.getWidth() || d.data.windowHeight != d.window.getHeight()){
                d.data.windowWidth = d.window.getWidth();
                d.data.windowHeight = d.window.getHeight();
                d.data.repositionCourses();
            }
        }

    }

}