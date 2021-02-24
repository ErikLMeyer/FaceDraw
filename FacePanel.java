import javax.swing.JPanel;
import java.lang.Math;
import java.awt.Graphics;
import java.util.ArrayList;

public class FacePanel extends JPanel{
    // Constants. Defines minimum size and position of a Face.
    static final int FACE_HEIGHT_MIN = 25, FACE_WIDTH_MIN = 25;
    static final int FACE_X_MIN = 0, FACE_Y_MIN = 1;

    // Member variables. Determines maximum size and position of a Face.
    private int faceHeightMax;
    private int faceWidthMax;
    private int faceXMax, faceYMax;

    // The ArrayList of every Face
    private ArrayList<Face> faces = new ArrayList<Face>();

    // Returns the maximum height a new Face can be
    public int getMaxHeight(){ return faceHeightMax; }

    // Returns the maximum width a new Face can be
    public int getMaxWidth(){ return faceWidthMax; }

    // Returns the maximum X coordinate a new Face can be placed
    public int getMaxX(){ return faceXMax; }

    // Returns the maximum Y coordinate a new Face can be placed
    public int getMaxY(){ return faceYMax; }

    // Returns a Face object from ArrayList faces. i must be a valid index in faces.
    public Face getFace(int i){
        assert (i >= 0 && i < faces.size()): "Invalid index";
        return faces.get(i);
    }

    // Sets faceHeightMax and faceWidthMax, the maximum dimensions a new Face can be.
    // frameHeight and frameWidth shoudl be the current or desired height and width of the current 
    // frame.
    public void setMaxDimensions(int frameHeight, int frameWidth){
        faceHeightMax = (frameHeight < 700) ? frameHeight / 2 : 350;
        faceWidthMax = (frameWidth < 1150) ? frameWidth / 3 : 350;
    }
    public void setMaxPosition(int frameWidth, int frameHeight, int faceWidth, int faceHeight){
        faceXMax = frameWidth - faceWidth - 20;
        faceYMax = frameHeight - faceHeight - 40;
    }

    // Adds a randomly generated Face. Position will be dependent on last call to setMaxPosition.
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

    // Default constructor
    FacePanel(){
        faces.add(new Face());
    }

    // Creates a new FacePanel with a single Face
    FacePanel(int x, int y, int width, int height){
        faces.add(new Face(x, y, width, height));
    }

    // Creates a new FacePanel with numOfFaces number of Face objects, with sizes and positions
    // dependent on the given frameWidth and frameHeight.
    FacePanel(int numOfFaces, int frameHeight, int frameWidth){
        setMaxDimensions(frameHeight, frameWidth);

        // Loops a number of times equal to numOfFaces, creating a new Face object each loop.
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

    // Paints the Face objects in faces
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int i = 0; i < faces.size(); i++){
            faces.get(i).paintComponent(g);
        }
    }

    // Returns a String describing the number of Face objects in the FacePanel.
    public String toString(){
        return "Number of Faces = " + faces.size();
    }
}
