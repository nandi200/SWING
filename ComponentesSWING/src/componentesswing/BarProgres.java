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
public class BarProgres extends Thread {  //extiende de Tread
    
    private int seg;//segundo que lleva de progreso
    private JProgressBar jProgressBar1;  //componente
    
    public BarProgres (JProgressBar jProgressBar1){  //componente
            this.jProgressBar1=jProgressBar1;
    }
    @Override
    public void run(){  //sobre escribir el método run()
        for (int seg = 0; seg < 100; seg++) {
   
            try {
                jProgressBar1.setValue(seg);  //envía el progreso a la barra
                Thread.sleep(50);             //duerme la ejecución del hilo
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                System.out.println("Error ");
            }

        }
    }
    
}
