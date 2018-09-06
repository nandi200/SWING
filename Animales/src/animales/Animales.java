/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

/**
 *
 * @author erandi
 * 
 */
public class Animales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnimalThread conejo = new AnimalThread("conejo",100);
        AnimalThread tortuga = new AnimalThread("tortuga",100);
        AnimalThread zorro = new AnimalThread("zorro",100);
       
        conejo.start();
        tortuga.start();
        zorro.start();
        System.out.println("Se ha terminado la carrera");
    }
    
}
