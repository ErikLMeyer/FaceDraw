import javax.swing.JFrame;
import java.awt.Container;
import java.lang.Math;

public class FaceFrame extends JFrame{
    static final int MAX_FACES = 10, MIN_FACES = 3;
    private int numOfFaces;

    public int getNumOFaces(){ return numOfFaces; }

    public void setNumOFaces(){
        numOfFaces = (int)(Math.random() * (MAX_FACES - MIN_FACES + 1)) + MIN_FACES;
    }

    FaceFrame(){
        setTitle("Face Draw");
        setBounds(250, 150, 1150, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setNumOFaces();
        FacePanel myFaces = new FacePanel(numOfFaces, getHeight(), getWidth(), getX(), getY());

        Container containFace = getContentPane();

        containFace.add(myFaces);
    }
}
