/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.game;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Arthur
 */
public class ThemeList {
    private ObservableList<Element> themesObs = FXCollections.observableArrayList();
    
    private final ListProperty<Element> themes = new SimpleListProperty<>(themesObs);
        public ObservableList getThemes() { return themes.get();}
        public void setThemes(ObservableList value) { themes.set(value);}
        public ListProperty themesProperty() { return themes;}
    
    public ThemeList(){
        themesObs.add(new GraphicalElement(0,0,new NamedImage("/ressources/images/space.png")));
        themesObs.add(new GraphicalElement(0,0,new NamedImage("/ressources/images/cavern.png")));
        themesObs.add(new GraphicalElement(0,0,new NamedImage("/ressources/images/city.png")));
    }
    
}
