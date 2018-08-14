
package modele.game;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {
    private static int playerCounter;

    
    
    private final StringProperty pseudo = new SimpleStringProperty();
        public String getPseudo() {return pseudo.get();}
        public void setPseudo(String value) {pseudo.set(value); }
        public StringProperty pseudoProperty() {return pseudo;}
    
    private IntegerProperty bestScore = new SimpleIntegerProperty();
        public Integer getMeilleurScore() {return bestScore.get();}
        public void setMeilleurScore(Integer value) {bestScore.set(value);}
        public IntegerProperty meilleurScoreProperty() {return bestScore;}
    
    public Player(String nom, int score){
        this.setPseudo(nom);
        this.setMeilleurScore(score);
    }

    public static int getPlayerCounter() {
        return playerCounter;
    }
    
    public void incrementPlayer(){
        playerCounter++;
    }
    
    public void decrementPlayer(){
        playerCounter--;
    }

    
}
