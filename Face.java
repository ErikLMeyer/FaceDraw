import javax.swing.JPanel;
import java.awt.*;

public class Face extends JPanel {
    static final int FROWN[] = {45, 90};
    static final int NEUTRAL[] = {0, 180};
    static final int SMILE[] = {-45, -90};

    private Oval head;
    private Oval eyes[] = new Oval[2];
    private Smile smile;

    Face(){
        this(0, 0, 0, 0);
    }

    Face(int x, int y, int width, int height){
        head.setX(x);
        head.setY(y);
        head.setWidth(width);
        head.setHeight(height);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);


    }
}
