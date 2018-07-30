
public class ImpresorLCD{
  
    private String[][] matrizImpr;
   
    public ImpresorLCD() {
       
    }
    
    /**
     * Print the given number on the LCD screen
     */
    public void printDisplayMatrix(){
         // Imprime matriz
        for (int i = 0; i < matrizImpr.length; i++) {
            for (int j = 0; j < matrizImpr[i].length; j++) {
                System.out.print(this.matrizImpr[i][j]);
            }
            System.out.println();
        }
    }

     /**
     * Metodo encargado de procesar la entrada que contiene el size del segmento
     * de los digitos y los digitos a imprimir
     *
     * @param comando Entrada que contiene el size del segmento de los digito
     * y el numero a imprimir
     * @param espacioDig Espacio Entre digitos
     */  
    public void processCommand(String comando, int espacioDig) {
      
        String[] parametros = validateAndSplitCommand(comando);
        int size = Integer.parseInt(parametros[0]);
        String msgToPrint = parametros[1];
        
        
        // Perform message printing
        LCDCharactersProcessor command = new LCDCharactersProcessor();
        command.fillDisplayMatrix(size, msgToPrint,espacioDig);
        matrizImpr = command.getLCDMatrixFilled();
        System.out.println("\n");
        printDisplayMatrix();       

    }
    
    /**
     * Validate if the input command has the form 
     * <size>,<number> <size>,<number>*
     * If so, split and return the array
     * 
     * 
     * @param command Input command to be printed
     * @return parameters validated and separated command
     */
    public String[] validateAndSplitCommand(String command){
        int tam;
        String[] parametros;
        
        if (!command.contains(",")) {
            throw new IllegalArgumentException("Cadena " + command
                    + " no contiene caracter ,");
        }
        
        //Se hace el split de la cadena
        parametros = command.split(",");
        
        //Valida la cantidad de parametros
        if(parametros.length>2){
           throw new IllegalArgumentException("Cadena " + command
                    + " contiene mas caracter ,"); 
        }
        
        //Valida la cantidad de parametros
        if(parametros.length<2){
           throw new IllegalArgumentException("Cadena " + command
                    + " no contiene los parametros requeridos"); 
        }
        
        //Valida que el parametro size sea un numerico
        if(isNumeric(parametros[0])){
            tam = Integer.parseInt(parametros[0]);
            
            // se valida que el size este entre 1 y 10
            if(tam <1 || tam >10){
                throw new IllegalArgumentException("El parametro size ["+tam
                        + "] debe estar entre 1 y 10");
            }
        }
        else{
            throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                    + "] no es un numero");
        }
                
        return parametros;
    }

    /**
     *
     * Metodo encargado de validar si una cadena es numerica
     *
     * @param cadena Cadena
     */  
    static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
}