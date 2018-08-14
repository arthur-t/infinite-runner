
package view;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import launch.Main;
import modele.game.Ranking;
import modele.game.Player;

/**
 * FXML Controller class
 *
 * @author pipayrard
 */
public class RankingView {
    @FXML
    TableView<Player> myTable;
    @FXML
    TableColumn<Player,String> columnPlayer = new TableColumn<Player,String>("pseudo");
    @FXML
    TableColumn<Player,Integer> columnScore = new TableColumn<Player,Integer>("meilleurScore");
    private Ranking players = new Ranking();
    
    @FXML
    private void onQuit() throws IOException{
        Scene maScene = new Scene((Parent)FXMLLoader.load(getClass().getResource("/ressources/FXML/MainMenu.fxml")));
        Main.getPrimaryStage().setTitle("Menu");
        Main.getPrimaryStage().setScene(maScene);
    }
    
    @FXML
    public void initialize() {
       columnPlayer.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
       myTable.getColumns().add(columnPlayer);
       
       columnScore.setCellValueFactory(new PropertyValueFactory<>("meilleurScore"));
       myTable.getColumns().add(columnScore);
       
       myTable.itemsProperty().bind(players.playersProperty());
       
    }    
    
}
