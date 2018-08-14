
package modele.game;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;


public class Level {

    private final ObjectProperty<Element> theme = new SimpleObjectProperty<>();
        public Element getTheme() {return theme.get();}
        public void setTheme(Element value) {theme.set(value);}
        public ObjectProperty themeProperty() {return theme;}
    
    private final IntegerProperty width = new SimpleIntegerProperty();
        public int getWidth() {return width.get();}
        public void setWidth(int value) {width.set(value);}
        public IntegerProperty widthProperty() {return width;}
    
    private final IntegerProperty height = new SimpleIntegerProperty();
        public int getHeight() {return height.get();}
        public void setHeight(int value) { height.set(value);}
        public IntegerProperty heightProperty() {return height;}

    private final IntegerProperty densiteElements = new SimpleIntegerProperty();
        public int getDensiteElements() {return densiteElements.get();}
        public void setDensiteElements(int value) {densiteElements.set(value);}
        public IntegerProperty densiteElementsProperty() {return densiteElements;}
    
    private final StringProperty name = new SimpleStringProperty();
        public String getNom() {return name.get();}
        public void setNom(String value) { name.set(value);}
        public StringProperty nameProperty() { return name;}
        
        
        
    
    public Level(String Name, int DensiteElements, Image Img, int Width, int Height){
        name.set(Name);
        densiteElements.set(DensiteElements);
        width.set(Width);
        height.set(Height);
        theme.set(new GraphicalElement(0,0,Img));
    }
    
    
    
}
