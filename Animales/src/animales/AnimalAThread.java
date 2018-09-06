/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author erand
 */
public class AnimalAThread extends Thread {
private String nombre;
private int limite;
private JLabel label;
private int retardo;

public AnimalAThread(String nombre, int limite, JLabel label, int retardo){
    this.nombre=nombre;
    this.limite=limite;
    this.label=label;
    this.retardo=retardo;
}
@Override
public void run(){
    for (int i = 0; i < limite; i++) {
        try {
            System.out.println(nombre + " avanza");
            label.setLocation(i, 0);
            Thread.sleep(retardo);
        } catch (InterruptedException ex) {
            Logger.getLogger(AnimalAThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    System.out.println(nombre + " ha llegado a la meta ");
    JOptionPane.showMessageDialog(null, nombre + " ha llegado a la meta ");
    yield(); // alterna el procesamiento de los hilos
}    
}
