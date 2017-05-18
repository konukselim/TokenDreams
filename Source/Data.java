
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.Timer;

/**
 * 
 */
public class Data {

    public int windowWidth;
    public int windowHeight;
    public TokenFairy fairy;
    public List<Token> tokens;
    public List<Course> courses;
    public List<Student> students;
    public boolean finito;

    /**
     * Default constructor
     */
    public Data(int width, int height) throws IOException {
        windowWidth = width;
        windowHeight = height;
        Vector2D v = new Vector2D();
        v.x = windowWidth;
        v.y = windowHeight;

        Random randomGenerator = new Random();

        int w_low = 0;
        int w_high = windowWidth - 40;

        int h_low = 100;
        int h_high = windowHeight - 40;


        fairy = new TokenFairy(new Vector2D(randomGenerator.nextInt(w_high - w_low) + w_low , randomGenerator.nextInt(h_high - h_low) + h_low));
        tokens = new ArrayList<Token>();
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();

        for(int i= 0; i<25 ;i++){
            tokens.add(fairy.createToken(v));
        }

        addCourse("CENG 443" , Color.RED , 80);
        addCourse("CENG 451" , Color.YELLOW , 20);
        addCourse("CENG 462" , Color.GREEN , 10);
        addCourse("CENG 476" , Color.ORANGE , 10);
        addCourse("CENG 478" , Color.CYAN , 10);
        addCourse("CENG 495" , Color.BLUE , 33);
        addCourse("CENG 497" , Color.MAGENTA , 10);
        addCourse("CENG 499" , Color.PINK , 55);

        addStudent("Abdulkadir");
        addStudent("Abdullatif");
        addStudent("Afsin Bugra");
        addStudent("Ahmet Alperen");
        addStudent("Ahmet Selim");
        addStudent("Alihan");
        addStudent("Alperen");
        addStudent("Andi");
        addStudent("Ata");
        addStudent("Aybars Kerem");
        addStudent("Baris");
        addStudent("Baris Caglar");
        addStudent("Batyr");
        addStudent("Berker");
        addStudent("Bugrahan");
        addStudent("Burak");
        addStudent("Canturk");
        addStudent("Doguhan");
        addStudent("Dogukan");
        addStudent("Ebru Ipek");
        addStudent("Efecan");
        addStudent("Enver");
        addStudent("Erbil");
        addStudent("Erinc");
        addStudent("Ermek");
        addStudent("Ertug");
        addStudent("Furkan");
        addStudent("Gokhan");
        addStudent("Halim Gorkem");
        addStudent("Hasan Ali");
        addStudent("Ilke");
        addStudent("Izzet Baris");
        addStudent("Kadir Berkay");
        addStudent("Kadir Cenk");
        addStudent("Mehmet");
        addStudent("Mehmet Ali");
        addStudent("Mehmet Can");
        addStudent("Mehmet Sait");
        addStudent("Melisa Idil");
        addStudent("Mert");
        addStudent("Mert");
        addStudent("Mert");
        addStudent("Merve");
        addStudent("Metehan");
        addStudent("Muhammet");
        addStudent("Oguz");
        addStudent("Okan");
        addStudent("Onat");
        addStudent("Onur");
        addStudent("Onur Ozan");
        addStudent("Ozgu");
        addStudent("Pinar");
        addStudent("Recep Firat");
        addStudent("Recep Gun");
        addStudent("Sait Burak");
        addStudent("Sercan");
        addStudent("Sercan");
        addStudent("Sinan");
        addStudent("Sukru");
        addStudent("Tolga");
        addStudent("Tolgahan");
        addStudent("Tugca Alara");
        addStudent("Ugur");
        addStudent("Ugurcan");
        addStudent("Yasin Berk");
        addStudent("Yigit");

        this.finito = false;

    }

    public void addCourse(String coursename , Color courseColor , int minToken){
        int numofCourses = courses.size() + 1;
        int pos = 0;
        int wide = windowWidth / numofCourses;
        int height = 80;

        for(int i=0; i<numofCourses-1 ;i++){
            courses.get(i).position = new Vector2D(pos+wide/2 , height);
            courses.get(i).width = wide;
            pos += wide;
        }
        courses.add(new Course(coursename, courseColor, minToken , new Vector2D(pos+ wide/2 , height) , wide));

    }

    public void addStudent(String name){
        // Speed between 4 and 8
        Random randomGenerator = new Random();

        int s_low = 4;
        int s_high = 9;

        int w_low = 0;
        int w_high = windowWidth - 40;

        int h_low = 100;
        int h_high = windowHeight - 40;

        students.add(new BasicStudent( name , randomGenerator.nextInt(s_high - s_low) + s_low ,
                new Vector2D(randomGenerator.nextInt(w_high - w_low) + w_low , randomGenerator.nextInt(h_high - h_low) + h_low) ));

    }

    public void repositionCourses(){
        int numOfCourses = courses.size();
        int pos = 0;
        int wide = windowWidth / numOfCourses;

        for(int i=0; i<numOfCourses ;i++){
            courses.get(i).position = new Vector2D(pos+wide/2 , 80);
            courses.get(i).width = wide;
            pos += wide;
        }
    }

    public void addToken(){
        tokens.add(fairy.createToken(new Vector2D(this.windowWidth, this.windowHeight)));
    }

    public void checkDecoration(Student s){


        for(int i=0; i< students.size() ;i++){

            if(students.get(i) instanceof BasicStudent && students.get(i).courses.size() == 1){
                students.set(i , new Taken1(students.get(i)));
            }
            else if(students.get(i) instanceof Taken1 && students.get(i).courses.size() == 2){
                students.set(i , new Taken2(students.get(i)));
            }

        }
    }

    public void increaseCourseStudent(Course c){
        courses.get(courses.indexOf(c)).studentNumber +=1;
    }

}