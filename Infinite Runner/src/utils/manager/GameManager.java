package utils.manager;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import modele.game.EntitiesEnvironment;
import modele.game.Environment;
import modele.game.Level;

public class GameManager {
    
    private UpdateManager updateMan;

    
    private Environment env;


    public GameManager(GraphicsContext GameArea,  Level Level ){
        env=new EntitiesEnvironment(Level);
        updateMan= new UpdateManager(env,GameArea);
    }
   
    public Environment getEnv() {
        return env;
    }
    
    public void setEnv(Environment env) {
        this.env = env;
    }
    
    public UpdateManager getUpdateMan(){
        return updateMan;
    }
    
    public void setUpdateMan(UpdateManager updateMan) {
        this.updateMan = updateMan;
    }

    public void setInputEvent(KeyEvent InputEvent){
        
        updateMan.setInput(InputEvent);
    }
    
    public void removeInputEvent(KeyEvent InputEvent){
        
        updateMan.removeInput(InputEvent);
    }
    
    
}
    

