import java.awt.*;
import java.lang.Math;

public class Face {
    // Constants, holds mouth angles
    static final int FROWN[] = {0, 180};
    static final int NEUTRAL[] = {0, 180};
    static final int SMILE[] = {0, -180};

    // member variables
    private Oval head;
    private Oval eyes[] = new Oval[2];
    private Smile smile;

    public int getHeight(){ return head.getHeight(); }

    public int getWidth(){ return head.getWidth(); }

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
        eyeY = y + (eyeH / 2);
        eyes[0] = new Oval(eyeW, eyeH, eyeX, eyeY);
        eyes[1] = new Oval(eyeW, eyeH, eyeX + (eyeW*2), eyeY);

        int mouthE = (int)(Math.random()*3);
        int mouthX = eyeX;
        int mouthY = y + (height / 2);
        int mouthW = eyeW * 3;
        int mouthH = height / 2;

        switch(mouthE){
            case 0:
                smile = new Smile(mouthX, mouthY, mouthW, mouthH, FROWN[0], FROWN[1]);
                break;
            case 1:
                smile = new Smile(mouthX, mouthY + (eyeH / 2), mouthW, 0, NEUTRAL[0], NEUTRAL[1]);
                break;
            case 2:
                smile = new Smile(mouthX, y + eyeH, mouthW, mouthH, SMILE[0], SMILE[1]);
                break;
            default:
                System.out.println("Learn how to random.");
                break;
        }
    }

    public void paintComponent(Graphics g){
        head.paintComponent(g);
        eyes[0].paintComponent(g);
        eyes[1].paintComponent(g);
        smile.paintComponent(g);
    }
}
