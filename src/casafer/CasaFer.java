/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casafer;

import casafer.telas.Principal;
import java.util.ArrayList;
import javax.swing.UIManager;

/**
 *
 * @author bedim
 */
public class CasaFer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Principal principal = new Principal();
        principal.setVisible(true);
        
        
        

        
    }
    
}
