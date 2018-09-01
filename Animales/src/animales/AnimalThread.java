/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import static java.lang.Thread.yield;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author erand
 */
public class AnimalThread extends Thread {

    private String nombre;
    private int limite;

    public AnimalThread(String nombre, int limite) {
        this.nombre = nombre;
        this.limite = limite;
    }

    @Override
    public void run() {
        for (int i = 0; i < limite; i++) {
                System.out.println(nombre + " avanza");
        }
        System.out.println(nombre + " ha llegado a la meta ");
        yield(); // alterna el procesamiento de los hilos
    }
}
