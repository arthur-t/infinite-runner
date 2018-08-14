package modele.game;

import javafx.scene.image.Image;

public class GraphicalElement extends Element{
    
    public GraphicalElement(int X,int Y, Image Img){
        super(X,Y,Img);
    }

    @Override
    public boolean equals(Object o) {
        if (o==null) return false;
        if(o==this)return true;
        if(!(o instanceof GraphicalElement))return false;
        GraphicalElement e = (GraphicalElement) o;
        String thisImageName =  (this.getImage() instanceof NamedImage 
        ? ((NamedImage) this.getImage()).getName() 
        : null);
        String comparedImageName = (e.getImage() instanceof NamedImage 
        ? ((NamedImage) e.getImage()).getName() 
        : null);
        
        return thisImageName.equals(comparedImageName);
       
    }
    
    
}
