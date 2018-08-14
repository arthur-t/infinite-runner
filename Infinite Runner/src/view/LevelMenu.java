package view;

import java.io.IOException;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import launch.Main;
import modele.game.Element;
import modele.game.LevelGroup;
import modele.game.Player;
import modele.game.Level;
import modele.game.NamedImage;
import modele.game.ThemeList;
import utils.converter.ElementStringConverter;

public class LevelMenu{

    @FXML
    private ListView<Level> levels;
    
    @FXML
    private TextField myLevel;
    
    @FXML 
    private Slider mySlider;
    
    @FXML
    private ChoiceBox<Element> themePicker;
    
    @FXML
    private TextField fieldDensity;
    
    @FXML
    private Label labelDensity;
    
    
    
    
    private Player currentPlayer;
    private final BooleanProperty isEmptyLevelName = new SimpleBooleanProperty();
        private boolean isIsEmptyLevelName() {return isEmptyLevelName.get();}
        private void setIsEmptyLevelName(boolean value) { isEmptyLevelName.set(value); }
        private BooleanProperty isEmptyLevelNameProperty() {return isEmptyLevelName;}
    
    private final ObjectProperty<LevelGroup> levelModel = new SimpleObjectProperty<>(new LevelGroup());
        public LevelGroup getLevelModel() {return levelModel.get();}
        public void setLevelModel(LevelGroup value) { levelModel.set(value);}
        public ObjectProperty<LevelGroup> levelModelProperty() {return levelModel;}
    
    private final ObjectProperty<ThemeList> themesModel = new SimpleObjectProperty<>(new ThemeList());
        public ThemeList getThemesModel() { return themesModel.get(); }
        public void setThemesModel(ThemeList value) { themesModel.set(value); }
        public ObjectProperty<ThemeList> themesModelProperty() { return themesModel;}
        
    
    
        
    public void setJoueur(Player p){
        currentPlayer=p;
    }
    
    @FXML
    private void onClickAjouter(){
        levelModel.get().addLevel(new Level("Nouveau niveau",50,new NamedImage("/ressources/images/space.png"),900,506));
        levels.getSelectionModel().selectLast();
    }
    
    @FXML
    private void onClickSupprimer(){
        levelModel.get().getLevels().remove(levels.getSelectionModel().getSelectedIndex());
        levels.getSelectionModel().selectNext();
    }
        
    @FXML
    private void onClickValider() throws IOException{
        Stage monStage = Main.getPrimaryStage();
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/ressources/FXML/GameScene.fxml"));
        GameScene nextScene = new GameScene();
        
        leLoader.setController(nextScene);
        GridPane pane = leLoader.load();
        Scene maScene =new Scene(pane);
        nextScene.setSelectedLevel(levels.getSelectionModel().getSelectedItem());
        nextScene.setJoueur(currentPlayer);
        maScene.getRoot().requestFocus();
        monStage.setTitle("Runner");
        monStage.setScene(maScene);
    }
    
    
    
    @FXML
    public void initialize() {
        StringConverter<Element> sc = new ElementStringConverter();
        StringConverter<Number> dc = new NumberStringConverter();
        
        Main.getPrimaryStage().setMinWidth(600);
        Main.getPrimaryStage().setMinHeight(400);
       
        Bindings.bindBidirectional(fieldDensity.textProperty(), mySlider.valueProperty(),dc);
        labelDensity.textProperty().bind(Bindings.format("%.0f",mySlider.valueProperty()));
        isEmptyLevelName.bind(Bindings.isEmpty(myLevel.textProperty()));
        
        themePicker.setConverter(sc);
        
        myLevel.focusedProperty().addListener((o,oldV,newV)->{
            
            if(newV==false){
                if(isEmptyLevelName.get()){
                    myLevel.textProperty().set("Nouveau niveau");
                }
                
            }
                
            
        });

        levels.setCellFactory((value) -> {
            return new ListCell<Level>(){
                @Override
                protected void updateItem(Level item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        textProperty().bind(item.nameProperty());
                        
                    } else {
                        textProperty().unbind();
                        setText("");
                    }
                }
            };
                    
        });
        
        levels.getSelectionModel().selectedItemProperty().addListener((o,oldV,newV)->{
            if(oldV !=null){
                myLevel.textProperty().unbindBidirectional(oldV.nameProperty());
                mySlider.valueProperty().unbindBidirectional(oldV.densiteElementsProperty());
                themePicker.valueProperty().unbindBidirectional(oldV.themeProperty());   
            }
            if(newV!=null){
                myLevel.textProperty().bindBidirectional(newV.nameProperty());
                mySlider.valueProperty().bindBidirectional(newV.densiteElementsProperty());
                themePicker.valueProperty().bindBidirectional(newV.themeProperty());  
            }
        });
    }    
    
}
