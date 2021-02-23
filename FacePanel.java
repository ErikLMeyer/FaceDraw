import javax.swing.JPanel;
import java.lang.Math;
import java.awt.Graphics;
import java.util.ArrayList;

public class FacePanel extends JPanel{
    static final int FACE_HEIGHT_MIN = 25, FACE_WIDTH_MIN = 25;
    static final int FACE_X_MIN = 0, FACE_Y_MIN = 1;
    private int faceHeightMax;
    private int faceWidthMax;
    private int faceXMax, faceYMax;
    private ArrayList<Face> faces = new ArrayList<Face>();

    public int getMaxHeight(){ return faceHeightMax; }

    public int getMaxWidth(){ return faceWidthMax; }

    public int getMaxX(){ return faceXMax; }

    public int getMaxY(){ return faceYMax; }

    public void setMaxDimensions(int frameHeight, int frameWidth){
        faceHeightMax = (frameHeight < 700) ? frameHeight / 2 : 350;
        faceWidthMax = (frameWidth < 1150) ? frameWidth / 3 : 350;
    }
    public void setMaxPosition(int frameWidth, int frameHeight, int faceWidth, int faceHeight){
        faceXMax = frameWidth - faceWidth - 20;
        faceYMax = frameHeight - faceHeight - 40;
    }

    // Adds a randomly generated Face
    public void addFace(){
        int width, height, x, y;
            width = (int)(Math.random() * (faceWidthMax - FACE_WIDTH_MIN + 1)) + FACE_WIDTH_MIN;
            height = (int)(Math.random() * (faceHeightMax - FACE_HEIGHT_MIN + 1)) + FACE_HEIGHT_MIN;
            while ((double)(width / height) <= .2 || (double)(width / height) >= 5){
                if (width > height)
                    height += 10;
                else
                    width += 10;
            }

            x = (int)(Math.random() * (faceXMax + 1));
            y = (int)(Math.random() * (faceYMax - FACE_Y_MIN + 1)) + FACE_Y_MIN;
            faces.add(new Face(x, y, width, height));
    }

    // Adds a new Face with given values
    public void addFace(int x, int y, int width, int height){
        faces.add(new Face(x, y, width, height));
    }

    // Removes the last Face in the list
    public void removeFace(){
        if (faces.size() > 0)
            faces.remove(faces.size() - 1);
        else
            System.out.println("List is already empty!");
    }

    FacePanel(){
        faces.add(new Face());
    }

    // Creates a new FacePanel with a single Face
    FacePanel(int x, int y, int width, int height){
        faces.add(new Face(x, y, width, height));
    }

    FacePanel(int numOfFaces, int frameHeight, int frameWidth){
        setMaxDimensions(frameHeight, frameWidth);

        int width, height, x, y;
        for (int i = 0; i < numOfFaces; i++){
            width = (int)(Math.random() * (faceWidthMax - FACE_WIDTH_MIN + 1)) + FACE_WIDTH_MIN;
            height = (int)(Math.random() * (faceHeightMax - FACE_HEIGHT_MIN + 1)) + FACE_HEIGHT_MIN;
            while ((double)(width / height) <= .2 || (double)(width / height) >= 5){
                if (width > height)
                    height += 10;
                else
                    width += 10;
            }

            setMaxPosition(frameWidth, frameHeight, width, height);
            x = (int)(Math.random() * (faceXMax + 1));
            y = (int)(Math.random() * (faceYMax - FACE_Y_MIN + 1)) + FACE_Y_MIN;
            faces.add(new Face(x, y, width, height));
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int i = 0; i < faces.size(); i++){
            faces.get(i).paintComponent(g);
        }
    }
}
