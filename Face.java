import javax.swing.JPanel;
import java.awt.*;
import java.lang.Math;

public class Face extends JPanel {
    // Constants, holds mouth angles
    static final int FROWN[] = {45, 90};
    static final int NEUTRAL[] = {0, 180};
    static final int SMILE[] = {-45, -90};

    // member cariables
    private Oval head;
    private Oval eyes[] = new Oval[2];
    private Smile smile;

    // Default constructor
    Face(){
        this(0, 0, 0, 0);
    }

    // Constructor
    Face(int x, int y, int width, int height){
        head = new Oval(width, height, x, y);

        int eyeW, eyeH, eyeX, eyeY;
        eyeH = height / 3;
        eyeW = width / 5;
        eyeX = x + eyeW;
        eyeY = y + eyeH;
        eyes[0] = new Oval(eyeW, eyeH, eyeX, eyeY);
        eyes[1] = new Oval(eyeW, eyeH, eyeX + (eyeW*2), eyeY);

        int mouthE = (int)(Math.random()*3);
        int mouthX = eyeX + (eyeW / 2);
        int mouthY = y + (height / 2);
        int mouthW = eyeW * 2;
        int mouthH = height / 2;

        switch(mouthE){
            case 0:
                smile = new Smile(mouthX, mouthY, mouthW, mouthH, FROWN[0], FROWN[1]);
                break;
            case 1:
                smile = new Smile(mouthX, mouthY, mouthW, mouthH, NEUTRAL[0], NEUTRAL[1]);
                break;
            case 2:
                smile = new Smile(mouthX, mouthY, mouthW, mouthH, SMILE[0], SMILE[1]);
                break;
            default:
                System.out.println("Learn how to random.");
                break;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawOval(head.getX(), head.getY(), head.getWidth(), head.getHeight());
        g.drawOval(eyes[0].getX(), eyes[0].getY(), eyes[0].getWidth(), eyes[0].getHeight());
        g.drawOval(eyes[1].getX(), eyes[1].getY(), eyes[1].getWidth(), eyes[1].getHeight());
        g.drawArc(smile.getX(), smile.getY(), smile.getWidth(), smile.getHeight(), 
                                                smile.getStart(), smile.getArc());
    }
}
