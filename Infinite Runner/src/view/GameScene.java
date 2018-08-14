/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.io.IOException;
import java.util.logging.Level;

import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import launch.Main;
import modele.game.Player;

import utils.manager.GameManager;

public class GameScene {
    
    private final ObjectProperty<Player> currentPlayer = new SimpleObjectProperty<>(new Player("default",0));
        public final Player getMonJoueur() {return currentPlayer.get();}
        public final void setMonJoueur(Player  value) { currentPlayer.set(value); }
        public ObjectProperty currentPlayerProperty() {return currentPlayer;}
    
    @FXML
    private Label playerLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label healthLabel;
    @FXML
    private Canvas gameCanvas;
    
    
    
    private AudioClip soundPlayer;
    private GraphicsContext gameArea;
    private GameManager gm;
    
    
    
    public void setSelectedLevel(modele.game.Level SelectedLevel){
       
        StringConverter<Number> converter = new NumberStringConverter();
        
        gm = new GameManager(gameArea,SelectedLevel);
        
        Main.getPrimaryStage().setMinWidth(SelectedLevel.getWidth());
        Main.getPrimaryStage().setMinHeight(SelectedLevel.getHeight());
        gameCanvas.widthProperty().bindBidirectional(SelectedLevel.widthProperty());
        gameCanvas.heightProperty().bindBidirectional(SelectedLevel.heightProperty());
        
        currentPlayer.get().meilleurScoreProperty().bind(gm.getEnv().scoreProperty());
        soundPlayer=new AudioClip(getClass().getResource("/ressources/sounds/hurt.mp3").toString());
        
        scoreLabel.textProperty().bind(Bindings.format("%d",currentPlayer.get().meilleurScoreProperty()));
        healthLabel.textProperty().bind(Bindings.format("%d",gm.getEnv().healthProperty()));
        gm.getEnv().healthProperty().addListener((o,oldV,newV)->{
            soundPlayer.play();
            if(newV.intValue()==0){
               
                try {
                    gameOver();
                } catch (IOException ex) {
                    Logger.getLogger(GameScene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameScene.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    public void setJoueur(Player p){
        currentPlayer.set(p);
        playerLabel.textProperty().set(currentPlayer.get().getPseudo());
    }
    
    @FXML
    private void keyPressedListener(KeyEvent event) throws InterruptedException {
        gm.setInputEvent(event);
        if("SPACE".equals(event.getCode().toString())){
            
            onPressedPause();
        } 
        
    }
    
    @FXML
    private void onPressedPause() throws InterruptedException{
        gm.getUpdateMan().stopLoop();
    }
    
    @FXML
    private void keyReleasedListener(KeyEvent event) throws InterruptedException{
        gm.removeInputEvent(event);
        
        
    }
    
    
    @FXML
    private void gameOver() throws InterruptedException, IOException{    
        gm.getUpdateMan().stopLoop();
        Scene maScene = new Scene((Parent)FXMLLoader.load(getClass().getResource("/ressources/FXML/MainMenu.fxml")));
        Main.getPrimaryStage().setTitle("Menuz");
        Main.getPrimaryStage().setScene(maScene);
        
    }
    
    
    @FXML
    public void initialize() {
         gameArea=gameCanvas.getGraphicsContext2D(); 
    }    
    
}
