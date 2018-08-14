package modele.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public abstract class Entitie extends Element{
    
    protected Hitbox hitbox;

    public Entitie(int X,int Y, Image Img) {
        super(X,Y,Img);
        
        setHitbox(Img);
    }

    
    public Hitbox getHitbox() {
        return hitbox;
    }
    
    private void setHitbox(Image img){
        hitbox = new Hitbox(x,y,img.getWidth(),img.getHeight(),img.getWidth()-12,img.getHeight()-12);
    }
    
    public void setHitboxWidth(int width) {
        this.hitbox.setPhysicalWidth(width);
    }
    
    public void setHitboxHeight(int height) {
        this.hitbox.setPhysicalHeight(height);
    }

    
    @Override
    public void setX(Integer x){
        this.x=x;
        hitbox.setXPos(x);
    }
    
    @Override
    public void setY(Integer y){
        this.y=y;
        hitbox.setYPos(y);
    }

    @Override
    public void display(GraphicsContext gameArea) {
        gameArea.drawImage(img, x, y);
    }

    
    
   
}
