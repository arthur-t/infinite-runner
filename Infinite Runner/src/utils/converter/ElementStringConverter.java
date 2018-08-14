/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.converter;

import javafx.util.StringConverter;
import modele.game.Element;
import modele.game.GraphicalElement;
import modele.game.NamedImage;

/**
 *
 * @author Arthur
 */
public class ElementStringConverter extends StringConverter<Element> {

    @Override
    public String toString(Element object) {
        String returned =  object.getImage() instanceof NamedImage 
        ? ((NamedImage) object.getImage()).getName() 
        : null;
        return returned;
    }

    @Override
    public Element fromString(String string) {
        StringBuilder sb = new StringBuilder();
        return new GraphicalElement(0,0,new NamedImage(sb.append("/ressources/images/").append(string).append(".png").toString()));
    }
    
}
