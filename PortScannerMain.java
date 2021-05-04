/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Malik Fomin
 */
public class PortScannerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PortScanner portScanner = new PortScanner(args);        
        portScanner.scan();
    }
    
}
