
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MMV Lab
 */
public class LCDInput {

    static final String CADENA_FINAL = "0,0";

    /**
     * Read by console the input parameters and execute LCD printer
     */
    public void readByConsoleAndExecuteLCD() {
        // Establece los segmentos de cada numero
        int espacioDig = readSpaceBetweenDigitsByConsole();

        try {
            List<String> listaComando = readDigitsByConsole();
            executeLCD(listaComando, espacioDig);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    /**
     * Execute the LCD proccesor
     * @param listaComando
     * @param espacioDig 
     */
    public void executeLCD(List<String> listaComando, int espacioDig) {
        ImpresorLCD impresorLCD = new ImpresorLCD();
        Iterator<String> iterator = listaComando.iterator();
        
        while (iterator.hasNext()) {
            impresorLCD.processCommand(iterator.next(), espacioDig);
        }
    }

    
    /**
     * Read by console the space between digits and returns it as int
     * @return spaceBetweenDigits
     */
    public int readSpaceBetweenDigitsByConsole() {
        int spaceBetweenDigits = 0;
        String comando = "";
        Reader lector = Reader.get();
        boolean numberNotChecked = true;
        do {
            System.out.print("Espacio entre Digitos (0 a 5): ");
            comando = lector.next();

            // Valida si es un numero
            if (ImpresorLCD.isNumeric(comando)) {
                spaceBetweenDigits = Integer.parseInt(comando);

                // se valida que el espaciado este entre 0 y 5
                if (spaceBetweenDigits < 0 || spaceBetweenDigits > 5) {
                    System.out.println("El espacio entre "
                            + "digitos debe estar entre 0 y 5");
                } else {
                    numberNotChecked = false;
                }
            } else {
                System.out.println("Cadena " + comando
                        + " no es un entero");
            }
        } while (numberNotChecked);
        return spaceBetweenDigits;
    }

    
    /**
     * Read by console the characters to be printed. At the moment digits
     * @return commandsList given
     */
    public List<String> readDigitsByConsole() {

        String comando = "";

        List<String> commandsList = new ArrayList<>();
        Reader lector = Reader.get();

        try {

            do {
                System.out.print("Entrada: ");
                comando = lector.next();
                if (!comando.equalsIgnoreCase(CADENA_FINAL)) {
                    commandsList.add(comando);
                }
            } while (!comando.equalsIgnoreCase(CADENA_FINAL));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return commandsList;
    }

}
