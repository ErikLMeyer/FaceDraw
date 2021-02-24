import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class FaceFrame extends JFrame implements ActionListener{
    // Constant. Determines maximum and minimum number of faces in initial generation.
    static final int MAX_FACES = 10, MIN_FACES = 3;

    // Member variable. Stores the number of Face objects.
    private int numOfFaces;

    // Member variables for frame components.
    private JMenuBar myMenuBar;
    private JMenu addF, removeF;
    private JMenuItem addFa, removeFa;
    private FacePanel myFaces;
    private Container containFace;

    // Returns the number of Face objects
    public int getNumOFaces(){ return numOfFaces; }

    // Randomizes the number of faces to be generated
    public void setNumOFaces(){
        numOfFaces = (int)(Math.random() * (MAX_FACES - MIN_FACES + 1)) + MIN_FACES;
    }

    // Default constructor
    FaceFrame(){
        // Defines Frame
        setTitle("Face Draw");
        setBounds(200, 100, 1150, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Defines menu
        myMenuBar = new JMenuBar();
        addF = new JMenu("Add Face");
        removeF = new JMenu("Remove Face");
        addFa = new JMenuItem("Add");
        removeFa = new JMenuItem("Remove");
        addFa.addActionListener(this);
        removeFa.addActionListener(this);
        addF.add(addFa);
        removeF.add(removeFa);
        myMenuBar.add(addF);
        myMenuBar.add(removeF);

        // Defines Faces
        setNumOFaces();
        myFaces = new FacePanel(numOfFaces, getHeight(), getWidth());

        containFace = getContentPane();

        containFace.add(myMenuBar);
        containFace.add(myFaces);

        setJMenuBar(myMenuBar);

        printFaces();
    }

    // Implementation of actionPerformed. Method for adding and removing Faces
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == addFa){
            myFaces.addFace();
            update(this.getGraphics());
        }
        if (e.getSource() == removeFa){
            myFaces.removeFace();
            update(this.getGraphics());
        }
        printFaces();
    }

    // Prints out details of every Face
    public void printFaces(){
        for (int i = 0; i < numOfFaces; i++)
            System.out.println("Face " + (i + 1) + ":\n" + myFaces.getFace(i));
    }
}
