/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentesswing;

//importar el paquete swing
import javax.swing.*;
/**
 *
 * @author erandi
 */
public class ComponentesSWING {
     private static void createAndShowGUI() {
        //Crea una ventana.
        JFrame frame = new JFrame("HelloWorldSwing");
        //botones de  cierre de ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Agrega una etiqueda de saludo
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
 
        //Muestra la ventana
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        //Agrega un trabajo al disparador de eventos
        //Crea y muestra la interfaz gráfica
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        }); }  
}
