package modele.game;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;


public class Character extends Entitie{
    
    protected final IntegerProperty health = new SimpleIntegerProperty();
        public int getHealth() {return health.get();}
        public void setHealth(int value) { health.set(value);}
        public IntegerProperty healthProperty() {return health;}

    
    public Character(int X, int Y, Image Img, int Health) {
        super(X,Y,Img);
        setHealth(Health);
    }
    
    
    
    
          
}
