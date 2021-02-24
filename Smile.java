import java.awt.Graphics;

public class Smile {
    private int xPosition, yPosition;
    private int width, height;
    private int startAngle, arcAngle;

    public int getX(){ return xPosition; }

    public int getY(){ return yPosition; }

    public int getWidth(){ return width; }

    public int getHeight(){ return height; }

    public int getStart(){ return startAngle; }

    public int getArc(){ return arcAngle; }

    public void setX(int x){ xPosition = x; }

    public void setY(int y){ yPosition = y; }

    public void setWidth(int w){ width = w; }

    public void setHeight(int h){ height = h; }

    public void setStart(int s){ startAngle = s; }

    public void setArc(int a){ arcAngle = a; }

    Smile(){
        this(0,0,0,0,0,0);
    }

    Smile(int x, int y, int w, int h, int s, int a){
        setX(x);
        setY(y);
        setWidth(w);
        setHeight(h);
        setStart(s);
        setArc(a);
    }

    public void paintComponent(Graphics g){
        g.drawArc(xPosition, yPosition, width, height, startAngle, arcAngle);
    }

    public String toString(){
        return "X = " + xPosition + ", Y = " + yPosition + ", width = " + width + ", height = " + 
            height + ", start angle = " + startAngle + ", arc angle = " + arcAngle;
    }
}
