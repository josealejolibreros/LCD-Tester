
import Numbers.CharacterAbstract;
import Numbers.Eight;
import Numbers.Five;
import Numbers.Four;
import Numbers.Nine;
import Numbers.One;
import Numbers.Seven;
import Numbers.Six;
import Numbers.Three;
import Numbers.Two;
import Numbers.Zero;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Class that allows to process the given and validated command and build the
 * LCD representation matrix
 * 
 * @author Jose Libreros
 */
public class LCDCharactersProcessor extends CharacterAbstractFactory{

    // Puntos fijos
    private final int[] pf1;
    private final int[] pf2;
    private final int[] pf3;
    private final int[] pf4;
    private final int[] pf5;
    private String[][] matrizImpr;

    

    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";

    // TODO code application logic here
    //String entrada = JOptionPane.showInputDialog("Digite el numero");
    private int size;

    // Calcula el numero de filasDig
    private int filasDig;
    private int columDig;
    private int totalFilas;
    private int totalColum;

    public LCDCharactersProcessor() {
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
    }
    
    public String[][] getLCDMatrixFilled() {
        return matrizImpr;
    }
    
    
    /**
     *
     * Build the display matrix according with the fiven number
     *
     * @param size TamaÃ±o Segmento Digitos
     * @param messagetoBePrinted Numero a Imprimir
     * @param espacio Espacio Entre digitos
     */    
    public void fillDisplayMatrix(int size, String messagetoBePrinted, int espacio) 
    {
        int pivotX = 0;
        char[] digitos;

        
        initialiseMatrix(size, messagetoBePrinted, espacio);
        
        // crea el arreglo de digitos
        digitos = messagetoBePrinted.toCharArray();
        
        for (char digito : digitos) {
            
            //Valida que el caracter sea un digito
            if( ! Character.isDigit(digito)){
                throw new IllegalArgumentException("Caracter " + digito
                    + " no es un digito");
            }

            int numero = Integer.parseInt(String.valueOf(digito));

            //Calcula puntos fijos
            this.pf1[0] = 0;
            this.pf1[1] = 0 + pivotX;

            this.pf2[0] = (this.filasDig / 2);
            this.pf2[1] = 0 + pivotX;

            this.pf3[0] = (this.filasDig - 1);
            this.pf3[1] = 0 + pivotX;

            this.pf4[0] = (this.columDig - 1);
            this.pf4[1] = (this.filasDig / 2) + pivotX;

            this.pf5[0] = 0;
            this.pf5[1] = (this.columDig - 1) + pivotX;

            pivotX = pivotX + this.columDig + espacio;

            addCharacterToBePrinted(numero);
        }

        
    }
    
    /**
     * Initialise the matrix according with the given size, space among lines 
     * and the message to be printed
     * 
     * @param size
     * @param messageToBePrinted
     * @param espacio 
     */
    private void initialiseMatrix(int size, String messageToBePrinted, int espacio){
        this.size = size;

        // Calcula el numero de filas cada digito
        this.filasDig = (2 * this.size) + 3;

        // Calcula el numero de columna de cada digito
        this.columDig = this.size + 2;

        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        this.totalFilas = this.filasDig;

        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        this.totalColum = (this.columDig * messageToBePrinted.length())
                + (espacio * messageToBePrinted.length());

        // crea matriz para almacenar los numero a imprimir
        this.matrizImpr = new String[this.totalFilas][this.totalColum];
        
        // Inicializa matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                this.matrizImpr[i][j] = " ";
            }
        }
    }
       
    /**
     *
     * Metodo encargado de definir los segmentos que componen un caracter y
     * a partir de los segmentos adicionar la representacion del caracter a la matriz
     *
     * @param character Digito
     */
    private void addCharacterToBePrinted(int character) {
        
        CharacterAbstract concreteCharacter = createAndStructureCharacters(character);
        Iterator<Integer> iterator = concreteCharacter.getSegList().iterator();

        while (iterator.hasNext()) {
            adicionarSegmento(iterator.next());
        }
        
    }
    
    /**
     *
     * Metodo encargado de un segmento a la matriz de Impresion
     *
     * @param segmento Segmento a adicionar
     */  
    private void adicionarSegmento(int segmento) {
        
        switch (segmento) {
            case 1:
                adicionarLinea(this.matrizImpr, this.pf1, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 2:
                adicionarLinea(this.matrizImpr, this.pf2, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 3:
                adicionarLinea(this.matrizImpr, this.pf5, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 4:
                adicionarLinea(this.matrizImpr, this.pf4, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 5:
                adicionarLinea(this.matrizImpr, this.pf1, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 6:
                adicionarLinea(this.matrizImpr, this.pf2, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 7:
                adicionarLinea(this.matrizImpr, this.pf3, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }
    
    
    /**
     *
     * Metodo encargado de aÃ±adir una linea a la matriz de Impresion
     *
     * @param matriz Matriz Impresion
     * @param punto Punto Pivote
     * @param posFija Posicion Fija
     * @param size TamaÃ±o Segmento
     * @param caracter Caracter Segmento
     */    
    private void adicionarLinea(String[][] matriz, int[] punto, String posFija,
            int size, String caracter) {

        if (posFija.equalsIgnoreCase(POSICION_X)) 
        {
            for (int y = 1; y <= size; y++) 
            {
                int valor = punto[1] + y;
                matriz[punto[0]][valor] = caracter;
            }
        } 
        else 
        {
            for (int i = 1; i <= size; i++) 
            {
                int valor = punto[0] + i;
                matriz[valor][punto[1]] = caracter;
            }
        }
    }
    
    /**
     * Create and structure the representation on LCD of each given character. 
     * Calls the implementations of the characters on LCD. In the future can be
     * represent other character. At the moment represents digits
     * 
     * @param charToCreate
     * @return 
     */
    @Override
    public CharacterAbstract createAndStructureCharacters(int charToCreate) {

        CharacterAbstract characterObject;
        switch (charToCreate) {
            case 1:
                characterObject = new One();
                break;
            case 2:
                characterObject = new Two();
                break;
            case 3:
                characterObject = new Three();
                break;
            case 4:
                characterObject = new Four();
                break;
            case 5:
                characterObject = new Five();
                break;
            case 6:
                characterObject = new Six();
                break;
            case 7:
                characterObject = new Seven();
                break;
            case 8:
                characterObject = new Eight();
                break;
            case 9:
                characterObject = new Nine();
                break;
            case 0:
                characterObject = new Zero();
                break;
            default:
                characterObject = null;
                break;
        }
        characterObject.structureCharacters();
        return characterObject; 
    }
    
}