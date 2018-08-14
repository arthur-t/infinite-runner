package utils.manager;

import exceptions.InvalidPosException;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import modele.game.Environment;
import util.Displayer;

public class UpdateManager {
    
    private final Displayer afficheur=new Displayer();
   
    private GraphicsContext gameArea;
    private AnimationTimer loop;
    private Boolean paused=false;
    private Environment gameEnv;
    private InputsManager inMan;    
    
    public UpdateManager(Environment GameEnv, GraphicsContext GameArea){
        gameEnv=GameEnv;
        gameArea=GameArea;
        inMan=new InputsManager();
        addLoop();
    }
    
    public GraphicsContext getGameArea() {
        return gameArea;
    }

    public void setGameArea(GraphicsContext gameArea) {
        this.gameArea = gameArea;
    }

    public AnimationTimer getLoop() {
        return loop;
    }

    public void setLoop(AnimationTimer loop) {
        this.loop = loop;
    }

    public Environment getGameEnv() {
        return gameEnv;
    }

    public void setGameEnv(Environment gameEnv) {
        this.gameEnv = gameEnv;
    }

    public InputsManager getInMan() {
        return inMan;
    }

    public void setInMan(InputsManager inMan) {
        this.inMan = inMan;
    }
    
    public void addLoop(){
        final long startNanoTime = System.nanoTime();
        loop = new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 

                updateGraphics();
                try {
                    gameEnv.updateEnv(inMan.getInputs());
                } catch (InvalidPosException ex) {
                    System.err.println(ex.getMessage());
                }
                
                

            }
        };loop.start();
    }
    
    public void stopLoop() throws InterruptedException{
        
        if(paused){
            loop.start();
            paused=false;
        }
        else{
            loop.stop();
            paused=true;
        }
    }
    
    
    
    
    
    private void updateGraphics(){    
        gameArea.clearRect(0, 0, 2000, 2000);
        displayLevel();
    }
    
    
    private void displayLevel(){
        afficheur.displaySingle(gameEnv.getLevel().getTheme(),gameArea);
        afficheur.displayMultiple(gameEnv.getListElements(),gameArea);
    }
    
    public void setInput(KeyEvent event){
        inMan.manageInputPressed(event);
    }
    
    public void removeInput(KeyEvent event){
        inMan.manageInputReleased(event);
    }
    
    
}
