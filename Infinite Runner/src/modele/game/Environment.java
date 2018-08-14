
package modele.game;

import exceptions.InvalidPosException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Environment {

    protected Level level;
    protected List<Element> listElements = new ArrayList<>();
    
    protected final IntegerProperty score = new SimpleIntegerProperty();
        public int getScore() {return score.get();}
        protected void setScore(int value) {score.set(value);}
        public IntegerProperty scoreProperty() {return score; }
    
    protected final IntegerProperty health = new SimpleIntegerProperty();
        public int getHealth() {return health.get();}
        public void setHealth(int value) { health.set(value);}
        public IntegerProperty healthProperty() {return health;}
    
    
    
    
     public Environment(Level Level){
        level=Level;
    }

    public Level getLevel() {
        return level;
    }

    public List<Element> getListElements() {
        return listElements;
    }
    
     public void setLevel(Level level) {
        this.level = level;
    }


    public void setListElements(List<Element> listElements) {
        this.listElements = listElements;
    }
    
    public void addElement(Element e){
        listElements.add(e);
    }
    
    public void removeElement(Element e){
        listElements.remove(e);
    }
   
    
    public void updateEnv(List<String> controles) throws InvalidPosException{
        
    }
    
}
