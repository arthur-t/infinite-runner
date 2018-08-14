/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modele.game.Element;
import modele.game.Obstacle;
import modele.game.Character;

/**
 *
 * @author Arthur
 */
public class Filter {
    
    public static ArrayList<Obstacle> obstacleFilter(List<Element> entities){
        return entities.stream()
                .filter(p -> p instanceof Obstacle)//Filtre les entitées qui sont des obstacles
                .map(p -> (Obstacle) p)//Downcast les entitées afin de renvoyer une liste d'obstale
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public static ArrayList<Character> personnageFilter(List<Element> entities){
        return entities.stream()
                .filter(p -> p instanceof Character)//Filtre les entitées qui sont des obstacles
                .map(p -> (Character) p)//Downcast les entitées afin de renvoyer une liste d'obstale
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
}
