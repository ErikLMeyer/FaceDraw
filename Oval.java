import java.awt.Graphics;

public class Oval {
    private int widthRadius, heightRadius;
    private int xPosition, yPosition;

    public void setWidth(int w){ widthRadius = w; }

    public void setHeight(int h){ heightRadius = h; }

    public void setX(int x){ xPosition = x; }

    public void setY(int y){ yPosition = y; }

    public int getWidth(){ return widthRadius; }

    public int getHeight(){ return heightRadius; }

    public int getX(){ return xPosition; }

    public int getY(){ return yPosition; }

    Oval(){
        this(0,0,0,0);
    }

    Oval(int width, int height, int x, int y){
        setWidth(width);
        setHeight(height);
        setX(x);
        setY(y);
    }

    public void paintComponent(Graphics g){
        g.drawOval(xPosition, yPosition, widthRadius, heightRadius);
    }

    public String toString(){
        return "X = " + xPosition + ", Y = " + yPosition + ", width = " + widthRadius + ", height = " + 
            heightRadius;
    }
}
