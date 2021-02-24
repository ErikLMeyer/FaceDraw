import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class FaceFrame extends JFrame implements ActionListener{
    static final int MAX_FACES = 10, MIN_FACES = 3;
    private int numOfFaces;
    private JMenuBar myMenuBar;
    private JMenu addF, removeF;
    private JMenuItem addFa, removeFa;
    private FacePanel myFaces;
    private Container containFace;

    public int getNumOFaces(){ return numOfFaces; }

    public void setNumOFaces(){
        numOfFaces = (int)(Math.random() * (MAX_FACES - MIN_FACES + 1)) + MIN_FACES;
    }

    FaceFrame(){
        setTitle("Face Draw");
        setBounds(200, 100, 1150, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        setNumOFaces();
        myFaces = new FacePanel(numOfFaces, getHeight(), getWidth());

        containFace = getContentPane();

        containFace.add(myMenuBar);
        containFace.add(myFaces);

        setJMenuBar(myMenuBar);

        printFaces();
    }

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

    public void printFaces(){
        for (int i = 0; i < numOfFaces; i++)
            System.out.println("Face " + (i + 1) + ":\n" + myFaces.getFace(i));
    }
}
