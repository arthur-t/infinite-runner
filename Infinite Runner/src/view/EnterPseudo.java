
package view;

import java.io.IOException;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import launch.Main;
import modele.game.Player;

public class EnterPseudo {
    @FXML
    private Button validateButton;

    @FXML
    private TextField pseudoEntry;
  
    private final ObjectProperty<Player> currentPlayer = new SimpleObjectProperty<>(new Player("default",0));
        public final Player getMonJoueur() {return currentPlayer.get();}
        public final void setMonJoueur(Player  value) { currentPlayer.set(value); }
        public ObjectProperty currentPlayerProperty() {return currentPlayer;}

    
    @FXML
    private void clickValidate() throws IOException{
        currentPlayer.get().setPseudo(pseudoEntry.getText());
        Stage monStage = Main.getPrimaryStage();
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/ressources/FXML/LevelMenu.fxml"));
        LevelMenu nextScene = new LevelMenu();
        leLoader.setController(nextScene);
        GridPane pane = leLoader.load();
        Scene maScene =new Scene(pane);
        nextScene.setJoueur(currentPlayer.get());

        maScene.getRoot().requestFocus();
        monStage.setTitle("Menu niveaux");
        monStage.setScene(maScene);
    }
    
    @FXML
    public void initialize() {
        Main.getPrimaryStage().setMinWidth(360);
        Main.getPrimaryStage().setMinHeight(150);
        validateButton.disableProperty().bind(Bindings.isEmpty(pseudoEntry.textProperty()));   
    }    
}
