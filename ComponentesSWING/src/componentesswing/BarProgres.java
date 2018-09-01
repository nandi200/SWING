/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentesswing;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author erand
 */
public class BarProgres extends Thread {
    
    private int seg;
    private JProgressBar jProgressBar1;
    
    public BarProgres (JProgressBar jProgressBar1){
            this.jProgressBar1=jProgressBar1;
    }
    @Override
    public void run(){
        for (int seg = 0; seg < 100; seg++) {
            try {
                jProgressBar1.setValue(seg);
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(BarProgres.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
