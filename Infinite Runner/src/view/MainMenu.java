package view;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import launch.Main;

public class MainMenu{
   
  
    @FXML
    private void clickClassement() throws IOException{        
        Scene maScene = new Scene((Parent)FXMLLoader.load(getClass().getResource("/ressources/FXML/RankingView.fxml")));
        Main.getPrimaryStage().setTitle("Classement");
        Main.getPrimaryStage().setScene(maScene);
        Main.getPrimaryStage().show();
    }

    @FXML
    private void clickPseudo() throws IOException{
        Scene maScene = new Scene((Parent)FXMLLoader.load(getClass().getResource("/ressources/FXML/EnterPseudo.fxml")));
        Main.getPrimaryStage().setTitle("Pseudo");
        Main.getPrimaryStage().setScene(maScene);
        Main.getPrimaryStage().show();
    }
    @FXML
    private void clickQuit(){
        
        Main.getPrimaryStage().close();
    }
    
    @FXML
    public void initialize() {
        Main.getPrimaryStage().setMinWidth(640);
        Main.getPrimaryStage().setMinHeight(480);
    }
  
    
    
}
