
import java.util.Scanner;


/**
 *
 * Reader singleton service to read from console Scaner input
 * 
 * @author Jose Libreros
 */
public class Reader {

    private Scanner lector = new Scanner(System.in);
    private static Reader reader;
    
    //Private constructor. It does not allow generating default constructor
    private Reader() { 
        
    }
    
    public static Reader get() {
        if (reader == null){
            reader = new Reader();
        }
        return reader;
    }
    
    public String next(){
        return lector.next();
    }
}