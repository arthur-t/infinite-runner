package utils.manager;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.KeyEvent;

public class InputsManager {
    
    private final List<String> inputs = new ArrayList<>();

    public List<String> getInputs() {
        return inputs;
    }
    
    public void manageInputPressed(KeyEvent event){
        
        String code = event.getCode().toString();
        if (!inputs.contains(code))
            inputs.add(code);
    }
    
    public void manageInputReleased(KeyEvent event){
        String code = event.getCode().toString();
        inputs.remove(code);
    }
    
   
         
}
