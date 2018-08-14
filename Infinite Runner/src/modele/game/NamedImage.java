
package modele.game;

import javafx.scene.image.Image;
import utils.converter.PathToNameConverter;

/**
 * Permet d'associer un nom à une image
 */
public class NamedImage extends Image {
    private final String name;
    
    public NamedImage(String url) {
        super(url);
       name=PathToNameConverter.pathToName(url);
    }
    
    public String getName(){
        return name;
    }
    
}
