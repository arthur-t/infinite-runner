package modele.game;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author pipayrard
 */
public class Ranking {
   
    private ObservableList<Player> playersObs = FXCollections.observableArrayList();
    private final ListProperty<Player> players = new SimpleListProperty<>(playersObs);
        public ObservableList<Player> getPlayers() {return players.get();}
        public ReadOnlyListProperty<Player> playersProperty() {return players;}
    
    
    public Ranking() {
        Player p1 = new Player("Jean", 100);
        addPlayer(p1);
        Player p2 = new Player("Michel", 6000);
        addPlayer(p2);
    }
    
    public void addPlayer(Player p){
        playersObs.add(p);
        p.incrementPlayer();
    }
    
    public void removePlayer(Player p){
        Boolean removed=playersObs.remove(p);
        if (removed){
            p.decrementPlayer();
        }
    }
    
}
