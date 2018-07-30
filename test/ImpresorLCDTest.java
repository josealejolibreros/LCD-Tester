/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jose Libreros
 */
public class ImpresorLCDTest {
    
    public ImpresorLCDTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }




    /**
     * Test of validateAndSplitCommand method, of class ImpresorLCD.
     */
    @Test
    public void testValidateAndSplitCommand() {
        System.out.println("validateAndSplitCommand");
        String command = "2,123";
        ImpresorLCD instance = new ImpresorLCD();
        String[] expResult = {"2","123"};
        String[] result = instance.validateAndSplitCommand(command);
        assertArrayEquals(expResult, result);
        
        
    }
    
    
    /**
     * Test of validateAndSplitCommand method, of class ImpresorLCD.
     */
    @Test
    public void test2ValidateAndSplitCommand() {
        System.out.println("validateAndSplitCommand test of fail input");
        String command = "212";
        ImpresorLCD instance = new ImpresorLCD();
        String expResult = "Cadena " + command +" no contiene "
                + "caracter ,";
        String result = "";
        try{
            instance.validateAndSplitCommand(command);
        }catch(IllegalArgumentException e){
            result = e.getMessage();
        }
        assertEquals(expResult, result);
        
        
    }
    
    
    /**
     * Test of validateAndSplitCommand method, of class ImpresorLCD.
     */
    @Test
    public void test3ValidateAndSplitCommand() {
        System.out.println("validateAndSplitCommand test of fail input with , "
                + "and no message to be printed");
        String command = "2,";
        ImpresorLCD instance = new ImpresorLCD();
        String expResult = "Cadena " + command +" no contiene "
                + "los parametros requeridos";
        String result = "";
        try{
            instance.validateAndSplitCommand(command);
        }catch(IllegalArgumentException e){
            result = e.getMessage();
        }
        assertEquals(expResult, result);
        
        
    }
    
    /**
     * Test of validateAndSplitCommand method, of class ImpresorLCD.
     */
    @Test
    public void test4ValidateAndSplitCommand() {
        System.out.println("validateAndSplitCommand test of fail input with , "
                + "and no message to be printed");
        String command = "2,1234,1";
        ImpresorLCD instance = new ImpresorLCD();
        String expResult = "Cadena " + command +" contiene "
                + "mas caracter ,";
        String result = "";
        try{
            instance.validateAndSplitCommand(command);
        }catch(IllegalArgumentException e){
            result = e.getMessage();
        }
        assertEquals(expResult, result);
        
        
    }
    
    
    /**
     * Test of validateAndSplitCommand method, of class ImpresorLCD.
     */
    @Test
    public void test5ValidateAndSplitCommand() {
        System.out.println("validateAndSplitCommand test of fail input with , "
                + "and no message to be printed");
        String command = "0,1234";
        int tam = 0;
        ImpresorLCD instance = new ImpresorLCD();
        String expResult = "El parametro size ["+tam
                        + "] debe estar entre 1 y 10";
        String result = "";
        try{
            instance.validateAndSplitCommand(command);
        }catch(IllegalArgumentException e){
            result = e.getMessage();
        }
        assertEquals(expResult, result);
        
        
    }
    
    

    /**
     * Test of isNumeric method, of class ImpresorLCD.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        String cadena = "1a";
        boolean expResult = false;
        boolean result = ImpresorLCD.isNumeric(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail. 
    }
    
}
