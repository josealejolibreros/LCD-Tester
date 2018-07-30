package Numbers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Abstract class that represents any character (numbers, letters and others)
 * 
 * @author Jose Libreros
 */
public abstract class CharacterAbstract {
    
    public abstract void structureCharacters();
    
    List<Integer> segList = new ArrayList<>();
    
    public List<Integer> getSegList(){
        return segList;
    }   
    
}
