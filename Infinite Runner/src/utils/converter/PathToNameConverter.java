/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.converter;

/**
 *
 * @author Arthur
 */
public class PathToNameConverter {
    
    public static String pathToName(String path){
 
        StringBuilder sc = new StringBuilder();
        String[] parts = path.split("(/)|(\\.)");//permet de récupérer le nom de l'image sans l'extension
        return parts[parts.length-2];
      
       
        
    }
}
