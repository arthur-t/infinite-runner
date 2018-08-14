package utils.manager;

import exceptions.InvalidPosException;
import java.util.List;
import java.util.Random;
import modele.game.Element;
import modele.game.Entitie;

public class PhysicsManager {
    
    private static final int GRAVITY=1;
    
    public static void boundariesCollide(Entitie e, int leftBorder, int topBorder, int rightBorder, int bottomBorder){
         
        if(e.getX()+e.getHitbox().getOffSetX()<leftBorder){
            e.setX(leftBorder-e.getHitbox().getOffSetX());
        }
        if ( e.getX()+e.getWidth()-e.getHitbox().getOffSetX()>rightBorder){
            e.setX(rightBorder-e.getWidth()+e.getHitbox().getOffSetX());
        }
        if (e.getY()+e.getHitbox().getOffSetY()<topBorder){
            e.setY(topBorder-e.getHitbox().getOffSetY());
        }
        if (e.getY()+e.getHeight()-e.getHitbox().getOffSetY()>bottomBorder){
            e.setY(bottomBorder-e.getHeight()+e.getHitbox().getOffSetY());
        }
    }
    
    public static void scalingLeftInfinite(Element e, int speed, int unspawnPos, int spawnPos) throws InvalidPosException{
        
        if(spawnPos+e.getWidth()<unspawnPos){
            throw new InvalidPosException("Invalid spawn position");
        }
        
        if(e.getX()+e.getWidth()<=unspawnPos){
            e.setX(spawnPos);
        }

        e.setX(e.getX()-speed);

    }
    
    public static void scalingLeftRandom(Element e, int speed, int spawnPos, int unspawnPos, int lowLimit, int highLimit)throws InvalidPosException{
        
        if(spawnPos+e.getWidth()<unspawnPos){
            throw new InvalidPosException("Invalid spawn position");
        }
        
        if(e.getX()+e.getWidth()<unspawnPos){
            e.setX(spawnPos);
            randomVerticalSpawn(e,lowLimit,highLimit);
        }
        e.setX(e.getX()-speed);
    }
    
    public static void randomVerticalSpawn(Element e, int lowLimit, int highLimit){
        Random r= new Random();
        int spawnPos=r.nextInt(highLimit-lowLimit) + lowLimit;
        e.setY(spawnPos);
    }
    
    public static void controlEntitie(Element e, List<String> direction, int speed){       
        int movementX=0;
        int movementY=0;
        if (direction.contains("LEFT"))
            movementX=-speed;
        if (direction.contains("RIGHT"))
            movementX=speed;
        if (direction.contains("UP"))
            movementY=-speed;
        if (direction.contains("DOWN"))    
            movementY=speed;
        e.setX(e.getX()+movementX);
        e.setY(e.getY()+movementY);        
    }
    
    public static void applyPhysic(Element e){
        e.setY(e.getY()+GRAVITY);
    }
    
    public static Boolean collide(Entitie e1, Entitie e2){
        return e1.getHitbox().getBoundsInParent().intersects(e2.getHitbox().getBoundsInParent());
    }
}
