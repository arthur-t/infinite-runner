/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launch;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author pipayrard
 */
public class Main extends Application {
    private static Stage monStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        monStage=primaryStage;
        Scene maScene = new Scene((Parent)FXMLLoader.load(getClass().getResource("/ressources/FXML/MainMenu.fxml")));
        monStage.setScene(maScene);
        monStage.show();
        
    }
    
    public static void main(String args[]) {
        Application.launch(args);
    }
    
    public static Stage getPrimaryStage(){
        
        return monStage;
    }
}
