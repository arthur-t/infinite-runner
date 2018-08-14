/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import modele.game.Element;
import modele.game.Displayable;

/**
 *
 * @author artronche
 */
public class Displayer {
    
    
    
    public void displayMultiple(List<Element> listeElement,GraphicsContext gameArea){
        for(Displayable e : listeElement){
            displaySingle(e,gameArea);
        }
    }
    
    public void displaySingle(Displayable e,GraphicsContext gameArea){
        e.display(gameArea);
    }
}
