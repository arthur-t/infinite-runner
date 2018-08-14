
package modele.game;

import javafx.scene.shape.Rectangle;


public class Hitbox extends Rectangle{

    private int offSetX=0;
    private int offSetY=0;
    private final int imgWidth;
    private final int imgHeight;
    
    
    public Hitbox(int X, int Y, double ImgWidth, double ImgHeight, double PhysicalWidth, double PhysicalHeight){
        super();
        setX(X);
        setY(Y);
        imgWidth=(int)Math.round(ImgWidth);
        imgHeight=(int)Math.round(ImgHeight);
        setPhysicalWidth(PhysicalWidth);
        setPhysicalHeight(PhysicalHeight);
    }
    
    public int getOffSetX() {
        return offSetX;
    }

    public int getOffSetY() {
        return offSetY;
    }
    
    public void setXPos(int x){
        setX(x+offSetX);
    }
    
    public void setYPos(int y){
        setY(y+offSetY);
    }
    
    public void setPhysicalWidth(double width) {
        setWidth(width);
        this.offSetX = (int)Math.round((imgWidth-width)/2);
    }

    

    public void setPhysicalHeight(double height) {
        setHeight(height);
        this.offSetY = (int)Math.round((imgHeight-height)/2);
    }
    
    
}
