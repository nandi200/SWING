/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author erand
 */
public class ColorBoxes extends JFrame {
  public ColorBoxes(int pause, int grid) {
    setTitle("ColorBoxes");
    Container cp = getContentPane();
    cp.setLayout(new GridLayout(grid, grid));
    for (int i = 0; i < grid * grid; i++)
      cp.add(new CBox(pause));
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }   
  public static void main(String[] args) {
    int pause = 50;
    int grid = 8;
    if(args.length > 0) 
      pause = Integer.parseInt(args[0]);
    if(args.length > 1)
      grid = Integer.parseInt(args[1]);
    JFrame frame = new ColorBoxes(pause, grid);
    frame.setSize(500, 400);
    frame.setVisible(true);  
  }
}