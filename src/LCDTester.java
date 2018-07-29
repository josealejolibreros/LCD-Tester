
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {

    static final String CADENA_FINAL = "0,0";

    public static void main(String[] args) {
        LCDTester lcdTester = new LCDTester();
        lcdTester.readByConsoleAndExecuteLCD();

    }

    public void readByConsoleAndExecuteLCD() {
        // Establece los segmentos de cada numero
        int espacioDig = readSpaceBetweenDigitsByConsole();

        try {
            //int espacioDig2 = readByConsoleSpaceBetweenDigits();
            List<String> listaComando = readDigitsByConsole();

            ImpresorLCD impresorLCD = new ImpresorLCD();

            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext()) {
                try {

                    impresorLCD.procesar(iterator.next(), espacioDig);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

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

    public List<String> readDigitsByConsole() {

        String comando = "";

        List<String> listaComando = new ArrayList<>();
        Reader lector = Reader.get();

        try {

            do {
                System.out.print("Entrada: ");
                comando = lector.next();
                if (!comando.equalsIgnoreCase(CADENA_FINAL)) {
                    listaComando.add(comando);
                }
            } while (!comando.equalsIgnoreCase(CADENA_FINAL));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaComando;
    }

}
