package modele.game;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Element implements Displayable{

    protected Integer x;
    protected Integer y;
    protected Image img;
    protected Integer width;
    protected Integer height;
    
    
    public Element(int X,int Y, Image Img) {
        x=X;
        y=Y;
        img=Img;
        
        
        width=(int) Math.round(img.getWidth());
        height=(int) Math.round(img.getHeight());
    }
    
    public Image getImage(){
        return img;
    }
    
    public Integer getWidth(){
        return width;
    }
    public Integer getHeight(){
        return height;
    }
    
    public void setWidth(Integer newWidth){
        width=newWidth;
    }
    public void setHeight(Integer newHeight){
        height=newHeight;
    }
    
    public Integer getX(){
        return this.x;
    }
    
    public void setX(Integer x){
        this.x=x;
    }
    
    public Integer getY(){
        return this.y;
    }
    
    public void setY(Integer y){
        this.y=y;
    }
    
    
    @Override
    public void display(GraphicsContext gameArea) {
        gameArea.drawImage(img, x, y);
    }

    
    
}
