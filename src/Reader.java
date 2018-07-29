
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MMV Lab
 */
public class Reader {

    private Scanner lector = new Scanner(System.in);
    private static Reader reader;

    // El constructor es privado, no permite que se genere un constructor por defecto.
    private Reader() {
        
        
    }

    public static Reader get() {
        if (reader == null){
            reader = new Reader();
        }
        else{
            //System.out.println("No se puede crear el objeto porque ya existe un objeto de la clase Reader");
        }
        
        return reader;
    }
    
    public String next(){
        return lector.next();
    }
    
    // metodos getter y setter

}