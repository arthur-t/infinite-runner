
package modele.game;


import exceptions.InvalidPosException;
import java.util.List;
import javafx.scene.image.Image;
import util.Filter;
import utils.manager.PhysicsManager;

public class EntitiesEnvironment extends Environment{

    private double obstacleSpeed; 
    private int healthTimer=0;
    private static final double OBSTACLE_ACCELERATION=0.001;
    
    public EntitiesEnvironment(Level Level) {
        
        super(Level);
  
        int nbObstacles=(int)Math.round(0.1*Level.getDensiteElements());
        
        for(int i=0;i<nbObstacles;i++){
            Obstacle o =new Obstacle(0,0,new Image("/ressources/images/smallComete.png"));
            o.setX(level.getWidth()+i*((level.getWidth()+o.getWidth())/nbObstacles));
            PhysicsManager.randomVerticalSpawn(o, 0, level.getHeight()-o.getHeight());
            listElements.add(o);
        }
        
        Character perso = new Character(0,level.getHeight()/2,new Image("/ressources/images/martien.png"),3);
        perso.setHitboxHeight(perso.getWidth()-perso.getHitbox().getOffSetX());
        this.healthProperty().bind(perso.healthProperty());
        
        listElements.add(perso);
        
        obstacleSpeed=level.getDensiteElements()*0.1;
        score.setValue(0);
    }
    
    public double getObstacleSpeed() {
        return obstacleSpeed;
    }

    public void setObstacleSpeed(double obstacleSpeed) {
        this.obstacleSpeed = obstacleSpeed;
    }

    public int getHealthTimer() {
        return healthTimer;
    }
    
    
    
    private void collideElements(Obstacle e){
                
        Filter.personnageFilter(listElements).forEach((Character p) ->{
            if(PhysicsManager.collide(e, p)){    
                if(healthTimer==0){
                    p.setHealth(p.getHealth()-1);
                    healthTimer=120;
                }
            }
                
        });
        
    }
    
    
    @Override
    public void updateEnv(List<String> controles)throws InvalidPosException{
        
        for(Obstacle o :Filter.obstacleFilter(listElements)) {
           
                PhysicsManager.scalingLeftRandom(o, (int)Math.round(obstacleSpeed), level.getWidth(), 0,0,level.getHeight()-o.getHeight());
            
            collideElements(o);
        }
        
        Filter.personnageFilter(listElements).forEach((Character p) ->{
                PhysicsManager.controlEntitie(p, controles, 6);
                PhysicsManager.applyPhysic(p);
                PhysicsManager.boundariesCollide(p,0,0,level.getWidth(),level.getHeight());
        });
        
        if (healthTimer>0){
            healthTimer--;
        }
        obstacleSpeed+=OBSTACLE_ACCELERATION;
        
      
        PhysicsManager.scalingLeftInfinite(level.getTheme(),1,level.getWidth(),0);
        score.setValue(score.getValue()+1);
        
    }
}
