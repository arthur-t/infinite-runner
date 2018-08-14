package modele.game;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LevelGroup {

    private final ObservableList<Level> levelsObs = FXCollections.observableArrayList();
    
    private final ListProperty<Level> levels = new SimpleListProperty<>(levelsObs);
        public ObservableList<Level> getLevels() {return levels.get();}
        public ReadOnlyListProperty<Level> levelsProperty() {return levels;}

    public LevelGroup() {
        this.levelsObs.add(new Level("Space Level", 25,new NamedImage("/ressources/images/space.png"),900,506));
        this.levelsObs.add(new Level("Cavern Level", 72,new NamedImage("/ressources/images/cavern.png"),900,506));
        this.levelsObs.add(new Level("City Level", 42,new NamedImage("/ressources/images/city.png"),900,506));
    }
    
    public void addLevel(Level lvl){
            levelsObs.add(lvl);
    }

}
